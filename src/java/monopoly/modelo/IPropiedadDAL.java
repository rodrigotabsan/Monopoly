/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.ArrayList;
import monopoly.modelo.entidades.Propiedad;

/**
 * Interface para acceder a las funciones de PropiedadDAL
 * @see PropiedadDAL
 * @author Rodrigo
 */
public interface IPropiedadDAL {
    
    /**
     * Obtiene todas las propiedades.
     * @see Propiedad
     * @see PropiedadDAL
     * @return 
     */
    public ArrayList<Propiedad> obtenerTodasPropiedades();
}
