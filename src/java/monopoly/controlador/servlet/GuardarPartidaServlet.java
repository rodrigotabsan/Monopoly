/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monopoly.modelo.ICasillaDAL;
import monopoly.modelo.IEspecialDAL;
import monopoly.modelo.IJugadorDAL;
import monopoly.modelo.IPartidaDAL;
import monopoly.modelo.IPropiedadDAL;
import monopoly.modelo.ITSorpresaSuerteDAL;
import monopoly.modelo.ITableroDAL;
import monopoly.modelo.dal.CasillaDAL;
import monopoly.modelo.dal.EspecialDAL;
import monopoly.modelo.dal.JugadorDAL;
import monopoly.modelo.dal.PartidaDAL;
import monopoly.modelo.dal.PropiedadDAL;
import monopoly.modelo.dal.TSorpresaSuerteDAL;
import monopoly.modelo.dal.TableroDAL;
import monopoly.modelo.entidades.Casilla;
import monopoly.modelo.entidades.Especial;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.entidades.Partida;
import monopoly.modelo.entidades.Propiedad;
import monopoly.modelo.entidades.TSorpresaSuerte;
import monopoly.modelo.entidades.Tablero;
import monopoly.util.UtilesServlets;
import monopoly.util.UtilesXML;

/**
 *
 * @author Rodrigo
 */
public class GuardarPartidaServlet extends HttpServlet{

    /**
     * Proceso la petición
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        try{ 
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String guardarPartida=request.getParameter("guardarPartida");
         System.out.println("Se guarda la partida "+guardarPartida);
         if(guardarPartida!=null){                
           guardarPartida(request, response);     
         }
        }catch(ServletException | IOException ex){
            System.out.println("Error: "+ex);
        }
         
     }
    
    /**
     * Guarda la partida
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     * @throws ServletException Excepcion en caso de error para los Servlets
     * @throws IOException Excepcion en caso de error de entrada y salida en el acceso a ficheros.
     */
    private void guardarPartida(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UtilesServlets utilServlet = new UtilesServlets();
        List<Propiedad> propiedades = (ArrayList<Propiedad>) 
            request.getSession().getAttribute("listaPropiedades");
        List<Especial> especiales = (ArrayList<Especial>) 
            request.getSession().getAttribute("listaEspeciales");
        List<Casilla> casillas = (ArrayList<Casilla>) 
            request.getSession().getAttribute("listaCasillas");
        List <Jugador> jugadores = (ArrayList<Jugador>)
            request.getSession().getAttribute("listaJugadoresPartida");
        List<TSorpresaSuerte> tarjetasCCySuerte = (ArrayList<TSorpresaSuerte>) 
            request.getSession().getAttribute("listaTarjetaCCySuerte");
        Tablero tablero = (Tablero)request.getSession().getAttribute("tableroNuevo");
        Partida partida = (Partida)request.getSession().getAttribute("partidaNueva");
        int contadorDirectorio=1;
        boolean directorioExiste=true;
        System.out.println("TRAE "+request.getParameter("nombreAGuardar"));
        if(request.getParameter("nombreAGuardar")!=null && !request.getParameter("nombreAGuardar").isEmpty()){
            //Se utiliza la fecha para guardar la partida. No puede ser con la / porque estaría buscando entre directorios que no existen...
            File directorio=new File("xml/"+request.getParameter("nombreAGuardar").replace("/", "-")); 
            if(!directorio.exists()){
                directorio.mkdir(); 
            }else{
            //si existe se creará un nuevo directorio con la partida guardada.
                while(directorioExiste){                                
                        directorio=new File("xml/"+request.getParameter("nombreAGuardar").replace("/", "-")+"("+contadorDirectorio+")");
                        if(!directorio.exists()){
                            directorio.mkdir();
                            directorioExiste=false;
                        }                
                    contadorDirectorio++;              
                }
            }
            //Se guarda fichero a fichero.
            String propiedadesString="propiedades.xml";
            String ficheroPropiedades = directorio+"/"+propiedadesString;
            String especialesString="especiales.xml";
            String ficheroEspeciales = directorio+"/"+especialesString;
            String casillasString="casillas.xml";
            String ficheroCasillas = directorio+"/"+casillasString;
            String usuariosString="usuarios.xml";
            String ficheroUsuarios = directorio+"/"+usuariosString;
            String tsorpresasuerteString="tsorpresasuerte.xml";
            String ficheroTSorpresaSuerte = directorio+"/"+tsorpresasuerteString;
            String tablerosString="tableros.xml";
            String ficheroTableros = directorio+"/"+tablerosString;
            String partidasString="partidas.xml";
            String ficheroPartidas = directorio+"/"+partidasString;

            UtilesXML utilXML = new UtilesXML();
            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),propiedadesString);
            IPropiedadDAL ipropiedades = new PropiedadDAL();
            ipropiedades.guardarPropiedades(ficheroPropiedades,propiedades);

            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),especialesString);
            IEspecialDAL iespeciales = new EspecialDAL();
            iespeciales.guardarEspecial(ficheroEspeciales, especiales);

            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),casillasString);
            ICasillaDAL icasillas = new CasillaDAL();
            icasillas.guardarCasilla(ficheroCasillas, casillas);

            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),usuariosString);
            IJugadorDAL ijugadores = new JugadorDAL();
            ijugadores.guardarUsuario(ficheroUsuarios, jugadores);

            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),tsorpresasuerteString);
            ITSorpresaSuerteDAL itsorpresasuerte = new TSorpresaSuerteDAL();
            itsorpresasuerte.guardarITSorpresaSuerte(ficheroTSorpresaSuerte, tarjetasCCySuerte);

            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),tablerosString);
            ITableroDAL itablero = new TableroDAL();
            itablero.guardarTablero(ficheroTableros, tablero);

            utilXML.crearXMLGuardar(directorio.getAbsolutePath(),partidasString);
            IPartidaDAL ipartida = new PartidaDAL();
            ipartida.guardarPartida(ficheroPartidas, partida);

        }
        utilServlet.mostrarVista("./jsp/partida.jsp", request, response);             
    }
    
    
     /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
