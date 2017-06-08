/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Pinta a los jugadores de 8 distintos colores.
 */
function colorFondo() {
    
    for(var i = 0; i<document.getElementsByClassName("puntuaciones").length; i++){
    var puntuaciones=document.getElementsByClassName("puntuaciones")[i];
    var arrayColores = ["ORANGERED", "KHAKI", "DARKSLATEBLUE", "YELLOWGREEN", "LIGHTSKYBLUE", "RED", "VIOLET", "SILVER"];
        
    
        puntuaciones.style.background=arrayColores[i];
    }
}

/*
 * Crea los componentes para la pantalla del botón Terminar Turno 
 */
function lanzarDados(){
       
    var body=document.body;
    var cajaLanzarDados = document.createElement("form");
    cajaLanzarDados.id="cajaLanzarDados";    
    cajaLanzarDados.action="lanzarDadosServlet";
    cajaLanzarDados.method="POST";
    body.appendChild(cajaLanzarDados);
    
    var strong = document.createElement("strong");    
    cajaLanzarDados.appendChild(strong);
    
    var labelMensaje = document.createElement("label");
    labelMensaje.innerHTML="Pulsa sobre Aceptar para continuar."; 
    labelMensaje.id="labelLanzarDados";
    strong.appendChild(labelMensaje);
    
    var imgDados = document.createElement("img");
    imgDados.id="dados1";
    imgDados.src="./img/Dice1.gif";
    cajaLanzarDados.appendChild(imgDados);
    
    var imgDados2 = document.createElement("img");
    imgDados2.id="dados2";
    imgDados2.src="./img/Dice1.gif";
    cajaLanzarDados.appendChild(imgDados2);
    
    var inputAceptar = document.createElement("input");
    inputAceptar.type="submit";
    inputAceptar.id="inputLanzarDados";
    inputAceptar.name="lanzarDados";
    inputAceptar.value="Aceptar";
    cajaLanzarDados.appendChild(inputAceptar);
    
    var inputCancelar = document.createElement("input");
    inputCancelar.type="button";
    inputCancelar.id="inputCancelarLanzarDados";    
    inputCancelar.value="Cancelar";
    cajaLanzarDados.appendChild(inputCancelar);
    
}

/*
 * Crea los componentes para la pantalla del botón Terminar Turno 
 */
function negociar(){
    
    var body=document.body;
    var cajaTerminarTurno = document.createElement("form");
    cajaTerminarTurno.id="cajaTerminarTurno";    
    cajaTerminarTurno.action="terminarTurnoServlet";
    cajaTerminarTurno.method="POST";
    body.appendChild(cajaTerminarTurno);
    
    var strong = document.createElement("strong");    
    cajaTerminarTurno.appendChild(strong);
    
    var labelMensaje = document.createElement("label");
    labelMensaje.innerHTML="¿Seguro que quieres terminar tu turno?"; 
    labelMensaje.id="labelTerminarTurno";
    strong.appendChild(labelMensaje);
    
    var inputAceptar = document.createElement("input");
    inputAceptar.type="submit";
    inputAceptar.id="inputAceptarTerminarTurno";
    inputAceptar.name="terminarTurno";
    inputAceptar.value="Aceptar";
    cajaTerminarTurno.appendChild(inputAceptar);
    
    var inputCancelar = document.createElement("input");
    inputCancelar.type="button";
    inputCancelar.id="inputCancelarTerminarTurno";    
    inputCancelar.value="Cancelar";
    cajaTerminarTurno.appendChild(inputCancelar);
    
}

/*
 * Crea los componentes para la pantalla del botón Terminar Turno 
 */
