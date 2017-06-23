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
        try{ 
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String negociar=request.getParameter("negociar");
         
         System.out.println("Negociando "+negociar);
         if(negociar!=null){                
           negociar(request, response);     
         }
        }catch(IOException ex){
            System.out.println("Error: "+ex);
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
            if(dineroANegociar!=null && campoPropiedad!=null && campoJugador!=null){
                for(Jugador jugador:jugadores){
                    //se le da el dinero al jugador propietario de la propiedad 
                    if(campoJugador.equals(jugador.getNombre())){
                        jugador.setDinero(jugador.getDinero()+Integer.valueOf(dineroANegociar));                        
                        //Se transfiere la propiedad
                        for(Propiedad propiedad:propiedades){
                            if(propiedad.getIdUsuario()==jugador.getId() && propiedad.getNombre().equals(campoPropiedad)){
                                propiedad.setIdUsuario(turnoDeJugador.getId());
                            }
                        }
                    }
                    //y se le resta el dinero al jugador que negocia.
                    if(turnoDeJugador.getId()==jugador.getId()){
                        jugador.setDinero(jugador.getDinero()-Integer.valueOf(dineroANegociar));                        
                    }
                }
            }
            request.getSession().setAttribute("listaJugadoresPartida", jugadores);
            request.getSession().setAttribute("listaPropiedades",propiedades);
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(NegociarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
