<%-- 
    Document   : index
    Created on : 13-abr-2017, 22:48:13
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/index.css" type="text/css" media="all" />
        <title>Monopoly</title>
    </head>
    <body> 
        <header id="cabecera">
            <img src="./img/monopoly-logo.jpg">
        </header>
        <ul id="navi"> 
            <form method="POST" action="inicioServlet">               
                <li><input id="startPartida" name="comenzarPartida" type="submit" value="Comenzar Partida"/></li>
                <li><input id="loadPartida" name="cargarPartida" type="submit" value="Cargar Partida"/></li>
            </form>
        </ul>
        <footer id="piePagina">            
            <p>(c) 2017 Invest In Andorra Services</p>
        </footer>
    </body>
</html>
