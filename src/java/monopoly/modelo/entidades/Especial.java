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
public class Especial {
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
     * @param id
     * @param nombre
     * @param tipo
     * @param bonus
     * @param idCasilla
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
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Dar ID a la casilla especial.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtener el nombre de la casilla especial.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Dar nombre a la casilla especial.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtener qué tipo de casilla es.
     * @return 
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Enviar qué tipo de casilla es.
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Obtener el bonus de la casilla si lo tiene.  
     * @return 
     */
    public int getBonus() {
        return bonus;
    }
    
    /**
     * Dar Bonus de la casilla. Si no tiene, debe rellenarse con un blanco " ".
     * @param bonus 
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    /**
     * Obtener ID de la casilla
     * @return 
     */
    public int getIdCasilla() {
        return idCasilla;
    }
    
    /**
     * Dar el ID de la casilla.
     * @param idCasilla 
     */
    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }
    
    
}
