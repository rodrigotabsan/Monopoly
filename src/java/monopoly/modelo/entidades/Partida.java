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
public class Partida implements java.io.Serializable {
    int id;
    String nombre;
    int idTablero;
    
    public Partida(){
         
     }

    /**
     * Constructor de la partida.
     * @param id id de la partida
     * @param nombre nombre de la partida
     * @param idTablero id del tablero de la partida
     */
    public Partida(int id, String nombre, int idTablero) {
        this.id = id;
        this.nombre = nombre;
        this.idTablero = idTablero;
    }

    /**
     *
     * @return id de la partida
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id de la partida
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return nombre de la partida
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre nombre de la partida
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return id del tablero de la partida
     */
    public int getIdTablero() {
        return idTablero;
    }

    /**
     *
     * @param idTablero id del tablero de la partida
     */
    public void setIdTablero(int idTablero) {
        this.idTablero = idTablero;
    }
    
   
}
