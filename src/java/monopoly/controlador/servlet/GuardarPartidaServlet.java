/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monopoly.modelo.entidades.Casilla;
import monopoly.modelo.entidades.Especial;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.entidades.Partida;
import monopoly.modelo.entidades.Propiedad;
import monopoly.modelo.entidades.TSorpresaSuerte;
import monopoly.modelo.entidades.Tablero;
import monopoly.util.UtilesServlets;

/**
 *
 * @author Rodrigo
 */
public class GuardarPartidaServlet extends HttpServlet{

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
         String guardarPartida=request.getParameter("guardarPartida");
         System.out.println("Se guarda la partida "+guardarPartida);
         if(guardarPartida!=null){                
           guardarPartida(request, response);     
         }
        }catch(ServletException | IOException ex){
            System.out.println("Error: "+ex);
        }
         
     }
    
    /**
     * Guarda la partida
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     * @throws ServletException Excepcion en caso de error para los Servlets
     * @throws IOException Excepcion en caso de error de entrada y salida en el acceso a ficheros.
     */
    private void guardarPartida(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UtilesServlets utilServlet = new UtilesServlets();
        List<Propiedad> propiedades = (ArrayList<Propiedad>) 
            request.getSession().getAttribute("listaPropiedades");
        List<Especial> especiales = (ArrayList<Especial>) 
            request.getSession().getAttribute("listaEspeciales");
        List<Casilla> casillas = (ArrayList<Casilla>) 
            request.getSession().getAttribute("listaCasillas");
        List <Jugador> jugadores = (ArrayList<Jugador>)
            request.getSession().getAttribute("listaJugadoresPartida");
        List<TSorpresaSuerte> tarjetasCCySuerte = (ArrayList<TSorpresaSuerte>) 
            request.getSession().getAttribute("listaTarjetaCCySuerte");
        Tablero tablero = (Tablero)request.getSession().getAttribute("tablero");
        Partida partida = (Partida)request.getSession().getAttribute("partida");
        
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
