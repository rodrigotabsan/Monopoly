/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.List;
import monopoly.modelo.entidades.TSorpresaSuerte;

/**
 * Interface para acceder a las funciones de TSorpresaSuerteDAL
 * @see TSorpresaSuerteDAL
 * @author Rodrigo
 */
@FunctionalInterface
public interface ITSorpresaSuerteDAL {
    
    /**
     * Obtiene todas las tarjetas de Caja Comunidad y Suerte.
     * @see TSorpresaSuerte
     * @see TSorpresaSuerteDAL
     * @return 
     */
    public List<TSorpresaSuerte> obtenerTodasTsSorpresaSuerte();
}
