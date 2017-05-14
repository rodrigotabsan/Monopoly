<%-- 
    Document   : partida
    Created on : 14-abr-2017, 2:22:45
    Author     : Rodrigo
--%>

<%@page import="monopoly.controlador.Dado"%>
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
                    List<Jugador> jugadores = (List<Jugador>) request.getSession().getAttribute("listaJugadoresPartida");                    
                    if(request.getSession().getAttribute("jugadores")!=null){
                        jugadores=(List <Jugador>)request.getSession().getAttribute("jugadores");                        
                    }
                    if(request.getSession().getAttribute("todosjugadores")!=null){
                        jugadores=(List <Jugador>)request.getSession().getAttribute("todosjugadores");                        
                    }                 
                    int contadorJugadores=0;
                    for (int a = 0; a < jugadores.size(); a++) {
                        out.print("<div class='puntuaciones'><label id='jugador'>"
                                + "<strong>" + jugadores.get(a).getNombre() + ":</strong>"
                                + "</label> <label><strong>" + jugadores.get(a).getDinero() + " €" + "</strong>"
                                + "</label>"
                                + "</div><br>");
								
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
            <section id="tapete">
                <div id="tablero">
                    <div id="vi">
                        <%
                            List<Propiedad> propiedades = (ArrayList<Propiedad>) 
                                    request.getSession().getAttribute("listaPropiedades");
                            List<Especial> especiales = (ArrayList<Especial>) 
                                    request.getSession().getAttribute("listaEspeciales");
                            List<Casilla> casillas = (ArrayList<Casilla>) 
                                    request.getSession().getAttribute("listaCasillas");
                            List<TSorpresaSuerte> tarjetasCCySuerte = (ArrayList<TSorpresaSuerte>) 
                                    request.getSession().getAttribute("listaTarjetaCCySuerte");
                            Tablero tablero = (Tablero)
                                    request.getSession().getAttribute("tablero");
                            Partida partida = (Partida)
                                    request.getSession().getAttribute("partida");

                            for (int z = 19; z >= 11; z--) {
                                for (int x = 0; x < especiales.size(); x++) {
                                    if (casillas.get(z).getId() == especiales.get(x).getIdCasilla()) {
                                        out.print("<div class='verticalIzquierda'>"
                                                + casillas.get(z).getNombre() + "</div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(z).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div class='verticalIzquierda'>"
                                                + "<div style='width:100px;height:136px;margin-top:5%;'>"
                                                + "<label style='margin-top:5px;'>" + casillas.get(z).getNombre() + "</label>"
                                                + "</div>"
                                                + "<div "
                                                + "style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:136px; width:30px; margin-left:106px; "
                                                + "margin-top:-142.5px;font-family: Arial;'>"
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
                                        out.print("<div class='horizontalArriba'>" + casillas.get(j).getNombre() + "</div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(j).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div class='horizontalArriba'>"
                                                + "<div style='width:136px;height:40px;font-family: Arial;'>"
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
                                        out.print("<div class='horizontalAbajo'>" + casillas.get(i).getNombre()
                                                + "</div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(i).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div class='horizontalAbajo'>"
                                                + "<div style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:30px; width:136px;'></div>"
                                                + "<div style='width:136px;height:40px;font-family: Arial;'>"
                                                + "<label style='margin-top:5%;'><label style='margin-top:5px;'>"
                                                + casillas.get(i).getNombre() + "</label>"
                                                + "</div>"
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
                                        out.print("<div class='verticalDerecha'>" + casillas.get(k).getNombre()
                                                + "</div>");
                                    }
                                }
                                for (int y = 0; y < propiedades.size(); y++) {
                                    if (casillas.get(k).getId() == propiedades.get(y).getIdCasilla()) {
                                        out.print("<div class='verticalDerecha'>"
                                                + "<div style='background-color:" + propiedades.get(y).getColor() + "; "
                                                + "height:136px; width:30px;'></div>"
                                                + "<div style='width:90px;height:136px; margin-left:31px; "
                                                + "margin-top:-136px;font-family: Arial;'>"
                                                + "<label style='margin-top:5px;'>" + casillas.get(k).getNombre() + "</label>"
                                                + "</div>"
                                                + "</div>");
                                    }
                                }
                            }
                        %>         
                    </div>
                </div>           
            </section>
            <section>
                <div id="controles">
                     <% out.print("<h2 id='jugador'>Turno de "+turnoDeJugador.getNombre()+" </h2>"); %>
                        <input type="button" value="Lanzar dados" id="btnLanzarDados"/><br>
                        <input type="button" value="Negociar" id="btnNegociar"/><br>
                        <input type="button" value="Terminar Turno" id="btnTerminar"/><br>
                        <input type="button" value="Guardar Partida" id="btnGuardarPartida"/>
                </div>

            </section>
            <%  
                int result1=0;
                int result2=0;
                
		if(turnoDeJugador.getEstadoTurno()==1){
                    Random random = new Random();            
                    int minimo = 1;
                    int maximo = 7;
                    result1 = random.nextInt(maximo-minimo) + minimo;
                    result2 = random.nextInt(maximo-minimo) + minimo; 
                    System.out.println("Jugador "+turnoDeJugador.getNombre()+" obtiene un resultado de "+result1+" / "+result2);
                    Dado dado1= new Dado();
                    dado1=dado1.resultadoDado(result1);
                    Dado dado2=new Dado();
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
                        }
                        posicionJugador++;					
                    }		
                    request.getSession().setAttribute("posicionJugador",posicionJugador);
                    request.getSession().setAttribute("turnoDeJugador", turnoDeJugador);
                    request.getSession().setAttribute("todosJugadores", jugadores);
                    
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
                
                
                 out.println("<script>"
                            
                            + "</script>");
                
                request.getSession().setAttribute("listaPropiedades", propiedades);
                request.getSession().setAttribute("listaEspeciales", especiales);
                request.getSession().setAttribute("listaCasillas", casillas);
                request.getSession().setAttribute("listaJugadoresTotales", jugadores);
                request.getSession().setAttribute("listaTarjetaCCySuerte", tarjetasCCySuerte);
                request.getSession().setAttribute("tablero", tablero);
                request.getSession().setAttribute("partida", partida);
            %>
            <footer id="piePagina2">
                <p>(c) 2017 Invest In Andorra Services</p>
            </footer>
        </div>
    </body>
</html>
