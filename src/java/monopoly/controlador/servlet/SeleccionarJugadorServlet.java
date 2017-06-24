/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;
import java.io.IOException; 
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
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
import monopoly.modelo.ICasillaDAL;
import monopoly.modelo.IEspecialDAL;
import monopoly.modelo.IJugadorDAL;
import monopoly.modelo.IPartidaDAL;
import monopoly.modelo.IPropiedadDAL;
import monopoly.modelo.ITSorpresaSuerteDAL;
import monopoly.modelo.ITableroDAL;
import monopoly.util.UtilesServlets;
import monopoly.util.UtilesXML;
/**
 * Utilizado para definir qué haran cada uno de los botones utilizados para crear
 * los jugadores
 * @author Rodrigo
 */
public class SeleccionarJugadorServlet extends HttpServlet {
        Tablero tableroNuevo = new Tablero();
        Partida partidaNueva=new Partida();
    /**
     * Procesa la petición
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        
        try{
           response.setContentType("text/html;charset=UTF-8");
           // Recoger el parametro ficha y su numero correspondiente
           String jugadoresHumanos=request.getParameter("jugadoresHumanos");
           if(jugadoresHumanos!=null && "jugadoresHumanos".equals(jugadoresHumanos)){            
               enviarJugadoresHumanos(request,response);            
           }
           String jugadoresCPU=request.getParameter("CPUName");
           if(jugadoresCPU!=null && !jugadoresCPU.isEmpty() && !"null".equals(jugadoresCPU)){        
               crearPartida(request, response);
               //Aquí termino de crear todos los jugadores, tanto humanos como CPU.
                enviarJugadoresCPU(request,response,partidaNueva);
           } 
        }catch(ServletException | IOException ex){
            System.out.println("Error: "+ex);
        }
        
     }
    
    /**
     * Contiene los objetos necesarios para crear la partida.
     * Además se reenvía a la ventana partida los objetos.
     * @param request peticion de la pagina
     * @param response respuesta de la pagina
     */
    private void crearPartida(HttpServletRequest request, HttpServletResponse response){
        UtilesXML utilXML= new UtilesXML();                
        
            IEspecialDAL casillasEspeciales = new EspecialDAL();
            IPropiedadDAL casillasPropiedades = new PropiedadDAL();
            ICasillaDAL casillas = new CasillaDAL();
            ITSorpresaSuerteDAL tarjetaCCySuerte= new TSorpresaSuerteDAL();
            ITableroDAL tableros= new TableroDAL();
            IPartidaDAL partidas= new PartidaDAL();
            
                        
            List <Especial> listaCasillasEspeciales = casillasEspeciales.obtenerTodasEspeciales();
            List <Propiedad> listaCasillasPropiedades = casillasPropiedades.obtenerTodasPropiedades();
            List <Casilla> listaCasillas = casillas.obtenerTodasCasillas();
            List <TSorpresaSuerte> listaTarjetaCCySuerte= tarjetaCCySuerte.obtenerTodasTsSorpresaSuerte();
            //Si no existe el fichero tableros.xml lo creo
            if(utilXML.crearXML("tableros.xml")){
                tableroNuevo.setId(1);     
                System.out.println("pasa por aqui");
                tableroNuevo.setTurno(1);
                tableroNuevo.setFondoDinero(0);
                
            }else{               
                List<Tablero> listaTableros = tableros.obtenerTodosTableros();
                if(!listaTableros.isEmpty()){
                    int idUltimoTablero = 0;
                    if(listaTableros.size()>0){
                        tableroNuevo.setId(listaTableros.size()-1);
                        tableroNuevo.setTurno(1);
                        tableroNuevo.setFondoDinero(0);
                    }else{
                        tableroNuevo.setId(1);
                        tableroNuevo.setTurno(1);
                        tableroNuevo.setFondoDinero(0);
                    }
                }                
            }
            //Si no existe el fichero partidas.xml lo creo
            if(utilXML.crearXML("partidas.xml")){
                partidaNueva.setId(0);                            
                partidaNueva.setIdTablero(tableroNuevo.getId());
            }else{
                
                List<Partida> listaPartidas = partidas.obtenerTodasPartidas();
                if(!listaPartidas.isEmpty()){
                    if(listaPartidas.size()>0){
                        partidaNueva.setId(listaPartidas.size());                    
                        partidaNueva.setIdTablero(tableroNuevo.getId());

                    }else{
                        Date fechaHoy=new Date();
                        partidaNueva.setId(1);
                        partidaNueva.setIdTablero(tableroNuevo.getId());
                        partidaNueva.setNombre(fechaHoy.toString());
                    }                
                }
            }
            
            //Aquí envío las listas, el tablero y la partida a partida.jsp
                request.getSession().setAttribute("listaEspeciales",listaCasillasEspeciales);
                request.getSession().setAttribute("listaPropiedades",listaCasillasPropiedades);
                request.getSession().setAttribute("listaCasillas",listaCasillas);
                request.getSession().setAttribute("listaTarjetaCCySuerte",listaTarjetaCCySuerte);
                request.getSession().setAttribute("tableroNuevo",tableroNuevo);
                request.getSession().setAttribute("partidaNueva",partidaNueva);
              
    }
    
