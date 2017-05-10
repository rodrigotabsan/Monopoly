/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

import java.io.Serializable;

/**
 * Utilizado para almacenar un jugador de forma temporal.
 * @author Rodrigo
 */
public class Jugador implements Serializable{
    int id;
    String nombre;
    String figura;
    int dinero;
    int idCasilla;
    int idPartida;
    int turno;
    int estadoTurno;

    /**
     *
     * @param id
     * @param nombre
     * @param figura
     * @param dinero
     * @param idCasilla
     * @param idPartida
     * @param turno
     * @param estadoTurno
     */
    public Jugador(int id, String nombre, String figura, int dinero, int idCasilla, int idPartida, int turno, int estadoTurno){
        this.id = id;
        this.nombre = nombre;
        this.figura = figura;
        this.dinero = dinero;
        this.idCasilla = idCasilla;
        this.idPartida = idPartida;
        this.turno=turno;
        this.estadoTurno=estadoTurno;
        
    }

    /**
     *
     */
    public Jugador() {
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
    public String getFigura() {
        return figura;
    }

    /**
     *
     * @param figura
     */
    public void setFigura(String figura) {
        this.figura = figura;
    }

    /**
     *
     * @return
     */
    public int getDinero() {
        return dinero;
    }

    /**
     *
     * @param dinero
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     *
     * @return
     */
    public int getIdCasilla() {
        return idCasilla;
    }

    /**
     *
     * @param idCasilla
     */
    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }
    
    /**
     *
     * @return
     */
    public int getIdPartida() {
        return idPartida;
    }

    /**
     *
     * @param idPartida
     */
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    /**
     *
     * @return
     */
    public int getTurno() {
        return turno;
    }

    /**
     *
     * @param turno
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     *
     * @return
     */
    public int getEstadoTurno() {
        return estadoTurno;
    }

    /**
     *
     * @param estadoTurno
     */
    public void setEstadoTurno(int estadoTurno) {
        this.estadoTurno = estadoTurno;
    }    
}