function terminarTurno(){
     
    var body=document.body;
    var cajaTerminarTurno = document.createElement("form");
    cajaTerminarTurno.id="cajaTerminarTurno";    
    cajaTerminarTurno.action="terminarTurnoServlet";
    cajaTerminarTurno.method="POST";
    body.appendChild(cajaTerminarTurno);
    
    var strong = document.createElement("strong");    
    cajaTerminarTurno.appendChild(strong);
    
    var labelMensaje = document.createElement("label");
    labelMensaje.innerHTML="¿Seguro que quieres terminar tu turno?"; 
    labelMensaje.id="labelTerminarTurno";
    strong.appendChild(labelMensaje);
    
    var inputAceptar = document.createElement("input");
    inputAceptar.type="submit";
    inputAceptar.id="inputAceptarTerminarTurno";
    inputAceptar.name="terminarTurno";
    inputAceptar.value="Aceptar";
    cajaTerminarTurno.appendChild(inputAceptar);
    
    var inputCancelar = document.createElement("input");
    inputCancelar.type="button";
    inputCancelar.id="inputCancelarTerminarTurno";    
    inputCancelar.value="Cancelar";
    cajaTerminarTurno.appendChild(inputCancelar);
    
}

/*
 * Crea los componentes para la pantalla del botón Guardar Partida 
 */
function guardarPartida(){
    var date = new Date();
    var dia = date.getDate();
    var mes=date.getMonth();
    var anho=date.getFullYear();
    var hoy = dia+"/"+mes+"/"+anho;
    
    var body=document.body;
    var cajaMensaje = document.createElement("form");
    cajaMensaje.id="cajaMensaje";    
    cajaMensaje.action="guardarPartidaServlet";
    cajaMensaje.method="POST";
    body.appendChild(cajaMensaje);
    
    var strong = document.createElement("strong");    
    cajaMensaje.appendChild(strong);
    
    var labelMensaje = document.createElement("label");
    labelMensaje.innerHTML="Escribe el nombre con el que deseas guardar la partida."; 
    labelMensaje.id="labelMensaje";
    strong.appendChild(labelMensaje);
    
    var inputNombre = document.createElement("input");
    inputNombre.type="text";
    inputNombre.id="inputNombreMensaje";    
    inputNombre.value=hoy;      
    cajaMensaje.appendChild(inputNombre);
    
    var inputAceptar = document.createElement("input");
    inputAceptar.type="submit";
    inputAceptar.id="inputAceptarMensaje";
    inputAceptar.name="guardarPartida";
    inputAceptar.value="Aceptar";
    cajaMensaje.appendChild(inputAceptar);
    
    var inputCancelar = document.createElement("input");
    inputCancelar.type="button";
    inputCancelar.id="inputCancelarMensaje";    
    inputCancelar.value="Cancelar";
    cajaMensaje.appendChild(inputCancelar);
    
}

/*
 * Crea los componentes para la pantalla de las tarjetas sorpresa y suerte 
 */
function tarjetaCCSuerte(){
    var body=document.body;
    var cajaTarjeta = document.createElement("form");
    cajaTarjeta.id="cajaTarjeta";        
    body.appendChild(cajaTarjeta);
    
    var strong = document.createElement("strong");    
    cajaTarjeta.appendChild(strong);
    
    var labelMensaje = document.createElement("label");
    labelMensaje.innerHTML="Descripción de la tarjeta: "; 
    labelMensaje.id="labelTarjeta";
    strong.appendChild(labelMensaje);
    
    var divTarjeta=document.createElement("div");    
    divTarjeta.id="divTarjeta";
    cajaTarjeta.appendChild(divTarjeta);
    
    var textoTarjeta=document.createElement("label");    
    divTarjeta.id="textoTarjeta";
    divTarjeta.appendChild(textoTarjeta);
    
    var inputAceptar = document.createElement("input");
    inputAceptar.type="button";
    inputAceptar.id="inputAceptarTarjeta";
    inputAceptar.name="terminarTarjeta";
    inputAceptar.value="Aceptar";
    cajaTarjeta.appendChild(inputAceptar);   
}

