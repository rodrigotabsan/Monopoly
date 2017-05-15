/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

/**
 * Correspondiente a casillas de Caja de Comunidad, Suerte, Impuestos, Cárcel...
 * @author Rodrigo
 */
public class Especial implements java.io.Serializable {
    int id;
    String nombre;
    String tipo;
    int bonus;
    int idCasilla;
    
    /**
     *
     */
    public Especial(){
         
     }
    
    /**
     *
     * @param id El id de la casilla Especial
     * @param nombre El nombre de la casilla especial
     * @param tipo El tipo de casilla especial
     * @param bonus El bonus de la casilla especial
     * @param idCasilla el id de la casilla
     */
    public Especial(int id, String nombre, String tipo, int bonus, int idCasilla) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.bonus = bonus;
        this.idCasilla = idCasilla;
    }
    
    /**
     * Obtiene el ID de la casilla especial.
     * @return El id de la casilla especial
     */
    public int getId() {
        return id;
    }

    /**
     * Dar ID a la casilla especial.
     * @param id El id de la casilla especial
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtener el nombre de la casilla especial.
     * @return El nombre de la casilla especial
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Dar nombre a la casilla especial.
     * @param nombre El nombre de la casilla especial
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtener qué tipo de casilla es.
     * @return el tipo de casilla especial
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Enviar qué tipo de casilla es.
     * @param tipo El tipo de casilla
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Obtener el bonus de la casilla si lo tiene.  
     * @return el bonus de la casilla
     */
    public int getBonus() {
        return bonus;
    }
    
    /**
     * Dar Bonus de la casilla. Si no tiene, debe rellenarse con un blanco " ".
     * @param bonus El bonus de la casilla
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    /**
     * Obtener ID de la casilla
     * @return El id de la casilla
     */
    public int getIdCasilla() {
        return idCasilla;
    }
    
    /**
     * Dar el ID de la casilla.
     * @param idCasilla el id de la casilla
     */
    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }
    
    
}
