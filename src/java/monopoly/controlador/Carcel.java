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

    public Carcel() {
    }

    public Carcel(int turnos, Jugador jugador) {
        this.turnos = turnos;
        this.jugador=jugador;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
    
}
