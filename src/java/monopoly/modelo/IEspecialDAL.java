/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.ArrayList;
import monopoly.modelo.entidades.Especial;

/**
 * Interface para acceder a las funciones de EspecialDAL
 * @see EspecialDAL
 * @author Rodrigo
 */
public interface IEspecialDAL {
    
    /**
     * Obtiene todas las casillas especiales del tablero.
     * @see Especial
     * @see EspecialDAL
     * @return 
     */
     public ArrayList<Especial> obtenerTodasEspeciales();
}
