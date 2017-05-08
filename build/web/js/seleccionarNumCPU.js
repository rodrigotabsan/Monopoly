/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var numJugadores=0;
function crearBotonesSeleccionCPU(){    
    var divPrincipal = document.getElementById("botonesJugadores");
    var formBotonesJugadores = document.createElement("form");
    formBotonesJugadores.action='seleccionarJugadorServlet';
    formBotonesJugadores.method="POST";
    divPrincipal.appendChild(formBotonesJugadores);
    
        while(numJugadores<=6){                        
            var div = document.createElement("div");
            div.class="seleccionarJugador";
            div.id="divSeleccionarJugador";
           formBotonesJugadores.appendChild(div); 
           
            var boton = document.createElement("input");
            boton.id="CPU"+numJugadores;
            boton.type = "submit";    
            boton.value = numJugadores+" CPU";
            boton.name="CPUName";
            boton.style="margin-left:6%;";
            div.appendChild(boton);                        
            numJugadores++;
        }
        
    }

window.onload = function() {
  crearBotonesSeleccionCPU();
};