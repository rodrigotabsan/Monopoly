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
public class Propiedad implements java.io.Serializable {
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
    
    /**
     *
     */
    public Propiedad(){
        
    }

    /**
     *
     * @param id
     * @param nombre
     * @param tipo
     * @param precio
     * @param idUsuario
     * @param descripcion
     * @param color
     * @param idCasilla
     * @param hipoteca
     * @param alquiler
     * @param casa
     * @param alquilerPrimeraCasa
     * @param alquilerSegundaCasa
     * @param alquilerTerceraCasa
     * @param alquilerCuartaCasa
     * @param hotel
     * @param alquilerHotel
     */
    public Propiedad(int id, String nombre, String tipo, int precio, int idUsuario, String descripcion, String color, int idCasilla, 
            int hipoteca, int alquiler, int casa, int alquilerPrimeraCasa, int alquilerSegundaCasa, int alquilerTerceraCasa, 
            int alquilerCuartaCasa, int hotel, int alquilerHotel) {
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
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
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
    public int getHipoteca() {
        return hipoteca;
    }

    /**
     *
     * @param hipoteca
     */
    public void setHipoteca(int hipoteca) {
        this.hipoteca = hipoteca;
    }

    /**
     *
     * @return
     */
    public int getAlquiler() {
        return alquiler;
    }

    /**
     *
     * @param alquiler
     */
    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    /**
     *
     * @return
     */
    public int getCasa() {
        return casa;
    }

    /**
     *
     * @param casa
     */
    public void setCasa(int casa) {
        this.casa = casa;
    }

    /**
     *
     * @return
     */
    public int getHotel() {
        return hotel;
    }

    /**
     *
     * @param hotel
     */
    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    /**
     *
     * @return
     */
    public int getAlquilerHotel() {
        return alquilerHotel;
    }

    /**
     *
     * @param alquilerHotel
     */
    public void setAlquilerHotel(int alquilerHotel) {
        this.alquilerHotel = alquilerHotel;
    }

    /**
     *
     * @return
     */
    public int getAlquilerPrimeraCasa() {
        return alquilerPrimeraCasa;
    }

    /**
     *
     * @param alquilerPrimeraCasa
     */
    public void setAlquilerPrimeraCasa(int alquilerPrimeraCasa) {
        this.alquilerPrimeraCasa = alquilerPrimeraCasa;
    }

    /**
     *
     * @return
     */
    public int getAlquilerSegundaCasa() {
        return alquilerSegundaCasa;
    }

    /**
     *
     * @param alquilerSegundaCasa
     */
    public void setAlquilerSegundaCasa(int alquilerSegundaCasa) {
        this.alquilerSegundaCasa = alquilerSegundaCasa;
    }

    /**
     *
     * @return
     */
    public int getAlquilerTerceraCasa() {
        return alquilerTerceraCasa;
    }

    /**
     *
     * @param alquilerTerceraCasa
     */
    public void setAlquilerTerceraCasa(int alquilerTerceraCasa) {
        this.alquilerTerceraCasa = alquilerTerceraCasa;
    }

    /**
     *
     * @return
     */
    public int getAlquilerCuartaCasa() {
        return alquilerCuartaCasa;
    }

    /**
     *
     * @param alquilerCuartaCasa
     */
    public void setAlquilerCuartaCasa(int alquilerCuartaCasa) {
        this.alquilerCuartaCasa = alquilerCuartaCasa;
    }

   
    
}
