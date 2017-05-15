/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.List;
import monopoly.modelo.entidades.Jugador;

/**
 * Interface para acceder a las funciones de JugadorDAL
 * @author Rodrigo
 */
public interface IJugadorDAL {
    
    /**
     * Elimina un jugador pasándole el objeto Jugador
     * @see Jugador
     * @param usuario Jugador que se desea eliminar
     */
    public void eliminarUsuario(Jugador usuario);
    
    /**
     * Crea un jugador pasándole un objeto Jugador.
     * @see Jugador
     * @param usuario  Jugador que se desea crear
     */
    public void crearUsuario(Jugador usuario);
    
    /**
     * Obtiene un listado de todos los jugadores
     * @see Jugador
     * @return Un listado de Jugador
     */
    public List <Jugador> obtenerTodosUsuarios();
}
