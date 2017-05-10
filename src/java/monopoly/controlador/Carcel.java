/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador;

import monopoly.modelo.entidades.Jugador;

/**
 *
 * @author Rodrigo
 */
public class Carcel {
    int turnos;
    Jugador jugador;

    /**
     *
     */
    public Carcel() {
    }

    /**
     *
     * @param turnos
     * @param jugador
     */
    public Carcel(int turnos, Jugador jugador) {
        this.turnos = turnos;
        this.jugador=jugador;
    }

    /**
     *
     * @return
     */
    public int getTurnos() {
        return turnos;
    }

    /**
     *
     * @param turnos
     */
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    /**
     *
     * @return
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     *
     * @param jugador
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
    
}
