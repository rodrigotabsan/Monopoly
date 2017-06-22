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
 * @author Rodrigo
 */
public interface ITSorpresaSuerteDAL {
    
    /**
     * Guardar un listado de itSorpresaSuerteDAL pasándole un listado de objetos itSorpresaSuerteDAL.
     * @param fichero fichero donde se va a guardar     
     * @param itSorpresaSuerte  itSorpresaSuerte que se desean guardar
     * @see ITSorpresaSuerte
     */
    public void guardarITSorpresaSuerte(String fichero, List<TSorpresaSuerte> itSorpresaSuerte);
    
    /**
     * Obtiene todas las tarjetas de Caja Comunidad y Suerte.
     * @see TSorpresaSuerte
     * @return Un listado de TSorpresaSuerteDAL
     */
    public List<TSorpresaSuerte> obtenerTodasTsSorpresaSuerte();
    
    /**
     * Obtiene todas las tarjetas de Caja Comunidad y Suerte.
     * @param partida String de una partida guardada
     * @see TSorpresaSuerte
     * @return Un listado de TSorpresaSuerteDAL
     */
    public List<TSorpresaSuerte> obtenerTodasTsSorpresaSuerte(String partida);
}
