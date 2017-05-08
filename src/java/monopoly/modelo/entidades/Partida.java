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
    public Partida(int id, String nombre, int idUsuario, int idTablero) {
        this.id = id;
        this.nombre = nombre;
        this.idTablero = idTablero;
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

    public int getIdTablero() {
        return idTablero;
    }

    public void setIdTablero(int idTablero) {
        this.idTablero = idTablero;
    }
    
   
}
