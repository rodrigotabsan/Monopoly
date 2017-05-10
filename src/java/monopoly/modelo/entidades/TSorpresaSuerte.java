/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

/**
 * Objeto que almacena una tarjeta de caja de comunidad o suerte de forma temporal.
 * @author Rodrigo
 */
public class TSorpresaSuerte implements java.io.Serializable {
    int id;
    String tipo;
    String descripcion;
    int bonus;

    /**
     *
     */
    public TSorpresaSuerte() {
    }
   
    /**
     *
     * @param id
     * @param tipo
     * @param descripcion
     * @param bonus
     */
    public TSorpresaSuerte(int id, String tipo, String descripcion, int bonus) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.bonus = bonus;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public int getBonus() {
        return bonus;
    }

    /**
     *
     * @param bonus
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }    
    
}
