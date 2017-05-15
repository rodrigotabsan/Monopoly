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
     * @param id id de la tarjeta caja comunidad o suerte
     * @param tipo tipo de tarjeta 
     * @param descripcion descripcion de la tarjeta 
     * @param bonus bonus de la tarjeta. Puede ser negativo o positivo
     */
    public TSorpresaSuerte(int id, String tipo, String descripcion, int bonus) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.bonus = bonus;
    }

    /**
     *
     * @return id de la tarjeta caja comunidad o suerte
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id de la tarjeta caja comunidad o suerte
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return tipo de tarjeta
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo tipo de tarjeta
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return descripcion de la tarjeta
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion descripcion de la tarjeta
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return bonus de la tarjeta. Puede ser negativo o positivo
     */
    public int getBonus() {
        return bonus;
    }

    /**
     *
     * @param bonus bonus de la tarjeta. Puede ser negativo o positivo
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }    
    
}
