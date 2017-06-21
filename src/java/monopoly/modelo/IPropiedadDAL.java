/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.io.File;
import java.util.List;
import monopoly.modelo.entidades.Propiedad;

/**
 * Interface para acceder a las funciones de PropiedadDAL
 * @author Rodrigo
 */
public interface IPropiedadDAL {
    
    
    /**
     * Guardo las propiedades
     * @param ficheroPropiedades fichero donde lo quiero guardar
     * @param propiedades lista de las propiedades
     */
    public void guardarPropiedades(String ficheroPropiedades, List <Propiedad> propiedades);
    
    /**
     * Obtiene todas las propiedades.
     * @see Propiedad
     * @return Un listado de Propiedad
     */
    public List<Propiedad> obtenerTodasPropiedades();
    
    /**
     * Obtiene todas las propiedades.
     * @param partida String de una partida guardada
     * @see Propiedad
     * @return Un listado de Propiedad
     */
    public List<Propiedad> obtenerTodasPropiedades(String partida);
}
