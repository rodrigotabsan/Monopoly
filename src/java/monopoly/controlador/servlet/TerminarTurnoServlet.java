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
import monopoly.util.UtilesServlets;

/**
 *
 * @author Rodrigo
 */
public class TerminarTurnoServlet  extends HttpServlet{

    /**
     *  Procesa la petición
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){           
        try{
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String terminarTurno=request.getParameter("terminarTurno");
         System.out.println("Se termina el turno "+terminarTurno);
         if(terminarTurno!=null){                
           terminarTurno(request, response);     
         }
        }catch(ServletException | IOException ex){
            System.out.println("Error: "+ex);
        }
     }
    
    /**
     * Utilizado como respuesta para el botón de terminar turno
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     * @throws ServletException Excepción en caso de error de los Servlet
     * @throws IOException Excepcion de entrada salida de ficheros.
     */
    private void terminarTurno(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException{
        UtilesServlets utilServlet = new UtilesServlets();
        Jugador jugador = (Jugador)request.getSession().getAttribute("turnoDeJugador");
        
        int contadorJugador = (int)request.getSession().getAttribute("contadorJugadores");
        List <Jugador> jugadores= (List <Jugador>) request.getSession().getAttribute("listaJugadoresTotales");
        
        int contadorNuevoJugador = contadorJugador+1;
        if(contadorNuevoJugador>=jugadores.size()){
            contadorNuevoJugador=0;
        }
        
        Jugador jugadorSiguiente = jugadores.get(contadorNuevoJugador);
        jugadorSiguiente.setEstadoTurno(1);
        jugador.setEstadoTurno(0);
        for(int i = 0; i<jugadores.size();i++){
            if(jugador.getId()==jugadores.get(i).getId()){
                jugadores.get(i).setEstadoTurno(jugador.getEstadoTurno());
            }
            if(jugadorSiguiente.getId()==jugadores.get(i).getId()){
                jugadores.get(i).setEstadoTurno(jugadorSiguiente.getEstadoTurno());
            }        
        }
        
        request.getSession().setAttribute("listaJugadoresPartida", jugadores);        
        utilServlet.mostrarVista("./jsp/partida.jsp", request, response);   
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
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
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
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
