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
public class Tablero {
    int id;
    int idCasilla;
    int idTSorpresaSuerte;
    int turno;
    
    public Tablero(int id, int idCasilla, int idTSorpresaSuerte, int turno) {
        this.id = id;
        this.idCasilla = idCasilla;
        this.idTSorpresaSuerte = idTSorpresaSuerte;
        this.turno= turno;
    }

    public Tablero() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCasilla() {
        return idCasilla;
    }

    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }

    public int getIdTSorpresaSuerte() {
        return idTSorpresaSuerte;
    }

    public void setIdTSorpresaSuerte(int idTSorpresaSuerte) {
        this.idTSorpresaSuerte = idTSorpresaSuerte;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
}
