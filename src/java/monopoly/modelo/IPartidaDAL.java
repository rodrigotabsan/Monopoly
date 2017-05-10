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
 * @see PartidaDAL
 * @author Rodrigo
 */
public interface IPartidaDAL {
    
    /**
     * Obtiene todas las partidas
     * @see Partida
     * @see PartidaDAL
     * @return 
     */
    public List<Partida> obtenerTodasPartidas();
    
    /**
     * Elimina una partida. Hay que pasarle un objeto Partida
     * @see Partida
     * @see PartidaDAL
     * @param partida 
     */
    public void eliminarPartida(Partida partida);
}
