/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.List;
import monopoly.modelo.entidades.Tablero;

/**
 * Interface para acceder a las funciones de TableroDAL
 * @author Rodrigo
 */
public interface ITableroDAL {
    
    /**
     * Elimina un tablero pasándole un objeto Tablero
     * @see Tablero
     * @param tablero Tablero que se desea eliminar
     */
    public void eliminarTablero(Tablero tablero);
    
    /**
     * Obtiene todos los tableros del XML tableros.xml
     * @return Un listado de Tablero
     */
    public List<Tablero> obtenerTodosTableros();
    
    /**
     * Añade una etiqueta tablero nueva al XML tableros.xml 
     * @param tablero Tablero que se desea crear
     */
    public void crearTablero(Tablero tablero);
}
