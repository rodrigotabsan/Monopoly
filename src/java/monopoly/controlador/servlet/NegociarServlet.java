/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.entidades.Propiedad;
import monopoly.util.UtilesServlets;

/**
 *
 * @author Rodrigo
 */
public class NegociarServlet  extends HttpServlet{

    /**
     * Procesa la petición
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         String negociar=request.getParameter("negociar");
         
         System.out.println("Negociando "+negociar);
         if(negociar!=null){                
           negociar(request, response);     
         }
        
     }
    
    /**
     * Utilizado para conocer la respuesta que se dará al pulsar el botón submit de negociar.
     * @param request peticion de la pagina
     * @param response respuesta de la pagina 
     */
    private void negociar(HttpServletRequest request, HttpServletResponse response){
        try {
            UtilesServlets utilServlet = new UtilesServlets();
            List<Jugador> jugadores=(List<Jugador>)request.getSession().getAttribute("listaJugadoresPartida");        
            List<Propiedad> propiedades=(List<Propiedad>)request.getSession().getAttribute("listaPropiedades");
            String dineroANegociar=request.getParameter("campoDineroANegociar");
            String campoPropiedad = request.getParameter("listaPropiedades");
            String campoJugador = request.getParameter("listaJugadores");
            Jugador turnoDeJugador = (Jugador) request.getSession().getAttribute("jugador");
            boolean error=false;
            int contadorCoincidenciasJugadores=0;
            for(Jugador jugador:jugadores){ 
                if(jugador.getNombre().equals(campoJugador)){
                    contadorCoincidenciasJugadores=1;
                }
            }
            if(contadorCoincidenciasJugadores==1){                        
                if(dineroANegociar!=null && campoPropiedad!=null && campoJugador!=null){
                    if(validarString(dineroANegociar)==true){
                        if(convertirStringAInteger(dineroANegociar)>0){
                            int dineroNegociado=convertirStringAInteger(dineroANegociar);
                            boolean transferido=false;
                            for(Jugador jugador:jugadores){                            
                                if((turnoDeJugador.getDinero()-dineroNegociado)>0){
                                    //se le da el dinero al jugador propietario de la propiedad 
                                    if(campoJugador.equals(jugador.getNombre())){                                                            
                                        //Se transfiere la propiedad
                                        int contadorCoincidenciasPropiedades=0;
                                        for(Propiedad propiedad:propiedades){  
                                            if(propiedad.getNombre().equals(campoPropiedad)){
                                                contadorCoincidenciasPropiedades++;
                                            }
                                        }
                                        if(contadorCoincidenciasPropiedades==0){
                                                request.getSession().setAttribute("mensajeErrorNegociar", "Escoja una propiedad de la lista, por favor. No ha seleccionado ninguna.");                                                                                            
                                                error=true;
                                        }
                                        for(Propiedad propiedad:propiedades){
                                            if(error!=true){
                                                if(contadorCoincidenciasPropiedades>0){
                                                    if(propiedad.getIdUsuario()==jugador.getId() && propiedad.getNombre().equals(campoPropiedad)){                                            
                                                        propiedad.setIdUsuario(turnoDeJugador.getId());
                                                        jugador.setDinero(jugador.getDinero()+dineroNegociado);
                                                        transferido=true;                                            
                                                    }
                                                } 
                                            }else{
                                                break;
                                            }
                                        }
                                    }
                                } 
                                if(error==true){
                                    break;
                                }
                            }
                            for(Jugador jugador:jugadores){
                                //se le resta el dinero al jugador que negocia.
                                if(turnoDeJugador.getId()==jugador.getId()){
                                    if((turnoDeJugador.getDinero()-dineroNegociado)<0){
                                        request.getSession().setAttribute("mensajeErrorNegociar", "El jugador no dispone de tanto dinero para negociar.");                                                                    
                                        error=true;
                                        break;
                                    }
                                    if(transferido==true && error!=true){                                    
                                            turnoDeJugador.setDinero(turnoDeJugador.getDinero()-dineroNegociado);                                     
                                    }

                                }
                                if(error==true){
                                    break;
                                }
                            }                        
                        }else{
                            request.getSession().setAttribute("mensajeErrorNegociar", "Para negociar una propiedad, se debe introducir una cifra superior a 0.");                                                                    
                            error=true;
                        }
                        request.getSession().setAttribute("listaJugadoresPartida", jugadores);
                        request.getSession().setAttribute("listaPropiedades",propiedades);
                    }else{
                        request.getSession().setAttribute("mensajeErrorNegociar", "La cifra introducida no es correcta.");                        
                        error=true;
                    }                   
                }
            }else{
                request.getSession().setAttribute("mensajeErrorNegociar", "Escoja un jugador de la lista, por favor. No ha seleccionado ninguno.");                                                                                            
                error=true;                
            }
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(NegociarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean validarString(String cadena) {
      try{
          int valor=Integer.parseInt(cadena);
          return true;
          
      }catch (NumberFormatException nfe){
          return false;
      }
    }
    public int convertirStringAInteger(String numero) {
      // Se reemplazan todos los caracteres que no correspondan a un numero
      // por espacio
      int valor=0;
      if(validarString(numero)==true){
          valor=Integer.parseInt(numero);
      }
      return valor;
   }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
