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
import monopoly.modelo.ICasillaDAL;
import monopoly.modelo.IEspecialDAL;
import monopoly.modelo.IJugadorDAL;
import monopoly.modelo.IPartidaDAL;
import monopoly.modelo.IPropiedadDAL;
import monopoly.modelo.ITSorpresaSuerteDAL;
import monopoly.modelo.ITableroDAL;
import monopoly.modelo.dal.CasillaDAL;
import monopoly.modelo.dal.EspecialDAL;
import monopoly.modelo.dal.JugadorDAL;
import monopoly.modelo.dal.PartidaDAL;
import monopoly.modelo.dal.PropiedadDAL;
import monopoly.modelo.dal.TSorpresaSuerteDAL;
import monopoly.modelo.dal.TableroDAL;
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
public class CogerTarjetaCajaComunidadYSuerte extends HttpServlet{
    
    /**
     * Procesa la peticion
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        List<Jugador> jugadores=(List<Jugador>)request.getSession().getAttribute("listaJugadoresPartida");
         
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
