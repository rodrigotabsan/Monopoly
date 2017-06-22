/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.List;
import monopoly.modelo.entidades.Especial;

/**
 * Interface para acceder a las funciones de EspecialDAL
 * @author Rodrigo
 */
public interface IEspecialDAL {
    
    /**
     * Guardar un listado de especiales pasándole un listado de objetos Especial.
     * @param fichero fichero donde se va a guardar     
     * @param especiales  Especiales que se desean guardar
     * @see Especial
     */
    public void guardarEspecial(String fichero,List<Especial> especiales);
    
    /**
     * Obtiene todas las casillas especiales del tablero.
     * @see Especial
     * @return Un listado de Especial
     */
     public List<Especial> obtenerTodasEspeciales();
     
     
     /**
     * Obtiene todas las casillas especiales del tablero de una partida guardada.
     * @param partida String de una partida guardada
     * @see Especial
     * @return Un listado de Especial
     */
     public List<Especial> obtenerTodasEspeciales(String partida);
}
