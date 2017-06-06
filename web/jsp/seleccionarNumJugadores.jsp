<%-- 
    Document   : seleccionarNumJugadores
    Created on : 19-abr-2017, 4:38:34
    Author     : Rodrigo
--%>

<%@page import="monopoly.util.UtilesServlets"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/index.css" type="text/css" media="all" />
        <link rel="stylesheet" href="./css/seleccionarNumJugadores.css" type="text/css" media="all" />
        <script src="./js/seleccionarNumJugadores.js"></script>
        <title>Monopoly</title>
    </head>
    <body>
        
        <% if(request.getSession().getAttribute("figurasError")!=null){            
            out.println("<script>alert('"+request.getSession().getAttribute("figurasError")+"');</script>");
        }
        if(request.getSession().getAttribute("jugadoresNulosError")!=null){            
            out.println("<script>alert('"+request.getSession().getAttribute("jugadoresNulosError")+"');</script>");
        }
        %>
        <header id="cabecera">
            <img src="./img/monopoly-logo.jpg">
        </header>
        <h2>Selecciona el número de jugadores controlados por personas.</h2>
        <section id='seleccionJugadores'>
            <div id="botonesJugadores"></div>
        </section>
        <section id='rellenarDatosJugadores'>
            <div id="formularioJugadores">                                                                 
            </div>            
        </section>
        <footer id="piePagina">            
            <p>(c) 2017 Invest In Andorra Services</p>
        </footer>
    </body>
</html>
