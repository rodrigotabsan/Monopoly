<%-- 
    Document   : seleccionarNumCPU
    Created on : 21-abr-2017, 20:28:27
    Author     : Rodrigo
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="monopoly.modelo.entidades.Jugador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/index.css" type="text/css" media="all" />
        <link rel="stylesheet" href="./css/seleccionarNumJugadores.css" type="text/css" media="all" />
        <script src="./js/seleccionarNumCPU.js"></script>
        <title>Monopoly</title>
    </head>
    <body>
        <% if(request.getSession().getAttribute("numJugadoresError")!=null){            
            out.println("<script>alert('"+request.getSession().getAttribute("numJugadoresError")+"');</script>");
        }
        %>
        <header id="cabecera">
            <img src="./img/monopoly-logo.jpg">
        </header>
        <h2>Selecciona el número de jugadores controlados por la CPU.</h2>
        <section id='seleccionJugadores'>
            <div id="botonesJugadores">
                <input type="hidden" name="playersCPU" value="playersCPU" />
                <% List <Jugador> jugadores=(ArrayList<Jugador>)request.getSession().getAttribute("jugadores");
                int numeroJugadores = 0;
                for(Jugador jugador : jugadores) {
                    numeroJugadores++;
                }
                request.getSession().setAttribute("numeroTotalJugadoresHumanos", numeroJugadores);
                
                System.out.println("EL TOTAL ES DE "+numeroJugadores+" JUGADORES");
                %>
            </div>
        </section>
        <footer id="piePagina">            
            <p>(c) 2017 Invest In Andorra Services</p>
        </footer>
    </body>
</html>
