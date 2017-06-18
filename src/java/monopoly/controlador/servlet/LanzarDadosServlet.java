/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monopoly.modelo.entidades.Casilla;
import monopoly.modelo.entidades.Especial;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.entidades.Propiedad;
import monopoly.modelo.entidades.Tablero;
import monopoly.util.UtilesServlets;

/**
 *
 * @author Rodrigo
 */
public class LanzarDadosServlet extends HttpServlet{

    /**
     * Procesa la petición
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        try{ 
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         utilServlet.eliminarMensajesDeError(request, response); 
         String lanzarDados=request.getParameter("lanzarDados");
         System.out.println("Lanza dados "+lanzarDados);
         Jugador jugador = new Jugador();
         List<Casilla> casillas = new ArrayList<Casilla>();
         List<Propiedad> propiedades = new ArrayList<Propiedad>();
         List<Especial> especiales = new ArrayList<Especial>();
         Tablero tablero = new Tablero();
         if(lanzarDados!=null){                
           lanzarDados(request, response, jugador, casillas, propiedades, especiales,tablero);     
         }
        }catch(IOException ex){
            System.out.println("Error: "+ex);
        }
         
     }
    
    /**
     * Utilizado para responder a la petición de lanzar dados.
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     * @param jugador Jugador que lanza los dados
     */
    private void lanzarDados(HttpServletRequest request, HttpServletResponse response, Jugador jugador, List <Casilla> casillas, List <Propiedad> propiedades, List<Especial> especiales, Tablero tablero){
        try {
            UtilesServlets utilServlet = new UtilesServlets();  
            
            int posicionJugador = (int) request.getSession().getAttribute("posicionJugador");
            
            jugador=(Jugador)request.getSession().getAttribute("turnoDeJugador");
            casillas=(List<Casilla>) request.getSession().getAttribute("listaCasillas");
            propiedades=(List<Propiedad>)request.getSession().getAttribute("listaPropiedades");
            especiales=(List<Especial>)request.getSession().getAttribute("listaEspeciales");
            tablero=(Tablero)request.getSession().getAttribute("tableroNuevo");
            int resultado1=(Integer)request.getSession().getAttribute("resultado1");
            int resultado2=(Integer)request.getSession().getAttribute("resultado2");
            int numVecesDadosRep=(Integer)request.getSession().getAttribute("numVecesDadosRep");
            
            boolean primeraEstacion=false;
            boolean segundaEstacion=false;
            boolean terceraEstacion=false;
            boolean cuartaEstacion=false;
            boolean centralElectrica=false;
            boolean centralAgua=false;
            boolean caeEnCasillaEstacion=false;
            boolean caeEnCasillaCentral=false;
            
            //posicion actual del jugador
            jugador.setIdCasilla(posicionJugador);
            
            System.out.println("El jugador se encuentra en la casilla "+jugador.getIdCasilla());
            List <Jugador> jugadores= (List <Jugador>)request.getSession().getAttribute("listaJugadoresPartida");
            for(int i = 0; i<jugadores.size();i++){
                //permito al jugador tras lanzar dados que pueda comprar.
                //jugadores.get(i).setEstadoParaComprar(1);
                if(jugador.getId()==jugadores.get(i).getId()){
                    if(resultado1==resultado2){
                        jugadores.get(i).setEstadoTurno(1);
                        numVecesDadosRep++;
                        
                        //Si el numero de veces que se repite la tirada de dobles
                        //es igual a 3, el jugador va a la cárcel                        
                        if (numVecesDadosRep==3){
                            jugadores.get(i).setIdCasilla(10);
                            jugadores.get(i).setTurnoCarcel(3);
                            jugadores.get(i).setEstadoTurno(1);
                        }
                    }else{
                        jugadores.get(i).setEstadoTurno(2);
                        numVecesDadosRep=0;
                    }
                    //Compruebo si el jugador esta en la casilla de CC o de suerte. 
                    //En caso de que este, indico que coja tarjeta.
                    for (int j=0;j<casillas.size();j++){
                        if(jugador.getIdCasilla()==casillas.get(j).getId() && 
                                    (casillas.get(j).getNombre().equals("CAJA DE COMUNIDAD") || 
                                     casillas.get(j).getNombre().equals("SUERTE"))){
                            jugador.setCogeTarjeta(1);
                        }
                    }
                    jugadores.get(i).setIdCasilla(jugador.getIdCasilla());
                    //Si el jugador cae en la casilla de "ve a la carcel",
                    //el jugador va a la casilla de visita carcel.
                    if(jugadores.get(i).getIdCasilla()==30){
                        jugadores.get(i).setIdCasilla(10);
                        jugadores.get(i).setTurnoCarcel(3);
                        jugadores.get(i).setEstadoTurno(1);
                    }
                    //Si el jugador cae en una propiedad que no es suya, realiza
                    //el pago correspondiente.                    
                    for(int p=0; p<propiedades.size();p++){ 
                        if(jugador.getIdCasilla()==propiedades.get(p).getIdCasilla()){
                            int dinero=propiedades.get(p).getAlquiler();
                            for(int x=0;x<jugadores.size();x++){
                                if(jugadores.get(x).getId()==propiedades.get(p).getIdUsuario() &&
                                        jugador.getId()!=propiedades.get(p).getIdUsuario()
                                        && propiedades.get(p).getIdUsuario()!=0){  
                                    
                                    //Pasos para cobrar los alquileres en caso de ser estaciones o centrales.
                                    //Por defecto cobra lo que la propiedad indique en el XML
                                    //Estaciones
                                    for(int r=0; r<propiedades.size();r++){                                        
                                        //Si la propiedad en la que cae el jugador es igual a una de mi listado
                                        //de propiedades y de ese listado de propiedades se da el caso
                                        //que su id es 3, 11, 18 o 26 entonces significa que ha caido el jugador
                                        //en una casilla de estación
                                        if(propiedades.get(p).getId()==propiedades.get(r).getId() && 
                                                (propiedades.get(r).getId()==3||propiedades.get(r).getId()==11
                                                ||propiedades.get(r).getId()==18||propiedades.get(r).getId()==26)){
                                            caeEnCasillaEstacion=true;
                                        }
                                        
                                        //si la propiedad del listado de propiedades es 3 y el id del usuario del listado de propiedades
                                        //es el mismo id que el del jugador propietario de esa estación, entonces almaceno un true.
                                        if(propiedades.get(r).getId()==3 && jugadores.get(x).getId()==propiedades.get(r).getIdUsuario()
                                                && caeEnCasillaEstacion==true){
                                            primeraEstacion=true;
                                        }
                                        
                                        //si la propiedad del listado de propiedades es 11 y el id del usuario del listado de propiedades
                                        //es el mismo id que el del jugador propietario de esa estación, entonces almaceno un true.
                                        if(propiedades.get(r).getId()==11 && jugadores.get(x).getId()==propiedades.get(r).getIdUsuario()
                                                && caeEnCasillaEstacion==true){
                                            segundaEstacion=true;
                                        }
                                        
                                        //si la propiedad del listado de propiedades es 18 y el id del usuario del listado de propiedades
                                        //es el mismo id que el del jugador propietario de esa estación, entonces almaceno un true.
                                        if(propiedades.get(r).getId()==18 && jugadores.get(x).getId()==propiedades.get(r).getIdUsuario()
                                                && caeEnCasillaEstacion==true){
                                            terceraEstacion=true;
                                        }
                                        
                                        //si la propiedad del listado de propiedades es 26 y el id del usuario del listado de propiedades
                                        //es el mismo id que el del jugador propietario de esa estación, entonces almaceno un true.
                                        if(propiedades.get(r).getId()==26 && jugadores.get(x).getId()==propiedades.get(r).getIdUsuario()
                                                && caeEnCasillaEstacion==true){
                                            cuartaEstacion=true;
                                        }                                                                                                                        
                                        
                                        //si cualquiera de los casos es true entonces
                                        if(primeraEstacion==true || segundaEstacion==true
                                                ||terceraEstacion==true||cuartaEstacion==true){
                                            dinero=propiedades.get(p).getAlquiler();
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                        //si dos de los casos es true
                                        if(segundaEstacion==true && terceraEstacion==true||
                                                segundaEstacion==true && cuartaEstacion==true||
                                                segundaEstacion==true && primeraEstacion==true||
                                                terceraEstacion==true && cuartaEstacion==true||
                                                primeraEstacion==true && terceraEstacion==true||
                                                primeraEstacion==true && cuartaEstacion==true){
                                            dinero=50;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }   
                                        //si tres de los casos es true
                                        if(terceraEstacion==true && segundaEstacion==true && cuartaEstacion==true||
                                                terceraEstacion==true && segundaEstacion==true && primeraEstacion==true||
                                                segundaEstacion==true && cuartaEstacion==true && primeraEstacion==true){
                                            dinero=100;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                        // si los cuatro casos es true
                                        if(cuartaEstacion==true && terceraEstacion==true && segundaEstacion==true &&
                                                primeraEstacion==true){
                                            dinero=200;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                        
                                        //Compañia electrica y agua                                        
                                        if(propiedades.get(p).getId()==propiedades.get(r).getId() && 
                                                (propiedades.get(r).getId()==8 || propiedades.get(r).getId()==21)){
                                            caeEnCasillaCentral=true;
                                        }                                        
                                        if(propiedades.get(r).getId()==8 
                                               && caeEnCasillaCentral==true){
                                            centralElectrica=true;
                                        }
                                        if(propiedades.get(r).getId()==21 
                                                && caeEnCasillaCentral==true){
                                            centralAgua=true;
                                        }
                                        if(centralElectrica==true||centralAgua==true){                                            
                                            dinero=(resultado1+resultado2)*4;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                        if(centralElectrica==true && centralAgua==true){
                                            dinero=(resultado1+resultado2)*10;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                    }                                                                    
                                    jugadores.get(x).setDinero(jugadores.get(x).getDinero()+dinero);
                                    System.out.println("El jugador "+jugadores.get(x).getNombre()+" ha cobrado "+dinero+" del alquiler");
                                }
                            }
                            // si el id del jugador es igual al id del propietario de la propiedad y no es igual a cero paga alquiler...
                            //(cero es neutro).
                            if(jugadores.get(i).getId()!=propiedades.get(p).getIdUsuario()
                                    && propiedades.get(p).getIdUsuario()!=0 &&
                                    (jugadores.get(i).getDinero()-dinero>0)){
                                jugadores.get(i).setDinero(jugadores.get(i).getDinero()-dinero);                                
                                System.out.println("El jugador "+jugadores.get(i).getNombre()+" ha pagado "+dinero+" del alquiler");                               
                            }
                            if(jugadores.get(i).getId()!=propiedades.get(p).getIdUsuario()
                                    && propiedades.get(p).getIdUsuario()!=0 &&
                                    (jugadores.get(i).getDinero()-dinero<0)){
                                System.out.println("El jugador "+jugadores.get(i).getNombre()+" ha perdido");  
                                jugadores.get(i).setDinero((jugadores.get(i).getDinero()-dinero));
                                for(int h=0;h<propiedades.size();h++){
                                    if(propiedades.get(h).getIdUsuario()==jugadores.get(i).getId()){
                                        propiedades.get(h).setIdUsuario(propiedades.get(p).getIdUsuario());                                           
                                        System.out.println("El jugador entrega sus propiedades");
                                            request.getSession().setAttribute("jugadorHaPerdido", 
                                            "El jugador"+jugadores.get(i).getNombre()+" ha perdido.");                                            
                                    }
                                }
                                
                            }                                
                        }                                                
                    }
                    //En caso de que sea una casilla de impuestos especiales pagará lo correspondiente el jugador.
                    for(int esp=0; esp<especiales.size();esp++){
                        if(jugadores.get(i).getIdCasilla()==especiales.get(esp).getIdCasilla()
                                && (especiales.get(esp).getId()==2 || especiales.get(esp).getId()==11)
                                &&(jugadores.get(i).getDinero()+(especiales.get(esp).getBonus()))>0){
                            tablero.setFondoDinero(-1*(especiales.get(esp).getBonus()));
                            jugadores.get(i).setDinero(jugadores.get(i).getDinero()+(especiales.get(esp).getBonus()));                            
                            System.out.println("El jugador "+jugadores.get(i).getNombre()+" ha pagado "+especiales.get(esp).getBonus()+" de impuestos");
                            
                        }
                        if(jugadores.get(i).getIdCasilla()==especiales.get(esp).getIdCasilla()
                                && (especiales.get(esp).getId()==2 || especiales.get(esp).getId()==11)
                                &&(jugadores.get(i).getDinero()+(especiales.get(esp).getBonus()))<0){
                            System.out.println("El jugador "+jugadores.get(i).getNombre()+" ha perdido");
                            jugadores.get(i).setDinero(jugadores.get(i).getDinero()+(especiales.get(esp).getBonus()));
                            for(int h=0;h<propiedades.size();h++){
                                if(propiedades.get(h).getIdUsuario()==jugadores.get(i).getId()){
                                        propiedades.get(h).setIdUsuario(0);
                                        request.getSession().setAttribute("jugadorHaPerdido", "El jugador"+jugadores.get(i).getNombre()+" ha perdido. Todas sus pertenencias han pasado a la banca.");
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Estado "+jugador.getEstadoTurno()+ " del jugador "+jugador.getNombre());
            request.getSession().setAttribute("numVecesDadosRep", numVecesDadosRep);
            request.getSession().setAttribute("listaJugadoresPartida", jugadores);
            request.getSession().setAttribute("listaPropiedades",propiedades);
            request.getSession().setAttribute("tablero",tablero);
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LanzarDadosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
