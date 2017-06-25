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
import monopoly.modelo.entidades.Especial;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.entidades.Propiedad;
import monopoly.modelo.entidades.TSorpresaSuerte;
import monopoly.modelo.entidades.Tablero;
import monopoly.util.UtilesServlets;

/**
 *
 * @author Rodrigo
 */
public class CogerTarjetaCajaComunidadYSuerteServlet extends HttpServlet{
    
    /**
     * Procesa la peticion
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        
         response.setContentType("text/html;charset=UTF-8");
         UtilesServlets utilServlet = new UtilesServlets();
         
         
        
         String cogeTarjeta=request.getParameter("terminarTarjeta");
         System.out.println("Se ha cogido una tarjeta");
         if(cogeTarjeta!=null){                
           cogerTarjeta(request, response);     
         }        
     }
    private int sumarBonusTarjeta(Jugador jugador, TSorpresaSuerte tarjeta){
        return jugador.getDinero()+((tarjeta.getBonus()));
    }
    /**
     * Método que permite gestionar el resultado de la carta escogida.
     * @param request peticion de la pagina
     * @param response respuesta de la pagina 
     */
    private void cogerTarjeta(HttpServletRequest request, HttpServletResponse response){
        try {
            UtilesServlets utilServlet = new UtilesServlets();
            List<Propiedad> propiedades = (ArrayList<Propiedad>)request.getSession().getAttribute("listaPropiedades");
            List<Jugador> jugadores=(List<Jugador>)request.getSession().getAttribute("listaJugadoresPartida");
            List<TSorpresaSuerte> tarjetas = (ArrayList<TSorpresaSuerte>)request.getSession().getAttribute("listaTarjetas");
            List<Especial> especiales=(List<Especial>)request.getSession().getAttribute("listaEspeciales");
            Tablero tablero=(Tablero)request.getSession().getAttribute("tableroNuevo");
            int idTarjeta=(int)request.getSession().getAttribute("idTarjeta");
            Jugador jugador=(Jugador)request.getSession().getAttribute("turnoDeJugador");
            TSorpresaSuerte tarjeta=tarjetas.get(idTarjeta);
            int resultado1=(Integer)request.getSession().getAttribute("resultado1");
            int resultado2=(Integer)request.getSession().getAttribute("resultado2");
            int numVecesDadosRep=(Integer)request.getSession().getAttribute("numVecesDadosRep");
            
            //RECORDAR QUE COMO SE SACA DE UN ARRAY COMIENZA EN 0 EN LUGAR DE 1
                if(tarjeta.getTipo().equals("CARTA SORPRESA")){
                    switch(idTarjeta){
                        case 0:                            
                            jugador.setIdCasilla(0);
                            jugador.setEstadoTurno(2);
                            jugador.setDinero(jugador.getDinero()+200);
                            break;
                        case 1:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 2:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));                            
                            jugador.setEstadoTurno(2);                            
                            break;
                        case 3:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 4:
                            
                            break;
                        case 5:
                            //Si el jugador cae en la casilla de "ve a la carcel",
                            //el jugador va a la casilla de visita carcel.
                            jugador.setIdCasilla(30);
                            if(jugador.getIdCasilla()==30){
                                jugador.setIdCasilla(10);
                                jugador.setTurnoCarcel(3);
                                jugador.setEstadoTurno(1);
                            }
                            break;
                        case 6:
                            for(int i=0;i<jugadores.size();i++){
                                if(jugadores.get(i).getId()!=jugador.getId()){
                                    jugadores.get(i).setDinero(jugadores.get(i).getDinero()-50);                                    
                                }
                            }
                            jugador.setDinero(jugador.getDinero()+(50*(jugadores.size()-1)));
                            jugador.setEstadoTurno(2);
                            break;
                        case 7:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 8:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 9:
                            for(int i=0;i<jugadores.size();i++){
                                if(jugadores.get(i).getId()!=jugador.getId()){
                                    jugadores.get(i).setDinero(jugadores.get(i).getDinero()-10);                                    
                                }
                            }
                            jugador.setDinero(jugador.getDinero()+(10*(jugadores.size()-1)));
                            jugador.setEstadoTurno(2);
                            break;
                        case 10:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 11:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 12:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 13:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 14:
                            //ES DE LAS CASAS. COMO NO USO NO ES NECESARIO
                            break;
                        case 15:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta)); 
                            jugador.setEstadoTurno(2);
                            break;
                    }
                }
                if(tarjeta.getTipo().equals("CARTA SUERTE")){
                    switch(idTarjeta){
                        case 0:
                            jugador.setIdCasilla(0);
                            jugador.setEstadoTurno(2);
                            jugador.setDinero(jugador.getDinero()+200);
                            break;
                        case 1:
                            jugador.setIdCasilla(39);
                            jugador.setEstadoTurno(2);
                            break;
                        case 2:
                            jugador.setIdCasilla(1);
                            jugador.setEstadoTurno(2);
                            break;
                        case 3:
                            for(int i =0;i<propiedades.size();i++){
                                if(propiedades.get(i).getIdCasilla()>jugador.getIdCasilla()
                                    && (propiedades.get(i).getTipo().equals("OTROS"))){
                                    jugador.setIdCasilla(propiedades.get(i).getIdCasilla()); 
                                    jugador.setEstadoTurno(2);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            for(int i =0;i<propiedades.size();i++){
                                if(propiedades.get(i).getIdCasilla()>jugador.getIdCasilla()
                                    && (propiedades.get(i).getTipo().equals("ESTACION"))){
                                    jugador.setIdCasilla(propiedades.get(i).getIdCasilla()); 
                                    jugador.setEstadoTurno(2);
                                    break;
                                }
                            }
                            break;
                        case 5:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 6:
                               
                            break;
                        case 7:
                            for(int i=0;i<3;i++){
                                if(jugador.getIdCasilla()==0){
                                    jugador.setIdCasilla(39);
                                }else{
                                    jugador.setIdCasilla(jugador.getIdCasilla() - 1);
                                }
                                jugador.setEstadoTurno(2);
                            }
                            break;
                        case 8:
                            //Si el jugador cae en la casilla de "ve a la carcel",
                            //el jugador va a la casilla de visita carcel.
                            jugador.setIdCasilla(30);
                            if(jugador.getIdCasilla()==30){
                                jugador.setIdCasilla(10);
                                jugador.setTurnoCarcel(3);
                                jugador.setEstadoTurno(1);
                            }
                            break;
                        case 9:
                            //ES DE LAS CASAS. COMO NO USO NO ES NECESARIO
                            break;
                        case 10:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 11:
                            jugador.setIdCasilla(5);
                            jugador.setEstadoTurno(2);
                            break;
                        case 12:
                            for(int i=0;i<jugadores.size();i++){
                                if(jugadores.get(i).getId()!=jugador.getId()){
                                    jugadores.get(i).setDinero(jugadores.get(i).getDinero()-50);                                    
                                }
                            }
                            jugador.setDinero(jugador.getDinero()+(50*(jugadores.size()-1)));
                            jugador.setEstadoTurno(2);
                            break;
                        case 13:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                        case 14:
                            jugador.setDinero(sumarBonusTarjeta(jugador,tarjeta));
                            jugador.setEstadoTurno(2);
                            break;
                    }  
                }
            boolean primeraEstacion=false;
            boolean segundaEstacion=false;
            boolean terceraEstacion=false;
            boolean cuartaEstacion=false;
            boolean centralElectrica=false;
            boolean centralAgua=false;
            boolean caeEnCasillaEstacion=false;
            boolean caeEnCasillaCentral=false;
            for(int i = 0; i<jugadores.size();i++){                
                if(jugador.getId()==jugadores.get(i).getId()){
                    if(resultado1==resultado2){
                        jugador.setEstadoTurno(1);
                        numVecesDadosRep++;
                        
                        //Si el numero de veces que se repite la tirada de dobles
                        //es igual a 3, el jugador va a la cárcel                        
                        if (numVecesDadosRep==3){
                            jugador.setIdCasilla(10);
                            jugador.setTurnoCarcel(3);
                            jugador.setEstadoTurno(1);
                        }
                    }else{
                        jugador.setEstadoTurno(2);
                        numVecesDadosRep=0;
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
                                            dinero=(10)*4;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                        if(centralElectrica==true && centralAgua==true){
                                            dinero=(10)*10;
                                            System.out.println("El alquiler para "+propiedades.get(r).getNombre()+" es "+dinero);
                                        }
                                    }                                                                    
                                    jugadores.get(x).setDinero(jugadores.get(x).getDinero()+dinero);
                                    System.out.println("El jugador "+jugadores.get(x).getNombre()+" ha cobrado "+dinero+" del alquiler");
                                }
                            }
                            if(jugador.getDinero()<0){
                                request.getSession().setAttribute("jugadorHaPerdido", "El jugador"+jugador.getNombre()+" ha perdido. Todas sus pertenencias han pasado a la banca.");
                            }
                            // si el id del jugador es igual al id del propietario de la propiedad y no es igual a cero paga alquiler...
                            //(cero es neutro).
                            if(jugador.getId()!=propiedades.get(p).getIdUsuario()
                                    && propiedades.get(p).getIdUsuario()!=0 &&
                                    (jugador.getDinero()-dinero>0)){
                                jugador.setDinero(jugador.getDinero()-dinero);                                
                                System.out.println("El jugador "+jugador.getNombre()+" ha pagado "+dinero+" del alquiler");                               
                            }
                            if(jugador.getId()!=propiedades.get(p).getIdUsuario()
                                    && propiedades.get(p).getIdUsuario()!=0 &&
                                    (jugador.getDinero()-dinero<0)){
                                System.out.println("El jugador "+jugador.getNombre()+" ha perdido");  
                                jugador.setDinero((jugadores.get(i).getDinero()-dinero));
                                for(int h=0;h<propiedades.size();h++){
                                    if(propiedades.get(h).getIdUsuario()==jugador.getId()){
                                        propiedades.get(h).setIdUsuario(propiedades.get(p).getIdUsuario());                                           
                                        System.out.println("El jugador entrega sus propiedades");
                                            request.getSession().setAttribute("jugadorHaPerdido", 
                                            "El jugador"+jugador.getNombre()+" ha perdido.");                                            
                                    }
                                }
                                
                            }                                
                        }                                                
                    }
                    //En caso de que sea una casilla de impuestos especiales pagará lo correspondiente el jugador.
                    for(int esp=0; esp<especiales.size();esp++){
                        if(jugador.getIdCasilla()==especiales.get(esp).getIdCasilla()
                                && (especiales.get(esp).getId()==2 || especiales.get(esp).getId()==11)
                                &&(jugador.getDinero()+(especiales.get(esp).getBonus()))>0){
                            tablero.setFondoDinero(-1*(especiales.get(esp).getBonus()));
                            jugadores.get(i).setDinero(jugador.getDinero()+(especiales.get(esp).getBonus()));                            
                            System.out.println("El jugador "+jugador.getNombre()+" ha pagado "+especiales.get(esp).getBonus()+" de impuestos");
                            
                        }
                        if(jugador.getIdCasilla()==especiales.get(esp).getIdCasilla()
                                && (especiales.get(esp).getId()==2 || especiales.get(esp).getId()==11)
                                &&(jugador.getDinero()+(especiales.get(esp).getBonus()))<0){
                            System.out.println("El jugador "+jugador.getNombre()+" ha perdido");
                            jugadores.get(i).setDinero(jugador.getDinero()+(especiales.get(esp).getBonus()));
                            for(int h=0;h<propiedades.size();h++){
                                if(propiedades.get(h).getIdUsuario()==jugador.getId()){
                                        propiedades.get(h).setIdUsuario(0);
                                        request.getSession().setAttribute("jugadorHaPerdido", "El jugador"+jugador.getNombre()+" ha perdido. Todas sus pertenencias han pasado a la banca.");
                                }
                            }
                        }
                    }
                }
            }
            for(int i=0;i<jugadores.size();i++){
                if(jugadores.get(i).getId()==jugador.getId()){
                    jugadores.get(i).setCogeTarjeta(jugador.getCogeTarjeta());
                    jugadores.get(i).setDinero(jugador.getDinero());
                    jugadores.get(i).setEstadoParaComprar(jugador.getEstadoParaComprar());
                    jugadores.get(i).setEstadoTurno(jugador.getEstadoTurno());
                    jugadores.get(i).setIdCasilla(jugador.getIdCasilla());
                    jugadores.get(i).setTurnoCarcel(jugador.getTurnoCarcel());
                    jugadores.get(i).setTurno(jugador.getTurno());
                }
            }
            
            request.getSession().setAttribute("listaJugadoresPartida",jugadores);
            request.getSession().setAttribute("numVecesDadosRep", numVecesDadosRep);
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);        
        } catch (IOException |ServletException ex) {
            Logger.getLogger(CogerTarjetaCajaComunidadYSuerteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
