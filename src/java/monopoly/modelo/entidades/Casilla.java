/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

/**
 * Utilizado para almacenar una casilla de forma temporal
 * @author Rodrigo
 */
public class Casilla implements java.io.Serializable {
    int id;
    String nombre;
    String tipo;
    
    /**
     *
     */
    public Casilla(){
        
    }
    
    /**
     *
     * @param id
     * @param nombre
     * @param tipo
     */
    public Casilla(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    /**
     * Obtiene el ID de la casilla.
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Dar valor al ID de la casilla
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtiene el nombre de la casilla
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Dar un nombre a la casilla
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Consigue la descripción o el tipo de la casilla.
     * @return 
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Da una descripción o tipo de casilla.
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
