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
import monopoly.util.UtilesServlets;

/**
 *
 * @author Rodrigo
 */
public class LanzarDadosServlet extends HttpServlet{

    /**
     *
     * @param request
     * @param response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        try{ 
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String lanzarDados=request.getParameter("lanzarDados");
         System.out.println("Lanza dados "+lanzarDados);
         Jugador jugador = new Jugador();
         if(lanzarDados!=null){                
           lanzarDados(request, response, jugador);     
         }
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }
         
     }
    
    private void lanzarDados(HttpServletRequest request, HttpServletResponse response, Jugador jugador){
        try {
            UtilesServlets utilServlet = new UtilesServlets();                         
            int posicionJugador = (int) request.getSession().getAttribute("posicionJugador");
            jugador=(Jugador)request.getSession().getAttribute("turnoDeJugador");
            jugador.setIdCasilla(posicionJugador);
            System.out.println("El jugador se encuentra en la casilla "+jugador.getIdCasilla());
            List <Jugador> jugadores= (List <Jugador>)request.getSession().getAttribute("todosJugadores");
            for(int i = 0; i<jugadores.size();i++){
                if(jugador.getId()==jugadores.get(i).getId()){
                    jugadores.get(i).setEstadoTurno(2);
                    jugadores.get(i).setIdCasilla(jugador.getIdCasilla());
                    if(jugadores.get(i).getIdCasilla()==30){
                        jugadores.get(i).setIdCasilla(10);
                        jugadores.get(i).setTurnoCarcel(3);
                        jugadores.get(i).setEstadoTurno(1);
                    }
                }
            }
            System.out.println("Estado "+jugador.getEstadoTurno()+ " del jugador "+jugador.getNombre());
            request.getSession().setAttribute("todosjugadores", jugadores);
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LanzarDadosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
