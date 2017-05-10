/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

/**
 * Utilizado para almacenar una partida de forma temporal.
 * @author Rodrigo
 */
public class Partida {
    int id;
    String nombre;
    int idTablero;
    
    public Partida(){
         
     }

    /**
     *
     * @param id
     * @param nombre
     * @param idTablero
     */
    public Partida(int id, String nombre, int idTablero) {
        this.id = id;
        this.nombre = nombre;
        this.idTablero = idTablero;
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
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getIdTablero() {
        return idTablero;
    }

    /**
     *
     * @param idTablero
     */
    public void setIdTablero(int idTablero) {
        this.idTablero = idTablero;
    }
    
   
}