    /**
     * Envía los jugadores de tipo CPU a la partida. Si el número de jugadores
     * es superior a 8 devuelve un mensaje y muestra de nuevo la pantalla de 
     * seleccionar jugadores CPU
     * @param request
     * @param response
     * @see enviarJugadoresHumanos
     * @throws ServletException
     * @throws IOException 
     */
    private void enviarJugadoresCPU(HttpServletRequest request,
            HttpServletResponse response, Partida partidaNueva) throws ServletException, IOException {
        UtilesServlets utilServlet= new UtilesServlets();
        utilServlet.eliminarMensajesDeError(request, response);
        String jugadoresHumanosTotales=String.valueOf(request.getSession().getAttribute("numeroTotalJugadoresHumanos"));
        String jugadoresCPUTotales=request.getParameter("CPUName").substring(0, 1);
        
        int intJugadoresHumanosTotales=Integer.parseInt(jugadoresHumanosTotales);
        int intJugadorCPUTotales=Integer.parseInt(jugadoresCPUTotales);
        UtilesXML utilXML = new UtilesXML();
        int totales = intJugadoresHumanosTotales+intJugadorCPUTotales;
        //Si el numero total de jugadores es mayor que 8 devuelvo un mensaje. Si no, continua.
        if(totales>8){
            utilServlet.mensajeErrorNumTotalJugadores(request, intJugadorCPUTotales);
            utilServlet.mostrarVista("./jsp/seleccionarNumCPU.jsp", request, response);
        }else{
            /* Obtengo el listado de jugadores humanos que envié al pasar a esta ventana
            con el método setAttribute (ver función enviarJugadoresHumanos) */
            List <Jugador> jugadores=(ArrayList<Jugador>)request.getSession().getAttribute("jugadores");
            int numeroJugadores = 0;
            
            List <String> figuras = new ArrayList<>();
            figuras.add("barco"); figuras.add("sombrero"); figuras.add("dedal"); figuras.add("zapato"); figuras.add("perro");
            figuras.add("coche"); figuras.add("plancha"); figuras.add("carretilla");
            int contadorJugador = 0;
            
            /*recorro la lista de jugadores para conocer la figura que ha escogido
            cada jugador, de tal manera que elimine del listado de figuras,
            aquellas figuras que ya han sido elegidas. De este modo
            el ordenador podrá coger el resto de figuras libres.
            Además me aseguro de que cada jugador corresponde al mismo id de la partida.
            */
            for(int x = 0; x<jugadores.size();x++) {
                Jugador jugador = jugadores.get(x);
                for(int i = 0; i<figuras.size();i++){
                    if(figuras.get(i).equals(jugador.getFigura())){
                        figuras.remove(i);
                    }
                }
                jugador.setIdPartida(partidaNueva.getId());
                jugadores.set(x, jugador);
            }            
            
            /*Almaceno los jugadores de la CPU en la lista*/
            for (int i=1; i<=intJugadorCPUTotales;i++){
                Jugador jugador= new Jugador();
                jugador.setId(intJugadoresHumanosTotales+i);
                jugador.setNombre("CPU "+i);
                jugador.setFigura(figuras.get(i-1));
                jugador.setDinero(1500);
                jugador.setIdCasilla(0);
                jugador.setIdPartida(partidaNueva.getId());
                jugador.setTurno(1);
                jugador.setEstadoTurno(0);     
                jugador.setTurnoCarcel(0);
                jugador.setCogeTarjeta(0);
                jugador.setEstadoParaComprar(1);
                jugadores.add(jugador);
            }
            IJugadorDAL jugadoresDAL = new JugadorDAL();
            //Si existe el fichero xml de usuarios almaceno el contenido en el arrayList.
            if(!utilXML.crearXML("usuarios.xml")){                                            
                List <Jugador> listaJugadores = jugadoresDAL.obtenerTodosUsuarios();
                for(int i = 0; i<jugadores.size();i++){
                    listaJugadores.add(jugadores.get(i));
                }             
                SecureRandom rndm = new SecureRandom();
                //Mezclo el arrayList para que sea aleatorio el comienzo.
                Collections.shuffle(jugadores, rndm);
                request.getSession().setAttribute("listaJugadoresTotales", jugadores);
            }
            
            SecureRandom rndm = new SecureRandom();
            Collections.shuffle(jugadores, rndm);
            jugadores.get(0).setEstadoTurno(1);
            request.getSession().setAttribute("listaJugadoresPartida", jugadores);
            utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
        }     
             
    }
    
