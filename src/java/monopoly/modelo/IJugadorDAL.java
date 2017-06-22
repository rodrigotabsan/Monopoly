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
     * Guardar un listado de jugadores pasándole un listado de objetos Jugador.
     * @param fichero fichero donde se va a guardar     
     * @param jugadores  Jugadores que se desean guardar
     * @see Jugador
     */
    public void guardarUsuario(String fichero,List<Jugador> jugadores);
    
    /**
     * Obtiene un listado de todos los jugadores
     * @see Jugador
     * @return Un listado de Jugador
     */
    public List <Jugador> obtenerTodosUsuarios();
    
    /**
     * Obtiene un listado de todos los jugadores
     * @param partida string de una partida guardada
     * @see Jugador
     * @return Un listado de Jugador
     */
    public List <Jugador> obtenerTodosUsuarios(String partida);
}
