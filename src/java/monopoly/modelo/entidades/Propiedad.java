/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

/**
 * Utilizado para almacenar una propiedad de forma temporal.
 * @author Rodrigo
 */
public class Propiedad {
    int id;
    String nombre;
    String tipo;
    int precio;
    int idUsuario;
    String descripcion;
    String color;
    int idCasilla;
    int hipoteca;
    int alquiler;
    int casa;
    int alquilerPrimeraCasa;
    int alquilerSegundaCasa;
    int alquilerTerceraCasa;
    int alquilerCuartaCasa;
    int hotel;
    int alquilerHotel;
    
    public Propiedad(){
        
    }

    public Propiedad(int id, String nombre, String tipo, int precio, int idUsuario, String descripcion, String color, int idCasilla, int hipoteca, int alquiler, int casa, int alquilerPrimeraCasa, int alquilerSegundaCasa, int alquilerTerceraCasa, int alquilerCuartaCasa, int hotel, int alquilerHotel) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.color = color;
        this.idCasilla = idCasilla;
        this.hipoteca = hipoteca;
        this.alquiler = alquiler;
        this.casa = casa;
        this.alquilerPrimeraCasa = alquilerPrimeraCasa;
        this.alquilerSegundaCasa = alquilerSegundaCasa;
        this.alquilerTerceraCasa = alquilerTerceraCasa;
        this.alquilerCuartaCasa = alquilerCuartaCasa;
        this.hotel = hotel;
        this.alquilerHotel = alquilerHotel;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdCasilla() {
        return idCasilla;
    }

    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }

    public int getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(int hipoteca) {
        this.hipoteca = hipoteca;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public int getCasa() {
        return casa;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getAlquilerHotel() {
        return alquilerHotel;
    }

    public void setAlquilerHotel(int alquilerHotel) {
        this.alquilerHotel = alquilerHotel;
    }

    public int getAlquilerPrimeraCasa() {
        return alquilerPrimeraCasa;
    }

    public void setAlquilerPrimeraCasa(int alquilerPrimeraCasa) {
        this.alquilerPrimeraCasa = alquilerPrimeraCasa;
    }

    public int getAlquilerSegundaCasa() {
        return alquilerSegundaCasa;
    }

    public void setAlquilerSegundaCasa(int alquilerSegundaCasa) {
        this.alquilerSegundaCasa = alquilerSegundaCasa;
    }

    public int getAlquilerTerceraCasa() {
        return alquilerTerceraCasa;
    }

    public void setAlquilerTerceraCasa(int alquilerTerceraCasa) {
        this.alquilerTerceraCasa = alquilerTerceraCasa;
    }

    public int getAlquilerCuartaCasa() {
        return alquilerCuartaCasa;
    }

    public void setAlquilerCuartaCasa(int alquilerCuartaCasa) {
        this.alquilerCuartaCasa = alquilerCuartaCasa;
    }

   
    
}
