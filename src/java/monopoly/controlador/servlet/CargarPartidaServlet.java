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
 * Ejecuta el Servlet de carga de una partida.
 * @author Rodrigo
 */
public class CargarPartidaServlet extends HttpServlet{
    
    /**
     * Procesa la peticion
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        try{
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String cargarPartida=request.getParameter("partidaName");         
         if(cargarPartida!=null){
            
            IEspecialDAL casillasEspeciales = new EspecialDAL();
            IPropiedadDAL casillasPropiedades = new PropiedadDAL();
            ICasillaDAL casillas = new CasillaDAL();
            ITSorpresaSuerteDAL tarjetaCCySuerte = new TSorpresaSuerteDAL();
            ITableroDAL tableros = new TableroDAL();
            IPartidaDAL partidas = new PartidaDAL();
            IJugadorDAL jugadors = new JugadorDAL();
            Tablero tableroNuevo = new Tablero();
            Partida partidaNueva = new Partida();
                        
            List <Especial> listaCasillasEspeciales = casillasEspeciales.obtenerTodasEspeciales(cargarPartida);
            List <Propiedad> listaCasillasPropiedades = casillasPropiedades.obtenerTodasPropiedades(cargarPartida);
            List <Casilla> listaCasillas = casillas.obtenerTodasCasillas(cargarPartida);
            List <TSorpresaSuerte> listaTarjetaCCySuerte= tarjetaCCySuerte.obtenerTodasTsSorpresaSuerte(cargarPartida);
            List <Jugador> jugadores = jugadors.obtenerTodosUsuarios(cargarPartida);
            
            List<Tablero> listaTableros = tableros.obtenerTodosTableros(cargarPartida);
                if(!listaTableros.isEmpty()){
                    int idUltimoTablero = 0;
                    if(listaTableros.size()>0){
                        tableroNuevo.setId(listaTableros.size()-1);
                        tableroNuevo.setTurno(1);
                        tableroNuevo.setFondoDinero(0);
                    }
                }
                
            List<Partida> listaPartidas = partidas.obtenerTodasPartidas(cargarPartida);
                if(!listaPartidas.isEmpty()){
                    if(listaPartidas.size()>0){
                        partidaNueva.setId(listaPartidas.size());                    
                        partidaNueva.setIdTablero(tableroNuevo.getId());
                    }               
                }
             
            //Aquí envío las listas, el tablero y la partida a partida.jsp
            request.getSession().setAttribute("listaEspeciales",listaCasillasEspeciales);
            request.getSession().setAttribute("listaPropiedades",listaCasillasPropiedades);
            request.getSession().setAttribute("listaCasillas",listaCasillas);
            request.getSession().setAttribute("listaTarjetaCCySuerte",listaTarjetaCCySuerte);
            request.getSession().setAttribute("tableroNuevo",tableroNuevo);
            request.getSession().setAttribute("partidaNueva",partidaNueva);
            request.getSession().setAttribute("listaJugadoresPartida",jugadores);
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
             
         }
        }catch(ServletException | IOException ex){
            System.out.println("Error: "+ex);
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
