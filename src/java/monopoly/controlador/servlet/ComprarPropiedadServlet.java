/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

import java.io.IOException;
import java.util.List;
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
public class ComprarPropiedadServlet extends HttpServlet{

    /**
     * Proceso la petición
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        try{ 
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String finalizarCompra=request.getParameter("finalizarCompra");
         System.out.println("Se finaliza la compra "+finalizarCompra);
         if(finalizarCompra!=null){                
           realizarCompra(request, response);     
         }
        }catch(ServletException | IOException ex){
            System.out.println("Error: "+ex);
        }
         
     }
    
    /**
     * Realiza la compra
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     * @throws ServletException Excepcion en caso de error para los Servlets
     * @throws IOException Excepcion en caso de error de entrada y salida en el acceso a ficheros.
     */
    private void realizarCompra(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UtilesServlets utilServlet = new UtilesServlets();
        
        List<Jugador> jugadores=(List<Jugador>)request.getSession().getAttribute("listaJugadoresPartida");
        Jugador jugador = (Jugador)request.getSession().getAttribute("jugador");
        List<Propiedad> propiedades=(List<Propiedad>)request.getSession().getAttribute("listaPropiedades");
        //Se resta el dinero de la compra al jugador
        for(int i=0; i<jugadores.size();i++){
            for(int j=0; j<propiedades.size();j++){
                if(jugador.getId()==jugadores.get(i).getId() && 
                        jugadores.get(i).getIdCasilla()==propiedades.get(j).getIdCasilla() &&
                        (jugadores.get(i).getDinero()-propiedades.get(j).getPrecio())>0){
                    propiedades.get(j).setIdUsuario(jugadores.get(i).getId());
                    jugadores.get(i).setDinero(jugadores.get(i).getDinero()-propiedades.get(j).getPrecio());
                    //El jugador puede comprar
                    jugadores.get(i).setEstadoParaComprar(1);
                    System.out.println("La propiedad "+propiedades.get(j).getNombre()+" ha sido comprada por "+jugadores.get(i).getNombre());
                }
                if(jugador.getId()==jugadores.get(i).getId() && 
                        jugadores.get(i).getIdCasilla()==propiedades.get(j).getIdCasilla() &&
                        (jugadores.get(i).getDinero()-propiedades.get(j).getPrecio())<0){
                    System.out.println("El jugador "+jugadores.get(i).getNombre()+" no dispone de tanto dinero.");
                    //El jugador no puede comprar
                    jugadores.get(i).setEstadoParaComprar(0);
                    request.getSession().setAttribute("jugadorNoPuedeComprar", 
                                                    "El jugador "+jugadores.get(i).getNombre()+" no dispone de tanto dinero ("+propiedades.get(j).getPrecio()+" €).");
                }               
            }
        }
        request.getSession().setAttribute("listaPropiedades", propiedades);
        request.getSession().setAttribute("listaJugadoresPartida",jugadores);
        utilServlet.mostrarVista("./jsp/partida.jsp", request, response);             
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