/*Crea los componentes para la pantalla que muestra el mensaje de que el jugador ha perdido.*/
function jugadorHaPerdido(){
    var body=document.body;
    var cajaMensajePerder = document.createElement("form");
    cajaMensajePerder.id="cajaMensajePerder";         
    body.appendChild(cajaMensajePerder);
    
    var strong = document.createElement("strong");    
    cajaMensajePerder.appendChild(strong);
    
    var labelMensaje = document.createElement("label");    
    labelMensaje.id="labelMensajeHaPerdido";
    strong.appendChild(labelMensaje);           
    
    var inputNo = document.createElement("input");
    inputNo.type="button";
    inputNo.id="inputAceptarPerder";
    inputNo.name="aceptarPerder";
    inputNo.value="Aceptar";
    cajaMensajePerder.appendChild(inputNo);   
}

/*Crea los componentes para la pantalla de compra.*/
function comprarPropiedad(){
    var body=document.body;
    var cajaCompraPropiedad = document.createElement("form");
    cajaCompraPropiedad.id="cajaCompraPropiedad";     
    cajaCompraPropiedad.action="comprarPropiedadServlet";
    cajaCompraPropiedad.method="POST";
    body.appendChild(cajaCompraPropiedad);
    
    var strong = document.createElement("strong");    
    cajaCompraPropiedad.appendChild(strong);
    
    var labelMensaje = document.createElement("label");
    labelMensaje.innerHTML="La propiedad no tiene dueño. ¿Desea comprar la propiedad?"; 
    labelMensaje.id="labelTarjeta";
    strong.appendChild(labelMensaje);
       
    var inputSi = document.createElement("input");
    inputSi.type="submit";
    inputSi.id="inputSiCompra";
    inputSi.name="finalizarCompra";
    inputSi.value="Aceptar";
    cajaCompraPropiedad.appendChild(inputSi);   
    
    var inputNo = document.createElement("input");
    inputNo.type="button";
    inputNo.id="inputNoCompra";
    inputNo.name="cancelarCompra";
    inputNo.value="Cancelar";
    cajaCompraPropiedad.appendChild(inputNo);   
}

function actionBtnLanzarDados(){
    document.getElementById("btnLanzarDados").onclick = function(){
        
        document.getElementById("cajaLanzarDados").style.position= "absolute";    
        document.getElementById("cajaLanzarDados").style.overflow= "auto";
        document.getElementById("cajaLanzarDados").style.visibility="visible";
        document.getElementById("cajaLanzarDados").style.zIndex="1001";
        document.body.style.backgroundColor="black";
        document.getElementById("todoMonopoly").style.zIndex="1002";
        document.getElementById("todoMonopoly").style.opacity="0.60";
        
        document.getElementById("btnLanzarDados").disabled=true;
        document.getElementById("btnNegociar").disabled=true;
        document.getElementById("btnTerminar").disabled=true;
        document.getElementById("btnGuardarPartida").disabled=true;
   
        document.getElementById("btnLanzarDados").style.cursor = 'default';
        document.getElementById("btnNegociar").style.cursor = 'default';
        document.getElementById("btnTerminar").style.cursor = 'default';
        document.getElementById("btnGuardarPartida").style.cursor = 'default';
    };
    
    document.getElementById("inputCancelarLanzarDados").onclick = function(){
        
        document.getElementById("todoMonopoly").style.zIndex="1001";
        document.getElementById("todoMonopoly").style.opacity="initial";
        
        document.getElementById("cajaLanzarDados").style.visibility="hidden";  
        document.getElementById("cajaLanzarDados").style.zIndex="1002"; 
        
        document.getElementById("btnLanzarDados").disabled=false;
        document.getElementById("btnNegociar").disabled=true;
        document.getElementById("btnTerminar").disabled=true;
        document.getElementById("btnGuardarPartida").disabled=false;
        
        document.getElementById("btnLanzarDados").style.cursor = 'pointer';
        document.getElementById("btnNegociar").style.cursor = 'pointer';
        document.getElementById("btnTerminar").style.cursor = 'pointer';
        document.getElementById("btnGuardarPartida").style.cursor = 'pointer';
        
    };
}

