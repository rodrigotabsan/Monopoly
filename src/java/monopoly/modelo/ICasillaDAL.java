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
@FunctionalInterface
public interface ICasillaDAL {
    
    /**
     * Obtiene todas las casillas del tablero.
     * @see Casilla
     * @return Un listado de Casilla
     */
    public List<Casilla> obtenerTodasCasillas();
}
