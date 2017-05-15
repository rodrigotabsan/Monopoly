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
     * Obtiene todas las partidas
     * @see Partida
     * @return Un listado de las partidas
     */
    public List<Partida> obtenerTodasPartidas();
    
    /**
     * Elimina una partida. Hay que pasarle un objeto Partida
     * @see Partida
     * @param partida Partida que se desea eliminar
     */
    public void eliminarPartida(Partida partida);
}
