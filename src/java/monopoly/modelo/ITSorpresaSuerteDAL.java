/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

import java.util.ArrayList;
import monopoly.modelo.entidades.TSorpresaSuerte;

/**
 * Interface para acceder a las funciones de TSorpresaSuerteDAL
 * @see TSorpresaSuerteDAL
 * @author Rodrigo
 */
public interface ITSorpresaSuerteDAL {
    
    /**
     * Obtiene todas las tarjetas de Caja Comunidad y Suerte.
     * @see TSorpresaSuerte
     * @see TSorpresaSuerteDAL
     * @return 
     */
    public ArrayList<TSorpresaSuerte> obtenerTodasTsSorpresaSuerte();
}
