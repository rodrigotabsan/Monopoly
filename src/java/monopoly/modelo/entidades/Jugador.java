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
    int turnoCarcel;
    int cogeTarjeta;
    int estadoParaComprar;
    
     /**
     * Constructor del Jugador
     * @param id id del jugador
     * @param nombre nombre del jugador
     * @param figura figura del jugador
     * @param dinero dinero del jugador
     * @param idCasilla id de la casilla en la que se situa el jugador
     * @param idPartida id de la partida en la que está el jugador
     * @param turno el turno del jugador en el que está
     * @param estadoTurno El estado del turno del jugador
     * @param turnoCarcel La cantidad de turnos que tiene que esperar para salir de la cárcel.
     * @param cogeTarjeta Indica si tiene que coger tarjeta cc o suerte.
     * @param estadoParaComprar Indica la disponibilidad del jugador para comprar.
     */
    public Jugador(int id, String nombre, String figura, int dinero, int idCasilla, int idPartida, int turno, int estadoTurno, int turnoCarcel, int cogeTarjeta, int estadoParaComprar) {
        this.id = id;
        this.nombre = nombre;
        this.figura = figura;
        this.dinero = dinero;
        this.idCasilla = idCasilla;
        this.idPartida = idPartida;
        this.turno = turno;
        this.estadoTurno = estadoTurno;
        this.turnoCarcel = turnoCarcel;
        this.cogeTarjeta = cogeTarjeta;
        this.estadoParaComprar = estadoParaComprar;
    }

    /**
     * Constructor vacío del jugador.
     */
    public Jugador() {
    }
    
    /**
     *
     * @return El id del jugador
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id El id del jugador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return El nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre El nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return La figura que corresponde al jugador
     */
    public String getFigura() {
        return figura;
    }

    /**
     *
     * @param figura La figura que corresponde al jugador
     */
    public void setFigura(String figura) {
        this.figura = figura;
    }

    /**
     *
     * @return El dinero del jugador
     */
    public int getDinero() {
        return dinero;
    }

    /**
     *
     * @param dinero El dinero del jugador
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     *
     * @return El id de casilla donde se situa el jugador
     */
    public int getIdCasilla() {
        return idCasilla;
    }

    /**
     *
     * @param idCasilla El id de casilla donde se situa el jugador
     */
    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }
    
    /**
     *
     * @return el id de la partida a la que pertenece el jugador
     */
    public int getIdPartida() {
        return idPartida;
    }

    /**
     *
     * @param idPartida el id de la partida a la que pertenece el jugador
     */
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    /**
     *
     * @return El turno en el que está el jugador
     */
    public int getTurno() {
        return turno;
    }

    /**
     *
     * @param turno El turno en el que está el jugador
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * Hay tres estados: 
     * 0) El estado cero es que no es su turno
     * 1) El estado uno, es su turno, pero solo para lanzar dados o guardar partida
     * 2) El estado dos, es su turno, pero solo para negociar, terminar turno o guardar partida
     * @return El estado del turno en el que está el jugador
     */
    public int getEstadoTurno() {
        return estadoTurno;
    }

    /**
     * 
     * @param estadoTurno El estado del turno en el que está el jugador
     */
    public void setEstadoTurno(int estadoTurno) {
        this.estadoTurno = estadoTurno;
    }    
    
    /**
     * 
     * @return La cantidad de turnos que le faltan por esperar para salir de la cárcel
     */
    public int getTurnoCarcel() {
        return turnoCarcel;
    }
    
    /**
     * 
     * @param turnoCarcel La cantidad de turnos que tiene que esperar para salir de la cárcel
     */
    public void setTurnoCarcel(int turnoCarcel) {
        this.turnoCarcel = turnoCarcel;
    }
    
    /**
     * Recoge si coge tarjeta cc o suerte
     * @return 
     */
    public int getCogeTarjeta() {
        return cogeTarjeta;
    }
    
    /**
     * Indica si tiene que coger tarjeta cc o suerte
     * @param cogeTarjeta entero que indica si tiene que coger tarjeta.
     */
    public void setCogeTarjeta(int cogeTarjeta) {
        this.cogeTarjeta = cogeTarjeta;
    }
    
    /**
     * Indica cual es el estado para comprar del jugador
     * Con el estado 1 el usuario puede comprar
     * Con el estado 0 el usuario no puede comprar
     * @return 
     */
    public int getEstadoParaComprar() {
        return estadoParaComprar;
    }
    
    /**
     * Se indica cual es el estado del jugador para comprar.
     * @param estadoParaComprar 
     */
    public void setEstadoParaComprar(int estadoParaComprar) {
        this.estadoParaComprar = estadoParaComprar;
    }
    
    
}
