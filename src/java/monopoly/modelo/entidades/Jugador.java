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

    public Jugador() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getIdCasilla() {
        return idCasilla;
    }

    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }
    
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(int estadoTurno) {
        this.estadoTurno = estadoTurno;
    }    
}
