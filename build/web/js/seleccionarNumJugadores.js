/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var numJugadores=2;
function crearBotonesSeleccionJugadores(){    
    var botonesJugadores = document.getElementById("botonesJugadores");
        while(numJugadores<=8){                        
            var div = document.createElement("div");
            div.class="seleccionarJugador";                                               
            botonesJugadores.appendChild(div);                        
            var boton = document.createElement("input");
            boton.id="jugador"+numJugadores;
            boton.type = "button";
            boton.name="numerojugadores";
            boton.value = numJugadores+" jugadores";
            div.appendChild(boton);
            numJugadores++;
        }
        document.getElementById("rellenarDatosJugadores").style.visibility="hidden";
        document.getElementById("piePagina").style.marginTop="30%";
    }
    
function crearElementosFormulario(numeroJugadores){
    
    var divFormularioJugadores=document.getElementById("formularioJugadores");
    var divPrincipal = document.createElement("form");
    divPrincipal.action='seleccionarJugadorServlet';
    divPrincipal.method="POST";
    divFormularioJugadores.appendChild(divPrincipal);
    var contadorJugadores=1;
    do{
            var labelJugador = document.createElement("label");
            labelJugador.class="jugador";  
            labelJugador.innerHTML="Jugador "+contadorJugadores;     
            labelJugador.style.fontWeight="bold";                 
            divPrincipal.appendChild(labelJugador); 
            
            var divNombre = document.createElement("div");
            divNombre.class="nombre";
            divNombre.style.marginBottom="2%";
            divNombre.style.marginTop="2%";
            divPrincipal.appendChild(divNombre);
            
            var labelNombre = document.createElement("label");              
            labelNombre.innerHTML="Nombre: ";    
            divNombre.appendChild(labelNombre);
            
            var inputNombre = document.createElement("input");
            inputNombre.type="text";
            inputNombre.name="nombre"+contadorJugadores;
            inputNombre.class="inputNombre";
            inputNombre.maxlength="8";
            divNombre.appendChild(inputNombre);
            
            var divFigura = document.createElement("div");
            divFigura.class="figura";
            divPrincipal.appendChild(divFigura);
            
            var labelFigura = document.createElement("label");            
            labelFigura.innerHTML="Figura: ";            
            divFigura.appendChild(labelFigura);
            
            var divBackGroundDiv = document.createElement("div");
            divBackGroundDiv.class="backgrounddiv";
            divBackGroundDiv.style.marginBottom="4%";
            divFigura.appendChild(divBackGroundDiv);
                        
            for(var x=1;x<=8;x++){ 
                var img = document.createElement("img");                
                img.src = "./img/figura"+x+".png";
                img.style.width="7%";
                img.style.height="7%";
                divBackGroundDiv.appendChild(img);
                
                var radio = document.createElement("input");
                radio.name="ficha"+contadorJugadores;
                radio.type = "radio";
                radio.id="fichas"+x;
                radio.style.marginRight="3%";                                  
                if(x===1){
                    radio.value="barco";
                }
                if(x===2){
                    radio.value="sombrero";
                }
                if(x===3){
                    radio.value="dedal";
                }
                if(x===4){
                    radio.value="zapato";
                }
                if(x===5){
                    radio.value="perro";
                }
                if(x===6){
                    radio.value="coche";
                }
                if(x===7){
                    radio.value="plancha";
                }
                if(x===8){
                    radio.value="carretilla";
                }
                divBackGroundDiv.appendChild(radio);
            }             
        contadorJugadores++;
    }while(contadorJugadores<=numeroJugadores);
    
    var divAceptar = document.createElement("div");
    divAceptar.id="aceptar";
    divPrincipal.appendChild(divAceptar);
     
    var inputHidden = document.createElement("input");
    inputHidden.type="hidden";
    inputHidden.value=numeroJugadores;
    inputHidden.name="op";
    inputHidden.id="inputOculto";
    divAceptar.appendChild(inputHidden);
    
    var inputHidden2 = document.createElement("input");
    inputHidden2.type="hidden";
    inputHidden2.value="jugadoresHumanos";
    inputHidden2.name="jugadoresHumanos";
    divAceptar.appendChild(inputHidden2);
    
    var inputAceptar = document.createElement("input");
    inputAceptar.type="submit";
    inputAceptar.id="inputAceptar";
    inputAceptar.name="aceptarJugadores";
    inputAceptar.value="Aceptar";
    divAceptar.appendChild(inputAceptar);
    
}

window.onload = function() {
    crearBotonesSeleccionJugadores();
    
    document.getElementById("jugador2").onclick = function(){
        crearElementosFormulario(2);
        document.getElementById("seleccionJugadores").style.visibility="hidden";
        document.getElementById("rellenarDatosJugadores").style.visibility="initial";
        document.getElementById("piePagina").style.marginTop="1%";     
    };
    document.getElementById("jugador3").onclick = function(){crearElementosFormulario(3);document.getElementById("seleccionJugadores").style.visibility="hidden";document.getElementById("rellenarDatosJugadores").style.visibility="initial";document.getElementById("piePagina").style.marginTop="1%";unCheckBoxAlaVez("ficha2");checkFiguras();};
    document.getElementById("jugador4").onclick = function(){crearElementosFormulario(4);document.getElementById("seleccionJugadores").style.visibility="hidden";document.getElementById("rellenarDatosJugadores").style.visibility="initial";document.getElementById("piePagina").style.marginTop="1%";unCheckBoxAlaVez("ficha3");checkFiguras();};
    document.getElementById("jugador5").onclick = function(){crearElementosFormulario(5);document.getElementById("seleccionJugadores").style.visibility="hidden";document.getElementById("rellenarDatosJugadores").style.visibility="initial";document.getElementById("piePagina").style.marginTop="1%";unCheckBoxAlaVez("ficha4");checkFiguras();};
    document.getElementById("jugador6").onclick = function(){crearElementosFormulario(6);document.getElementById("seleccionJugadores").style.visibility="hidden";document.getElementById("rellenarDatosJugadores").style.visibility="initial";document.getElementById("piePagina").style.marginTop="1%";unCheckBoxAlaVez("ficha5");checkFiguras();};
    document.getElementById("jugador7").onclick = function(){crearElementosFormulario(7);document.getElementById("seleccionJugadores").style.visibility="hidden";document.getElementById("rellenarDatosJugadores").style.visibility="initial";document.getElementById("piePagina").style.marginTop="1%";unCheckBoxAlaVez("ficha6");checkFiguras();};
    document.getElementById("jugador8").onclick = function(){crearElementosFormulario(8);document.getElementById("seleccionJugadores").style.visibility="hidden";document.getElementById("rellenarDatosJugadores").style.visibility="initial";document.getElementById("piePagina").style.marginTop="1%";unCheckBoxAlaVez("ficha7");checkFiguras();};
   
};