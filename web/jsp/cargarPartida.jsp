<%-- 
    Document   : cargarPartida
    Created on : 21-jun-2017, 21:05:48
    Author     : Rodrigo
--%>

<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="monopoly.modelo.entidades.Jugador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/index.css" type="text/css" media="all" />
        <link rel="stylesheet" href="./css/cargarPartida.css" type="text/css" media="all" />
        <title>Monopoly</title>
    </head>
    
    <body>
        <header id="cabecera">
            <img src="./img/monopoly-logo.jpg">
        </header>
        <h2>¿Qué partida quieres cargar?</h2>
        <section id='seleccionPartidas'>
            <div id="botonesCargaPartida">
        <%                         
            File dir = new File("./xml");
            String[] ficheros = dir.list();
            ArrayList partidas = new ArrayList();
            int numDirectorio=0;
            if (ficheros == null)
                System.out.println("No hay ficheros en el directorio especificado");
            else { 
                for (int x=0;x<ficheros.length;x++){
                    File subdir= new File(dir.getAbsolutePath()+"/"+ficheros[x]);
                    if(subdir.isDirectory()){
                        partidas.add(ficheros[x]);
                    }                    
                }
                out.print("<script>"               
                + "var divPrincipal = document.getElementById('botonesCargaPartida');"
                + "var formCargaPartida = document.createElement('form');"
                + "formCargaPartida.action='cargarPartidaServlet';"
                + "formCargaPartida.method='POST';"
                + "formCargaPartida.id='formCargaPartida';"
                + "divPrincipal.appendChild(formCargaPartida);"
                
                       
                + "</script>");
                
                
                while(numDirectorio<partidas.size()){                    
                    out.print("<script>"
                    + "        var formCargaPartida = document.getElementById('formCargaPartida');"
                    + "        var div = document.createElement('div');"
                    + "        div.class='seleccionarPartidas';"
                    + "        div.id='divSeleccionarPartidas';"
                    + "        formCargaPartida.appendChild(div);" 

                    + "        var boton = document.createElement('input');"
                    + "        boton.id='partida'+"+numDirectorio+";"
                    + "        boton.type = 'submit';"
                    + "        boton.value='"+partidas.get(numDirectorio)+"';"
                    + "        boton.name='partidaName';"
                    + "        boton.style='margin-left:6%;';"
                    + "        div.appendChild(boton);"                       
                    + "</script>");
                    numDirectorio++;
                }
            }              
        %>
            </div>
        </section>
    </body>
</html>
