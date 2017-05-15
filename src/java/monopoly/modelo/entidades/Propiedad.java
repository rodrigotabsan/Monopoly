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
     * Constructor de Propiedad
     * @param id Id de la propiedad
     * @param nombre Nombre de la propiedad
     * @param tipo Tipo de propiedad
     * @param precio Precio de la propiedad
     * @param idUsuario Id del usuario propietario de la propiedad (por defecto 0 si no tiene)
     * @param descripcion Descripcion de la propiedad
     * @param color Color de la propiedad
     * @param idCasilla Id casilla de la propiedad
     * @param hipoteca Hipoteca de la propiedad
     * @param alquiler Alquiler de la propiedad
     * @param casa número de casas de la propiedad
     * @param alquilerPrimeraCasa Cobro por una casa
     * @param alquilerSegundaCasa Cobro por dos casas
     * @param alquilerTerceraCasa Cobro por tres casas
     * @param alquilerCuartaCasa Cobro por cuatro casas
     * @param hotel Número de hoteles
     * @param alquilerHotel Alquiler de un hotel
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
     * @return el id de la propiedad
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id el id de la propiedad
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return el nombre de la propiedad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre el nombre de la propiedad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return tipo de propiedad
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo tipo de propiedad
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return obtiene el precio de la propiedad
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio el precio de la propiedad
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *
     * @return el usuario propietario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario el usuario propietario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return la descripcion de la propiedad
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion la descripcion de la propiedad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return el color de la casilla
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color el color de la casilla
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return el id de la casilla correspondiente
     */
    public int getIdCasilla() {
        return idCasilla;
    }

    /**
     *
     * @param idCasilla el id de la casilla correspondiente
     */
    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }

    /**
     *
     * @return la hipoteca de la propiedad
     */
    public int getHipoteca() {
        return hipoteca;
    }

    /**
     *
     * @param hipoteca la hipoteca de la propiedad
     */
    public void setHipoteca(int hipoteca) {
        this.hipoteca = hipoteca;
    }

    /**
     *
     * @return el alquiler de la propiedad
     */
    public int getAlquiler() {
        return alquiler;
    }

    /**
     *
     * @param alquiler precio del alquiler de la propiedad
     */
    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    /**
     *
     * @return el número de casas
     */
    public int getCasa() {
        return casa;
    }

    /**
     *
     * @param casa el número de casas
     */
    public void setCasa(int casa) {
        this.casa = casa;
    }

    /**
     *
     * @return el número de hoteles
     */
    public int getHotel() {
        return hotel;
    }

    /**
     *
     * @param hotel es un entero
     */
    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    /**
     *
     * @return el entero del AlquilerHotel
     */
    public int getAlquilerHotel() {
        return alquilerHotel;
    }

    /**
     *
     * @param alquilerHotel es un entero
     */
    public void setAlquilerHotel(int alquilerHotel) {
        this.alquilerHotel = alquilerHotel;
    }

    /**
     *
     * @return el entero de alquilerPrimeraCasa
     */
    public int getAlquilerPrimeraCasa() {
        return alquilerPrimeraCasa;
    }

    /**
     *
     * @param alquilerPrimeraCasa es un entero
     */
    public void setAlquilerPrimeraCasa(int alquilerPrimeraCasa) {
        this.alquilerPrimeraCasa = alquilerPrimeraCasa;
    }

    /**
     *
     * @return el entero de AlquilerSegundaCasa
     */
    public int getAlquilerSegundaCasa() {
        return alquilerSegundaCasa;
    }

    /**
     *
     * @param alquilerSegundaCasa el entero de AlquilerSegundaCasa
     */
    public void setAlquilerSegundaCasa(int alquilerSegundaCasa) {
        this.alquilerSegundaCasa = alquilerSegundaCasa;
    }

    /**
     *
     * @return el entero de AlquilerTerceraCasa
     */
    public int getAlquilerTerceraCasa() {
        return alquilerTerceraCasa;
    }

    /**
     *
     * @param alquilerTerceraCasa el entero de AlquilerTerceraCasa
     */
    public void setAlquilerTerceraCasa(int alquilerTerceraCasa) {
        this.alquilerTerceraCasa = alquilerTerceraCasa;
    }

    /**
     *
     * @return el entero de AlquilerCuartaCasa
     */
    public int getAlquilerCuartaCasa() {
        return alquilerCuartaCasa;
    }

    /**
     *
     * @param alquilerCuartaCasa el entero de AlquilerCuartaCasa
     */
    public void setAlquilerCuartaCasa(int alquilerCuartaCasa) {
        this.alquilerCuartaCasa = alquilerCuartaCasa;
    }

   
    
}