function actionBtnTerminar(){
    document.getElementById("btnTerminar").onclick = function(){
        
        document.getElementById("cajaTerminarTurno").style.position= "absolute";    
        document.getElementById("cajaTerminarTurno").style.overflow= "auto";
        document.getElementById("cajaTerminarTurno").style.visibility="visible";
        document.getElementById("cajaTerminarTurno").style.zIndex="1001";
        document.body.style.backgroundColor="black";
        document.getElementById("todoMonopoly").style.zIndex="1002";
        document.getElementById("todoMonopoly").style.opacity="0.60";
        
        document.getElementById("btnLanzarDados").disabled=true;
        document.getElementById("btnNegociar").disabled=true;
        document.getElementById("btnTerminar").disabled=true;
        document.getElementById("btnGuardarPartida").disabled=true;
   
        document.getElementById("btnLanzarDados").style.cursor = 'default';
        document.getElementById("btnNegociar").style.cursor = 'default';
        document.getElementById("btnTerminar").style.cursor = 'default';
        document.getElementById("btnGuardarPartida").style.cursor = 'default';
    };
    
    document.getElementById("inputCancelarTerminarTurno").onclick = function(){
        
        document.getElementById("todoMonopoly").style.zIndex="1001";
        document.getElementById("todoMonopoly").style.opacity="initial";
        
        document.getElementById("cajaTerminarTurno").style.visibility="hidden";  
        document.getElementById("cajaTerminarTurno").style.zIndex="1002"; 
        
        document.getElementById("btnLanzarDados").disabled=true;
        document.getElementById("btnNegociar").disabled=false;
        document.getElementById("btnTerminar").disabled=false;
        document.getElementById("btnGuardarPartida").disabled=false;
        
        document.getElementById("btnLanzarDados").style.cursor = 'pointer';
        document.getElementById("btnNegociar").style.cursor = 'pointer';
        document.getElementById("btnTerminar").style.cursor = 'pointer';
        document.getElementById("btnGuardarPartida").style.cursor = 'pointer';
        
    };
    
}

function actionBtnGuardarPartida(){
        document.getElementById("btnGuardarPartida").onclick = function(){
        
        document.getElementById("cajaMensaje").style.position= "absolute";    
        document.getElementById("cajaMensaje").style.overflow= "auto";
        document.getElementById("cajaMensaje").style.visibility="visible";
        document.getElementById("cajaMensaje").style.zIndex="1001";
        document.body.style.backgroundColor="black";
        document.getElementById("todoMonopoly").style.zIndex="1002";
        document.getElementById("todoMonopoly").style.opacity="0.60";
           
        document.getElementById("btnLanzarDados").style.cursor = 'default';
        document.getElementById("btnNegociar").style.cursor = 'default';
        document.getElementById("btnTerminar").style.cursor = 'default';
        document.getElementById("btnGuardarPartida").style.cursor = 'default';
    };
}

function cancelarMensaje(){
    document.getElementById("inputCancelarMensaje").onclick = function(){
        
        document.body.style.backgroundColor="#9ED68D";
        
        document.getElementById("todoMonopoly").style.zIndex="1001";
        document.getElementById("todoMonopoly").style.opacity="initial";
        
        document.getElementById("cajaMensaje").style.visibility="hidden";  
        document.getElementById("cajaMensaje").style.zIndex="1002"; 
        document.getElementById("btnLanzarDados").style.cursor = 'pointer';
        document.getElementById("btnNegociar").style.cursor = 'pointer';
        document.getElementById("btnTerminar").style.cursor = 'pointer';
        document.getElementById("btnGuardarPartida").style.cursor = 'pointer';
        
    };
}



window.onload = function() {
    colorFondo();    
    lanzarDados();
    terminarTurno();
    guardarPartida();   
    actionBtnLanzarDados();
    actionBtnTerminar();
    actionBtnGuardarPartida();
    cancelarMensaje();   
};