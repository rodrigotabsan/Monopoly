/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.List;
import monopoly.modelo.entidades.Partida;

/**
 * Interface para acceder a las funciones de PartidaDAL
 * @author Rodrigo
 */
public interface IPartidaDAL {
    
    /**
     * Guardar una partida pasándole un objeto Partida.
     * @param fichero fichero donde se va a guardar     
     * @param partida  Partida que se desea guardar
     * @see Partida Clase Partida relacionado con el método
     */
    public void guardarPartida(String fichero,Partida partida);
    
    /**
     * Obtiene todas las partidas
     * @see Partida
     * @return Un listado de las partidas
     */
    public List<Partida> obtenerTodasPartidas();
    
    
    /**
     * Obtiene todas las partidas
     * @param partida String de una partida guardada
     * @see Partida
     * @return Un listado de las partidas
     */
    public List<Partida> obtenerTodasPartidas(String partida);
    
    /**
     * Elimina una partida. Hay que pasarle un objeto Partida
     * @see Partida
     * @param partida Partida que se desea eliminar
     */
    public void eliminarPartida(Partida partida);
}
