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
public class TSorpresaSuerte {
    int id;
    String tipo;
    String descripcion;
    int bonus;

    public TSorpresaSuerte() {
    }
   
    public TSorpresaSuerte(int id, String tipo, String descripcion, int bonus) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }    
    
}
