/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

/**
 * Utilizado para almacenar un tablero de forma temporal.
 * @author Rodrigo
 */
public class Tablero implements java.io.Serializable {
    int id;
    int idCasilla;
    int idTSorpresaSuerte;
    int turno;
    int fondoDinero;
    
    /**
     * Constructor del Tablero
     * @param id id del tablero
     * @param idCasilla id de la casilla 
     * @param idTSorpresaSuerte id de la tarjeta caja de comunidad o suerte
     * @param turno id del turno
     * @param fondoDinero las multas acumuladas para que el primer jugador que pase por el Parking las reciba
     */
    public Tablero(int id, int idCasilla, int idTSorpresaSuerte, int turno, int fondoDinero) {
        this.id = id;
        this.idCasilla = idCasilla;
        this.idTSorpresaSuerte = idTSorpresaSuerte;
        this.turno= turno;
        this.fondoDinero=fondoDinero;
    }

    public Tablero() {
    }

    /**
     * 
     * @return id del tablero
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id del tablero
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return id de la casilla
     */
    public int getIdCasilla() {
        return idCasilla;
    }

    /**
     *
     * @param idCasilla id de la casilla
     */
    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }

    /**
     *
     * @return id de la tarjeta caja de comunidad o suerte
     */
    public int getIdTSorpresaSuerte() {
        return idTSorpresaSuerte;
    }

    /**
     *
     * @param idTSorpresaSuerte id de la tarjeta caja de comunidad o suerte
     */
    public void setIdTSorpresaSuerte(int idTSorpresaSuerte) {
        this.idTSorpresaSuerte = idTSorpresaSuerte;
    }

    /**
     *
     * @return turno en la partida
     */
    public int getTurno() {
        return turno;
    }

    /**
     *
     * @param turno turno en la partida
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    /**
     * 
     * @return devuelve el fondo de dinero que mantiene la banca de las multas de los jugadores
     */
    public int getFondoDinero() {
        return fondoDinero;
    }
    
    /**
     * 
     * @param fondoDinero correspondiente a las multas de los jugadores.
     */
    public void setFondoDinero(int fondoDinero) {
        this.fondoDinero = fondoDinero;
    }
    
    
}
