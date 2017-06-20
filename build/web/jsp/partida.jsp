<%-- 
    Document   : partida
    Created on : 14-abr-2017, 2:22:45
    Author     : Rodrigo
--%>



<%@page import="monopoly.modelo.dal.TSorpresaSuerteDAL"%>
<%@page import="monopoly.modelo.ITSorpresaSuerteDAL"%>
<%@page import="monopoly.controlador.DadoRule"%>
<%@page import="java.util.Random"%>
<%@page import="monopoly.modelo.entidades.Partida"%>
<%@page import="monopoly.modelo.entidades.Tablero"%>
<%@page import="monopoly.modelo.entidades.TSorpresaSuerte"%>
<%@page import="java.util.List"%>
<%@page import="monopoly.modelo.IEspecialDAL"%>
<%@page import="monopoly.modelo.IPropiedadDAL"%>
<%@page import="monopoly.modelo.ICasillaDAL"%>
<%@page import="monopoly.modelo.dal.JugadorDAL"%>
<%@page import="monopoly.modelo.entidades.Jugador"%>
<%@page import="monopoly.modelo.entidades.Casilla"%>
<%@page import="monopoly.modelo.dal.CasillaDAL"%>
<%@page import="monopoly.modelo.entidades.Especial"%>
<%@page import="monopoly.modelo.dal.EspecialDAL"%>
<%@page import="monopoly.modelo.entidades.Propiedad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="monopoly.modelo.dal.PropiedadDAL" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/index.css" type="text/css" media="all" />
        <link rel="stylesheet" href="./css/tablero.css" type="text/css" media="all" />
        <script src="./js/partida.js"></script>
        
        <title>Monopoly</title>
    </head>
    <body>     
        <div id="todoMonopoly">
            <header id="cabecera">
                <img src="./img/monopoly-logo.jpg">
            </header>
            <section id='puntuacionJugadores'> 
                <%                     
                    Jugador turnoDeJugador= new Jugador();
                    Jugador siguienteTurnoDeJugador= new Jugador();
                    List<Jugador> jugadores = new ArrayList<Jugador>();
                    boolean haGanado=false;
                    
                    if(request.getSession().getAttribute("jugadores")!=null){
                        jugadores=(List <Jugador>)request.getSession().getAttribute("jugadores");                        
                    }
                    if((List<Jugador>)request.getSession().getAttribute("listaJugadoresPartida")!=null){
                        jugadores=(List <Jugador>)request.getSession().getAttribute("listaJugadoresPartida");                        
                    }                 
                                        
                    int contadorJugadores=0;
                    
                    for (int a = 0; a < jugadores.size(); a++) {
                        if(jugadores.get(a).getEstadoTurno()==1 ||jugadores.get(a).getEstadoTurno()==2){
                            if(jugadores.get(a).getDinero()<0){
                                if(request.getSession().getAttribute("jugadorHaPerdido")!=null){
                                    String jugadorHaPerdido=(String)request.getSession().getAttribute("jugadorHaPerdido");
                                    out.print("<script>"
                                            + "alert('El jugador "+jugadores.get(a).getNombre()+" ha perdido.');"                                                                                              
                                        + "</script>");
                                }
                                jugadores.remove(a);
                                if(a+1<jugadores.size()){
                                    jugadores.get(a+1).setEstadoTurno(1);
                                }
                                if(a+1>=jugadores.size() && jugadores.size()!=1){
                                    jugadores.get(0).setEstadoTurno(1);
                                }
                                if(jugadores.size()==1){
                                    out.print("<script>"
                                            + "alert('El jugador "+jugadores.get(0).getNombre()+" ha ganado.');"                                                                                       
                                        + "</script>");
                                    haGanado=true;
                                }
                                System.out.println("El jugador ha perdido2");                                                              
                            }
                        }
                    }
                    
                    for (int a = 0; a < jugadores.size(); a++) {
                        if(haGanado==false){
                        out.print("<div class='puntuaciones'><label id='jugador'>"
                                + "<strong>" + jugadores.get(a).getNombre() + ":</strong>"
                                + "</label> <label><strong>" + jugadores.get(a).getDinero() + " €" + "</strong>"
                                + "</label>"
                                + "</div><br>");
                        }
                        if(haGanado==true){
                            out.print("<div class='puntuaciones'><label id='jugador'>"
                                + "<strong>¡" + jugadores.get(a).getNombre() + " HA GANADO!</strong>"
                                + "</label>"
                                + "</div><br>");
                        }
                    }
                    
                    //compruebo si jugador está en la cárcel
                    for (int a = 0; a < jugadores.size(); a++) {                       
                            //En caso de que el jugador esté en la cárcel...   
                            if(jugadores.get(a).getEstadoTurno()==1){
                                if(jugadores.get(a).getIdCasilla()==10 && jugadores.get(a).getTurnoCarcel()>0){
                                    System.out.println("Jugador "+jugadores.get(a).getNombre()+" en la cárcel");
                                    System.out.println("El estado turno es: "+jugadores.get(a).getEstadoTurno());
                                    jugadores.get(a).setTurnoCarcel(jugadores.get(a).getTurnoCarcel()-1);
                                    if(jugadores.get(a).getTurnoCarcel()==0){
                                        jugadores.get(a).setDinero(jugadores.get(a).getDinero()-50);
                                    }
                                    jugadores.get(a).setEstadoTurno(0);
                                    System.out.println("Te quedan "+jugadores.get(a).getTurnoCarcel()+" para salir.");
                                    turnoDeJugador=jugadores.get(a);
                                    a++;
                                    if(a==jugadores.size()){
                                        a=0;
                                    }
                                    System.out.println("Pasa el turno al Jugador "+jugadores.get(a).getNombre());
                                    jugadores.get(a).setEstadoTurno(1);
                                    turnoDeJugador=jugadores.get(a);
                                    break;                                                                
                                }
                            }
                    }
                    
                    for (int a = 0; a < jugadores.size(); a++) {     
                            if(jugadores.get(a).getEstadoTurno()==1){
                                contadorJugadores=a;
                                turnoDeJugador=jugadores.get(a);	                            
                                request.getSession().setAttribute("contadorJugadores", contadorJugadores);   
                            }    
                            if(jugadores.get(a).getEstadoTurno()==2){
                                turnoDeJugador=jugadores.get(a);	
                            }                        
                    }                     
                %>
            </section>
            <section>
                    <div id="controles">
                         <% out.print("<h2 id='jugador'>Turno de "+turnoDeJugador.getNombre()+" </h2>"); %>
                            <input type="button" value="Lanzar dados" id="btnLanzarDados"/><br>
                            <input type="button" value="Negociar" id="btnNegociar"/><br>
                            <input type="button" value="Terminar Turno" id="btnTerminar"/><br>
                            <input type="button" value="Guardar Partida" id="btnGuardarPartida"/>
                    </div>
                            <% 
                    if(haGanado==true){
                        out.print("<script>document.getElementById('btnLanzarDados').disabled=true;"
                                  + "document.getElementById('btnNegociar').disabled=true;"
                                  + "document.getElementById('btnTerminar').disabled=true;"
                                  + "document.getElementById('btnGuardarPartida').disabled=true;</script>");
                    }
                    List<Casilla> casillas = (ArrayList<Casilla>) 
                           request.getSession().getAttribute("listaCasillas");
                    List<TSorpresaSuerte> tarjetasCCySuerte = (ArrayList<TSorpresaSuerte>) 
                           request.getSession().getAttribute("listaTarjetaCCySuerte");
                                                           
                    Random rnd = new Random();
                    int minimoRes = 1;                    
                    int result11 = 0;                             
                    
                    if(turnoDeJugador.getCogeTarjeta()==1){
                        for (int j=0;j<casillas.size();j++){
                            System.out.println("Id: "+casillas.get(j).getId()+" - "+"Id Casilla jugador: "+turnoDeJugador.getIdCasilla());
                            System.out.println("Nombre casilla: "+casillas.get(j).getNombre());
                            if(turnoDeJugador.getIdCasilla()==casillas.get(j).getId() && 
                                    (casillas.get(j).getNombre().equals("CAJA DE COMUNIDAD") || 
                                     casillas.get(j).getNombre().equals("SUERTE"))){
                                List <TSorpresaSuerte> tarjetasCC = new ArrayList<TSorpresaSuerte>(); 
                                List <TSorpresaSuerte> tarjetasSuerte = new ArrayList<TSorpresaSuerte>();

                                for(int i = 0; i<tarjetasCCySuerte.size();i++){
                                    if(tarjetasCCySuerte.get(i).getTipo().equals("CARTA SORPRESA")){
                                        tarjetasCC.add(tarjetasCCySuerte.get(i));
                                    }
                                    if(tarjetasCCySuerte.get(i).getTipo().equals("CARTA SUERTE")){
                                        tarjetasSuerte.add(tarjetasCCySuerte.get(i));
                                    }
                                }
                                List <TSorpresaSuerte> tarjetas=new ArrayList<TSorpresaSuerte>();
                                if(casillas.get(j).getNombre().equals("SUERTE")){  
                                    //El maximo es 14 porque el array empieza a contar por 0
                                    int maximoRes = 14;
                                    result11=rnd.nextInt(maximoRes-minimoRes) + minimoRes;
                                    tarjetas=tarjetasSuerte;
                                }else{
                                    //El maximo es 15 porque el array empieza a contar por 0
                                    int maximoRes = 15;
                                    result11=rnd.nextInt(maximoRes-minimoRes) + minimoRes;
                                    tarjetas=tarjetasCC;
                                }
                                out.print("<script>"
                                    +"tarjetaCCSuerte();"
                                    +"document.getElementById('cajaTarjeta').style.position= 'absolute';"    
                                    +"document.getElementById('cajaTarjeta').style.overflow= 'auto';"
                                    +"document.getElementById('cajaTarjeta').style.visibility='visible';"
                                    +"document.getElementById('cajaTarjeta').style.zIndex='1001';"
                                    +"document.body.style.backgroundColor='black';"
                                    +"document.getElementById('todoMonopoly').style.zIndex='1002';"
                                    +"document.getElementById('todoMonopoly').style.opacity='0.60';"
                                    +"document.getElementById('textoTarjeta').style.backgroundColor='white';"
                                    +"document.getElementById('textoTarjeta').style.width='85%';"
                                    +"document.getElementById('textoTarjeta').style.height='30%';"
                                    +"document.getElementById('textoTarjeta').style.marginTop='5%';"
                                    +"document.getElementById('textoTarjeta').style.marginLeft='8%';"
                                    +"document.getElementById('inputAceptarTarjeta').style.marginLeft='42%';"
                                    +"document.getElementById('inputAceptarTarjeta').style.marginTop='10%';"
                                    + "document.getElementById('textoTarjeta').innerHTML='"+tarjetas.get(result11).getDescripcion()+"';"
                                    + "document.getElementById('btnLanzarDados').disabled=true;"
                                    + "document.getElementById('btnNegociar').disabled=true;"
                                    + "document.getElementById('btnTerminar').disabled=true;"
                                    + "document.getElementById('btnGuardarPartida').disabled=true;"

                                    + "document.getElementById('inputAceptarTarjeta').onclick=function(){"                                
                                        + "document.getElementById('todoMonopoly').style.zIndex='1001';"
                                        + "document.getElementById('todoMonopoly').style.opacity='initial';"                                    
                                        + "document.getElementById('cajaTarjeta').style.visibility='hidden';"  
                                        + "document.getElementById('cajaTarjeta').style.zIndex='1002';" 
                                        + "if("+turnoDeJugador.getEstadoTurno()+"==2){"
                                            + "document.getElementById('btnLanzarDados').disabled=true;"
                                            + "document.getElementById('btnNegociar').disabled=false;"
                                            + "document.getElementById('btnTerminar').disabled=false;"
                                            + "document.getElementById('btnGuardarPartida').disabled=false;"
                                        + "}"
                                        + "if("+turnoDeJugador.getEstadoTurno()+"==1){"
                                            + "document.getElementById('btnLanzarDados').disabled=false;"
                                            + "document.getElementById('btnNegociar').disabled=true;"
                                            + "document.getElementById('btnTerminar').disabled=true;"
                                            + "document.getElementById('btnGuardarPartida').disabled=false;"
                                        + "}"        
                                        + "document.getElementById('btnLanzarDados').style.cursor = 'pointer';"
                                        + "document.getElementById('btnNegociar').style.cursor = 'pointer';"
                                        + "document.getElementById('btnTerminar').style.cursor = 'pointer';"
                                        + "document.getElementById('btnGuardarPartida').style.cursor = 'pointer';"
                                    + "}"
                                +"</script>");
                                turnoDeJugador.setCogeTarjeta(0);
                            }
                        }
                    }%>
                </section>
            <section id="tapete">
                <div id="tablero">
                    <div id="vi">
                        <%
                            List<Propiedad> propiedades = (ArrayList<Propiedad>) 
                                    request.getSession().getAttribute("listaPropiedades");
                            List<Especial> especiales = (ArrayList<Especial>) 
                                    request.getSession().getAttribute("listaEspeciales");
                           
                            Tablero tablero = (Tablero)
                                    request.getSession().getAttribute("tableroNuevo");
                            Partida partida = (Partida)
                                    request.getSession().getAttribute("partidaNueva");

                            for (int z = 19; z >= 11; z--) {
                                for (int x = 0; x < especiales.size(); x++) {
                                    if (casillas.get(z).getId() == especiales.get(x).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(z).getId()+"' class='verticalIzquierda'>"
                                                + casillas.get(z).getNombre() + ""
                                                + "<div id='casillafigura"+casillas.get(z).getId()+"' style='width:100px; height:30px;'></div>"
                                                + "</div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(z).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(z).getId()+"' class='verticalIzquierda'>"
                                                + "<div style='width:100px;height:106px;margin-top:5%;'>"
                                                + "<label style='margin-top:5px;'>" + casillas.get(z).getNombre() + "</label>"
                                                + "</div>"
                                                + "<div id='casillafigura"+casillas.get(z).getId()+"' style='width:100px; height:30px;margin-top:-40px;'></div>"
                                                + "<div "
                                                + "style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:136px; width:30px; margin-left:106px; "
                                                + "margin-top:-102.5px;font-family: Arial;'>"
                                                + "</div>"
                                                + "</div>");
                                    }
                                }
                            }
                        %>
                    </div>

                    <div id="har" >
                        <%
                            for (int j = 20; j <= 30; j++) {
                                for (int x = 0; x < especiales.size(); x++) {
                                    if (casillas.get(j).getId() == especiales.get(x).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(j).getId()+"' class='horizontalArriba'>" + casillas.get(j).getNombre() + 
                                                "<div id='casillafigura"+casillas.get(j).getId()+"' style='width:100px; height:30px;'></div></div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(j).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(j).getId()+"' class='horizontalArriba'>"
                                                + "<div style='width:136px;height:40px;font-family: Arial;'>"
                                                + "<div id='casillafigura"+casillas.get(j).getId()+"' style='width:100px; height:30px;'></div>"
                                                + "<label style='margin-top:5px;'>" + casillas.get(j).getNombre() + "</label>"
                                                + "</div><div style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:30px; width:136px; margin-top:66px;'>"
                                                + "</div>"
                                                + "</div>");
                                    }
                                }
                            }
                        %>         
                    </div>
                    <div id="imagenCentro">
                        <img src="./img/monopolyTablero.jpg"/>
                    </div>
                    <div id="hab">
                        <% for (int i = 10; i >= 0; i--) {
                                for (int x = 0; x < especiales.size(); x++) {
                                    if (casillas.get(i).getId() == especiales.get(x).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(i).getId()+"' class='horizontalAbajo'>" + casillas.get(i).getNombre()
                                                + "<div id='casillafigura"+casillas.get(i).getId()+"' style='width:30px; height:100px;'></div></div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(i).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(i).getId()+"' class='horizontalAbajo'>"
                                                + "<div style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:30px; width:136px;'></div>"
                                                + "<div style='width:136px;height:40px;font-family: Arial;'>"
                                                + "<label style='margin-top:5%;'><label style='margin-top:5px;'>"
                                                + casillas.get(i).getNombre() + "</label>"
                                                + "</div>"
                                                + "<div id='casillafigura"+casillas.get(i).getId()+"' style='width:30px; height:100px;'></div>"
                                                + "</div>");
                                    }
                                }

                            }
                        %>                    
                    </div>                

                    <div id="vd">
                        <%
                            for (int k = 31; k <= 39; k++) {
                                for (int x = 0; x < especiales.size(); x++) {
                                    if (casillas.get(k).getId() == especiales.get(x).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(k).getId()+"' class='verticalDerecha'>" + casillas.get(k).getNombre()
                                                + "<div id='casillafigura"+casillas.get(k).getId()+"' style='width:30px; height:100px;'></div></div>"
                                                );
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(k).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div id='"+casillas.get(k).getId()+"' class='verticalDerecha'>"
                                                + "<div style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:136px; width:30px;'></div>"
                                                + "<div style='width:90px;height:136px; margin-left:31px; "
                                                + "margin-top:-136px;font-family: Arial;'>"
                                                + "<label style='margin-top:5px;'>" + casillas.get(k).getNombre() + "</label>"
                                                + "</div>"
                                                + "<div id='casillafigura"+casillas.get(k).getId()+"' style='width:30px; height:100px;margin-left:106px;margin-top:-100px'></div>"
                                                + "</div>");
                                    }
                                }
                            }
                            
                        %>         
                    </div>
                      
                </div>           
            </section>
            
            <%  
                int result1=0;
                int result2=0;
                for(int idespecial=0; idespecial<especiales.size();idespecial++){
                    if(turnoDeJugador.getIdCasilla()==especiales.get(idespecial).getIdCasilla() && 
                        (especiales.get(idespecial).getId()==6) && turnoDeJugador.getEstadoTurno()==2){
                            out.print("<script>alert('El jugador "+turnoDeJugador.getNombre()+" ha ganado "+tablero.getFondoDinero()+" €');</script>");
                            turnoDeJugador.setDinero(turnoDeJugador.getDinero()+tablero.getFondoDinero());
                            tablero.setFondoDinero(0);
                    }                    
                }
                for(int i=0; i<propiedades.size();i++){
                    //Si el id del usuario es = 0 quiere decir que no tiene propietario.
                    if(propiedades.get(i).getIdUsuario()==0 && turnoDeJugador.getIdCasilla()==propiedades.get(i).getIdCasilla()){
                        request.getSession().setAttribute("listaJugadoresPartida", jugadores);
                        request.getSession().setAttribute("jugador", turnoDeJugador);
                    if(turnoDeJugador!=null){
                        if(turnoDeJugador.getEstadoParaComprar()==1){                            
                            out.print("<script>"
                                    +"comprarPropiedad();"
                                    +"document.getElementById('cajaCompraPropiedad').style.position= 'absolute';"    
                                    +"document.getElementById('cajaCompraPropiedad').style.overflow= 'auto';"
                                    +"document.getElementById('cajaCompraPropiedad').style.visibility='visible';"
                                    +"document.getElementById('cajaCompraPropiedad').style.zIndex='1001';"
                                    +"document.body.style.backgroundColor='black';"
                                    +"document.getElementById('todoMonopoly').style.zIndex='1002';"
                                    +"document.getElementById('todoMonopoly').style.opacity='0.60';"                                    
                                    +"document.getElementById('inputSiCompra').style.marginLeft='12%';"
                                    +"document.getElementById('inputSiCompra').style.marginTop='10%';"
                                    +"document.getElementById('inputNoCompra').style.marginLeft='57%';"
                                    +"document.getElementById('inputNoCompra').style.marginTop='10%';"
                                    + "document.getElementById('btnLanzarDados').disabled=true;"
                                    + "document.getElementById('btnNegociar').disabled=true;"
                                    + "document.getElementById('btnTerminar').disabled=true;"
                                    + "document.getElementById('btnGuardarPartida').disabled=true;"
 
                                    + "document.getElementById('inputNoCompra').onclick=function(){"
                                    + "document.getElementById('todoMonopoly').style.zIndex='1001';"
                                    + "document.getElementById('todoMonopoly').style.opacity='initial';"                                    
                                    + "document.getElementById('cajaCompraPropiedad').style.visibility='hidden';"  
                                    + "document.getElementById('cajaCompraPropiedad').style.zIndex='1002';" 
                                    + "if("+turnoDeJugador.getEstadoTurno()+"==2){"
                                        + "document.getElementById('btnLanzarDados').disabled=true;"
                                        + "document.getElementById('btnNegociar').disabled=false;"
                                        + "document.getElementById('btnTerminar').disabled=false;"
                                        + "document.getElementById('btnGuardarPartida').disabled=false;"
                                    + "}"
                                    + "if("+turnoDeJugador.getEstadoTurno()+"==1){"
                                        + "document.getElementById('btnLanzarDados').disabled=false;"
                                        + "document.getElementById('btnNegociar').disabled=true;"
                                        + "document.getElementById('btnTerminar').disabled=true;"
                                        + "document.getElementById('btnGuardarPartida').disabled=false;"
                                    + "}"        
                                        + "document.getElementById('btnLanzarDados').style.cursor = 'pointer';"
                                        + "document.getElementById('btnNegociar').style.cursor = 'pointer';"
                                        + "document.getElementById('btnTerminar').style.cursor = 'pointer';"
                                        + "document.getElementById('btnGuardarPartida').style.cursor = 'pointer';"      
                                    + "}"
                                    +"</script>");                                
                            } 
                        if(turnoDeJugador.getEstadoParaComprar()==0){
                            if(request.getSession().getAttribute("jugadorNoPuedeComprar")!=null){

                                    String jugadorNoPuedeComprar = (String)request.getSession().getAttribute("jugadorNoPuedeComprar");
                                    request.getSession().setAttribute("jugadorNoPuedeComprar",null);
                                    out.print("<script>"
                                                +"comprarPropiedad();"
                                                +"document.getElementById('cajaCompraPropiedad').style.position= 'absolute';"    
                                                +"document.getElementById('cajaCompraPropiedad').style.overflow= 'auto';"
                                                +"document.getElementById('cajaCompraPropiedad').style.visibility='visible';"
                                                +"document.getElementById('cajaCompraPropiedad').style.zIndex='1001';"
                                                +"document.body.style.backgroundColor='black';"
                                                +"document.getElementById('todoMonopoly').style.zIndex='1002';"
                                                +"document.getElementById('todoMonopoly').style.opacity='0.60';"                                                                            
                                                +"document.getElementById('inputSiCompra').style.visibility='hidden';"
                                                +"document.getElementById('inputNoCompra').style.marginLeft='32%';"
                                                +"document.getElementById('inputNoCompra').style.marginTop='10%';"
                                                +"document.getElementById('inputNoCompra').innerHTML='Aceptar';"
                                                +"var msg=document.createElement('label');"
                                                +"msg.innerHTML='"+jugadorNoPuedeComprar+"';"
                                                +"msg.style.marginTop='20px';"
                                                +"msg.style.color='red';"
                                                +"document.getElementById('cajaCompraPropiedad').appendChild(msg);"
                                                + "document.getElementById('btnLanzarDados').disabled=true;"
                                                + "document.getElementById('btnNegociar').disabled=true;"
                                                + "document.getElementById('btnTerminar').disabled=true;"
                                                + "document.getElementById('btnGuardarPartida').disabled=true;"

                                                + "document.getElementById('inputNoCompra').onclick=function(){"
                                                    + "document.getElementById('todoMonopoly').style.zIndex='1001';"
                                                    + "document.getElementById('todoMonopoly').style.opacity='initial';"                                    
                                                    + "document.getElementById('cajaCompraPropiedad').style.visibility='hidden';"  
                                                    + "document.getElementById('cajaCompraPropiedad').style.zIndex='1002';" 
                                                    + "if("+turnoDeJugador.getEstadoTurno()+"==2){"
                                                        + "document.getElementById('btnLanzarDados').disabled=true;"
                                                        + "document.getElementById('btnNegociar').disabled=false;"
                                                        + "document.getElementById('btnTerminar').disabled=false;"
                                                        + "document.getElementById('btnGuardarPartida').disabled=false;"
                                                    + "}"
                                                    + "if("+turnoDeJugador.getEstadoTurno()+"==1){"
                                                        + "document.getElementById('btnLanzarDados').disabled=false;"
                                                        + "document.getElementById('btnNegociar').disabled=true;"
                                                        + "document.getElementById('btnTerminar').disabled=true;"
                                                        + "document.getElementById('btnGuardarPartida').disabled=false;"
                                                    + "}"        
                                                    + "document.getElementById('btnLanzarDados').style.cursor = 'pointer';"
                                                    + "document.getElementById('btnNegociar').style.cursor = 'pointer';"
                                                    + "document.getElementById('btnTerminar').style.cursor = 'pointer';"
                                                    + "document.getElementById('btnGuardarPartida').style.cursor = 'pointer';"      
                                                + "}"
                                            +"</script>");
                                }
                        }
                    }
                   }
                    
                }
                if(turnoDeJugador!=null){
                    if(turnoDeJugador.getEstadoTurno()==1){
                        Random random = new Random();            
                        int numVecesDadosRep=0;
                        int minimo = 1;
                        int maximo = 7;

                        //Como el jugador ha pasado al nuevo turno, puede volver a comprar
                        //tras el lanzamiento de dados.
                        turnoDeJugador.setEstadoParaComprar(1);
                        result1 = random.nextInt(maximo-minimo) + minimo;
                        result2 = random.nextInt(maximo-minimo) + minimo; 
                        System.out.println("Jugador "+turnoDeJugador.getNombre()+" obtiene un resultado de "+result1+" / "+result2);
                        DadoRule dado1= new DadoRule();
                        dado1=dado1.resultadoDado(result1);
                        DadoRule dado2=new DadoRule();
                        dado2=dado2.resultadoDado(result2);

                        out.println("<script>"
                                + "var btnLanzarDados=document.getElementById('btnLanzarDados');"
                                + "btnLanzarDados.disabled=false;"
                                + "document.getElementById('btnNegociar').disabled=true;"
                                + "document.getElementById('btnTerminar').disabled=true;"
                                + "btnLanzarDados.addEventListener('click', function(){"
                                + "document.getElementById('dados1').src='./img/"+dado1.getImagen()+"';"
                                + "document.getElementById('dados2').src='./img/"+dado2.getImagen()+"';"
                                + "});"                            
                                + "</script>");  
                        System.out.println("Turno de Jugador "+turnoDeJugador.getNombre()+ " estado "+turnoDeJugador.getEstadoTurno());
                        int resultadoDados=result1+result2;
                        int posicionJugador=turnoDeJugador.getIdCasilla();
                        for(int i=1; i<=resultadoDados; i++){
                            if(posicionJugador==40){
                                posicionJugador=0;
                                //cobra la salida.
                                turnoDeJugador.setDinero(turnoDeJugador.getDinero()+200);
                            }
                            posicionJugador++;					
                        }	
                        if(posicionJugador==40){
                            posicionJugador=0;     
                            turnoDeJugador.setDinero(turnoDeJugador.getDinero()+200);
                        }


                        if(request.getSession().getAttribute("numVecesDadosRep")!=null){
                            numVecesDadosRep=(Integer)request.getSession().getAttribute("numVecesDadosRep");
                        }
                        System.out.println("Número de veces que los dados se repiten: "+numVecesDadosRep);
                        request.getSession().setAttribute("resultado1",result1);
                        request.getSession().setAttribute("resultado2",result2);
                        request.getSession().setAttribute("posicionJugador",posicionJugador);
                        request.getSession().setAttribute("turnoDeJugador", turnoDeJugador);
                        request.getSession().setAttribute("listaJugadoresPartida", jugadores);
                        request.getSession().setAttribute("numVecesDadosRep", numVecesDadosRep);
                        request.getSession().setAttribute("tableroNuevo", tablero);
                        request.getSession().setAttribute("listaPropiedades", propiedades);
                        request.getSession().setAttribute("listaEspeciales", especiales);
                    }                

                    System.out.println("Turno parte 2 de Jugador "+turnoDeJugador.getNombre()+ " estado "+turnoDeJugador.getEstadoTurno());
                
                    if(turnoDeJugador.getEstadoTurno()==2){
                        out.println("<script>"
                                + "var btnTerminar = document.getElementById('btnTerminar');"
                                + "var btnNegociar = document.getElementById('btnNegociar');"
                                + "var btnLanzarDados=document.getElementById('btnLanzarDados');"
                                + "btnTerminar.disabled=false;"
                                + "btnNegociar.disabled=false;"
                                + "btnLanzarDados.disabled=true;"
                                + "</script>");

                        request.getSession().setAttribute("turnoDeJugador", turnoDeJugador);                 
                    }      
                }
                request.getSession().setAttribute("listaPropiedades", propiedades);
                request.getSession().setAttribute("listaEspeciales", especiales);
                request.getSession().setAttribute("listaCasillas", casillas);
                request.getSession().setAttribute("listaJugadoresTotales", jugadores);
                request.getSession().setAttribute("listaTarjetaCCySuerte", tarjetasCCySuerte);
                request.getSession().setAttribute("tableroNuevo", tablero);
                request.getSession().setAttribute("partidaNueva", partida);
                
                List <String> figuras = new ArrayList<String>();
                figuras.add("barco"); figuras.add("sombrero"); figuras.add("dedal"); figuras.add("zapato"); figuras.add("perro");
                figuras.add("coche"); figuras.add("plancha"); figuras.add("carretilla");              
                
                for(int i=0; i<jugadores.size();i++){
                    int contadorFiguras = 0;
                    for(int j=0; j<figuras.size();j++){
                        if(jugadores.get(i).getFigura().equals(figuras.get(j))){
                            contadorFiguras=j+1;
                        }
                    }
                    
                    int contadorCasilla=jugadores.get(i).getIdCasilla();
                    System.out.println("El jugador se mueve a la casilla: "+jugadores.get(i).getIdCasilla());
                    out.println("<script>"                            
                             +"var casilla=document.getElementById('casillafigura"+contadorCasilla+"');"
                              
                              +"casilla.style.backgroundRepeat='no-repeat';"
                              +"casilla.style.backgroundImage = 'url(./img/figura"+contadorFiguras+".png)';"  
                              +"casilla.style.backgroundSize = '30px';"
                                      
                              +"if("+jugadores.get(i).getIdCasilla()+">=21 && "+jugadores.get(i).getIdCasilla()+"<=30){"
                                +"casilla.style.backgroundRepeat='no-repeat';"
                              +"casilla.style.backgroundImage = 'url(./img/figura"+contadorFiguras+".png)';"  
                              +"casilla.style.backgroundSize = '30px';"     
                              + "}"
                              +"if("+jugadores.get(i).getIdCasilla()+">=11 && "+jugadores.get(i).getIdCasilla()+"<=20){"
                               +"casilla.style.backgroundRepeat='no-repeat';"
                              +"casilla.style.backgroundImage = 'url(./img/figura"+contadorFiguras+".png)';"  
                              +"casilla.style.backgroundSize = '30px';"      
                              + "}"
                              +"if("+jugadores.get(i).getIdCasilla()+">=31 && "+jugadores.get(i).getIdCasilla()+"<=39){" 
                                +"casilla.style.backgroundRepeat='no-repeat';"
                              +"casilla.style.backgroundImage = 'url(./img/figura"+contadorFiguras+".png)';"  
                              +"casilla.style.backgroundSize = '30px';"
                              + "}"                                         
                              + "</script>");
                }
                
           
            %>
            <footer id="piePagina2">
                <p>(c) 2017 Invest In Andorra Services</p>
            </footer>
        </div>
    </body>
</html>
