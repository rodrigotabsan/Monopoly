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
@FunctionalInterface
public interface IEspecialDAL {
    
    /**
     * Obtiene todas las casillas especiales del tablero.
     * @see Especial
     * @return Un listado de Especial
     */
     public List<Especial> obtenerTodasEspeciales();
}