   /**
     * Envío un listado de los jugadores humanos a seleccionarNumCPU, de tal
     * manera que sepa cuántos jugadores van a jugar.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */ 
    private void enviarJugadoresHumanos(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UtilesServlets utilServlet= new UtilesServlets();
        utilServlet.eliminarMensajesDeError(request, response);  
        UtilesXML utilXML = new UtilesXML();
        //Según se avance el desarrollo, hay que tener en cuenta que ese ArrayList
        //tiene que cambiar por jugadorDAL.obtenerTodosUsuarios 
        IJugadorDAL jugadorDAL = new JugadorDAL();
        List <Jugador> jugadores = new ArrayList<>();
        int dineroInicial=1500;
        int casillaInicial=0;
        String opcion = request.getParameter("op");        
        int numJugadores=Integer.parseInt(opcion);
        for(int i = 1; i <=numJugadores; i++){
            /*
            Si hay algun dato nulo le devolvemos a la pantalla de elección de jugadores.
            Si no, continúa almacenando los jugadores en la lista.
            */
            if((request.getParameter("ficha"+i)!=null && !request.getParameter("ficha"+i).isEmpty())
                    && (request.getParameter("nombre"+i)!=null && !request.getParameter("nombre"+i).isEmpty())){
                Jugador jugador = new Jugador();
                String ficha = request.getParameter("ficha"+i);
                String nombre = request.getParameter("nombre"+i);
                jugador.setId(i);
                jugador.setFigura(ficha);
                jugador.setNombre(nombre);
                jugador.setIdCasilla(casillaInicial);
                jugador.setDinero(dineroInicial);
                jugador.setEstadoTurno(0);
                jugador.setTurno(1);   
                jugador.setTurnoCarcel(0);
                jugador.setCogeTarjeta(0);                
                jugador.setEstadoParaComprar(1);
                jugadores.add(jugador);
            }else{
                jugadores.clear();
                utilServlet.mensajeErrorAnhadirJugadoresNulos(request);
                utilServlet.mostrarVista("./jsp/seleccionarNumJugadores.jsp", request, response);
            }
        }
        //Listo las figuras.
        List <String> figuras = new ArrayList<>();
        figuras.add("barco"); figuras.add("sombrero"); figuras.add("dedal"); figuras.add("zapato"); figuras.add("perro");
        figuras.add("coche"); figuras.add("plancha"); figuras.add("carretilla");
        List <String> figurasJugadores= new ArrayList<>();
        //recorro la lista de jugadores y agrego las figuras de los jugadores a un listado
        jugadores.forEach((jugador) -> {
            figurasJugadores.add(jugador.getFigura());
        });
        //comparo las listas de figuras, si una se repite salta un error y me 
        //devuelve otra vez a la ventana de eleccion de jugadores humanos.        
        for(int i = 0; i<figuras.size();i++){
            int figuraRepetida=0;
            for(int j = 0; j<figurasJugadores.size();j++ ){
                if(figurasJugadores.get(j).equals(figuras.get(i))){
                    figuraRepetida++;
                    //Los jugadores empiezan en 1, pero j empieza en 0, con lo cual,
                    //para saber qué jugador es el que ha duplicado ficha, se pone +1
                    //Además limpiamos la lista de jugadores y volvemos a reenviar la dirección
                    //a nuestra página actual.
                    if(figuraRepetida==2){
                        int idJugador=j+1;
                        jugadores.clear();
                        utilServlet.mensajeErrorFigurasJugadoresDuplicadas(request, idJugador);                    
                        utilServlet.mostrarVista("./jsp/seleccionarNumJugadores.jsp", request, response);
                                                                
                    }
                }
            }
        }
        //si jugadores humanos es igual a 8 no tenemos que ir a la pantalla de elegir
        //CPU. Sino, vamos a seleccionarNumCPU        
            if(numJugadores==8){
                //Mezclo el arrayList para que sea aleatorio el comienzo.
                crearPartida(request, response);
                IJugadorDAL jugadoresDAL = new JugadorDAL();
                //Si existe el fichero xml de usuarios almaceno el contenido en el arrayList.
                if(!utilXML.crearXML("usuarios.xml")){                                            
                    List <Jugador> listaJugadores = jugadoresDAL.obtenerTodosUsuarios();
                    for(int i = 0; i<jugadores.size();i++){
                        listaJugadores.add(jugadores.get(i));
                    }             
                    SecureRandom rndm = new SecureRandom();
                    //Mezclo el arrayList para que sea aleatorio el comienzo.
                    Collections.shuffle(jugadores, rndm);
                    request.getSession().setAttribute("listaJugadoresTotales", jugadores);
                }
                
                SecureRandom rndm = new SecureRandom();
                Collections.shuffle(jugadores, rndm);
                jugadores.get(0).setEstadoTurno(1);
                request.getSession().setAttribute("listaJugadoresPartida", jugadores);
                utilServlet.mostrarVista("./jsp/partida.jsp", request, response);
            }else{        
                SecureRandom rndm = new SecureRandom();
                //Mezclo el arrayList para que sea aleatorio el comienzo.
                Collections.shuffle(jugadores, rndm);
                request.getSession().setAttribute("jugadores", jugadores);
                utilServlet.mostrarVista("./jsp/seleccionarNumCPU.jsp", request, response);
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
