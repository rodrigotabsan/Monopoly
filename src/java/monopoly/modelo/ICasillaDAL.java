/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.List;
import monopoly.modelo.entidades.Casilla;

/**
 * Interface para acceder a las funciones de CasillaDAL
 * @author Rodrigo
 */

public interface ICasillaDAL {
    
    
    /**
     * Guardar un listado de casillas pasándole un listado de objetos Casilla.
     * @param fichero fichero donde se va a guardar     
     * @param casillas  Casillas que se desean guardar
     * @see Casilla
     */
    public void guardarCasilla(String fichero,List<Casilla> casillas);
    
    /**
     * Obtiene todas las casillas del tablero.
     * @see Casilla
     * @return Un listado de Casilla
     */
    public List<Casilla> obtenerTodasCasillas();
    
    /**
     * Obtiene todas las casillas del tablero.
     * @param partida String de una partida guardada
     * @see Casilla
     * @return Un listado de Casilla
     */
    public List<Casilla> obtenerTodasCasillas(String partida);
}
