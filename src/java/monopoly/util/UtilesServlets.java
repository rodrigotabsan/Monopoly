/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.util;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase utilizada para almacenar funciones relacionadas con el control de la
 * aplicación.
 * @author Rodrigo
 * @since 30/04/2017
 */
public class UtilesServlets {
    
    /**
     *
     */
    public UtilesServlets(){
    
    }
    
    /**
     * Sirve para redireccionarte a la pantalla que marques en el campo vista.
     * @param vista
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void mostrarVista(String vista,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd
                = request.getRequestDispatcher(vista);

        rd.forward(request, response);
    }
    
    /**
     * Elimina todos los mensajes de error de las pantallas. Esto se hace porque
     * puede ocurrir que al pulsar atrás en el navegador se muestre el mensaje de error.
     * @param request
     * @param response
     * @throws IOException 
     */
    public void eliminarMensajesDeError(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
    request.getSession().removeAttribute("figurasError");
    request.getSession().removeAttribute("numJugadoresError");
    request.getSession().removeAttribute("jugadoresNulosError");
    } 
    
    /**
     * Mensaje de error que avisa de que el número total de jugadores ha sido superado.
     * Esto ocurre al seleccionar los jugadores de la CPU.
     * @param request
     * @param response
     * @param numCPU
     * @throws IOException 
     */
    public void mensajeErrorNumTotalJugadores(HttpServletRequest request,
            HttpServletResponse response, int numCPU) throws IOException{
        int numCpu=numCPU;
        numCPU=8-numCpu;
        request.getSession().setAttribute("numJugadoresError","El número de jugadores es superior a 8."+" Has seleccionado "+numCPU+" jugadores de más.");
    }
    
    /**
     * Mensaje de error que avisa de que se han repetido, en la selección de jugadores 
     * humanos, dos figuras.
     * @param request
     * @param response
     * @param jugador
     * @throws IOException 
     */
    public void mensajeErrorFigurasJugadoresDuplicadas(HttpServletRequest request,
            HttpServletResponse response, int jugador) throws IOException{
        request.getSession().setAttribute("figurasError","El jugador "+jugador+" ha seleccionado una figura repetida.");
    }
    
    /**
     * Mensaje de error al dejar en blanco los datos de cualquier jugador humano.
     * @param request
     * @param response
     * @throws IOException 
     */
    public void mensajeErrorAnhadirJugadoresNulos(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
        request.getSession().setAttribute("jugadoresNulosError","Rellena todos los datos de todos los jugadores.");
    }
}
