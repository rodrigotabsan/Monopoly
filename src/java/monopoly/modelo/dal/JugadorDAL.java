/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.IJugadorDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Accede a los datos del XML correspondiente a usuario.xml
 * @author Rodrigo
 */
public class JugadorDAL implements IJugadorDAL{

    /**
     *
     */
    public JugadorDAL() {
    }
    
    /**
     * Obtiene el valor del nodo. Básicamente coge del tag o pestaña que se le pase,
     * en el parámetro strTag, el valor que le corresponde en el fichero XML.
     * @param strTag el tag correspondiente del XML
     * @param eUsuario El usuario que se quiere obtener 
     * @return 
     */ 
    private static String obtenerNodoValor(String strTag, Element eUsuario){
         Node nValor=(Node)eUsuario.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Elimina un jugador pasándole el objeto Jugador.
     * @param usuario El usuario que se quiere eliminar
     * @see Jugador
     */
    @Override
    public void eliminarUsuario(Jugador usuario){        
        UtilesXML util = new UtilesXML(new File("xml/usuarios.xml"));
         
         Document doc =util.accesoAlDocument();
         NodeList nodosUsuarios = util.accesoAXML("usuario", doc);         
         for(int i = 0; i < nodosUsuarios.getLength(); i++){
             Element element= (Element) nodosUsuarios.item(i);
             if(element.getAttribute("id").equalsIgnoreCase(String.valueOf(usuario.getId()))){
                  element.getParentNode().removeChild(element);
             }
         }
         util.modificarOEliminarElementoXML(new File ("xml/usuarios.xml"), doc);
                
    } 
    
    /**
     * Crea un Jugador pasándole el objeto Jugador
     * @param usuario El usuario que se quiere crear
     * @see Jugador
     */
    @Override
    public void crearUsuario(Jugador usuario) {
        UtilesXML util = new UtilesXML(new File("xml/usuarios.xml"));
        int id=1;   
        List<Jugador> listadoTableros=obtenerTodosUsuarios();
        if(!listadoTableros.isEmpty()){ 
             Document doc =util.accesoAlDocument();

             Node nodoRaiz = util.accesoANodoXML();         
             Element nuevoUsuario = doc.createElement("usuario");
             Element nuevoId = doc.createElement("id");  
             if(listadoTableros.size()>0){
                 id=listadoTableros.size()+1;
             }
             usuario.setId(id);
             nuevoId.setTextContent(String.valueOf(usuario.getId()));

             Element nuevoIdCasilla = doc.createElement("idcasilla"); 
             nuevoIdCasilla.setTextContent(String.valueOf(usuario.getIdCasilla()));

             Element nuevoDinero = doc.createElement("dinero");
             nuevoDinero.setTextContent(String.valueOf(usuario.getDinero()));

             Element nuevaFigura = doc.createElement("figura");
             nuevaFigura.setTextContent(usuario.getFigura());

             Element nuevoNombre = doc.createElement("nombre");
             nuevoNombre.setTextContent(usuario.getNombre());

             Element nuevaIdPartida = doc.createElement("idpartida");
             nuevaIdPartida.setTextContent(String.valueOf(usuario.getIdPartida()));

             Element nuevoTurno = doc.createElement("turno");
             nuevoTurno.setTextContent(String.valueOf(usuario.getTurno()));

             Element nuevoEstadoTurno = doc.createElement("estadoturno");
             nuevoEstadoTurno.setTextContent(String.valueOf(usuario.getEstadoTurno()));
             
             Element nuevoTurnoCarcel = doc.createElement("turnoCarcel");
             nuevoTurnoCarcel.setTextContent(String.valueOf(usuario.getTurnoCarcel()));
             
             Element nuevoCogeTarjeta = doc.createElement("cogetarjeta");
             nuevoCogeTarjeta.setTextContent(String.valueOf(usuario.getCogeTarjeta()));
             
             Element estadoParaComprar = doc.createElement("estadoparacomprar");
             nuevoCogeTarjeta.setTextContent(String.valueOf(usuario.getCogeTarjeta()));
             
                     
             nuevoUsuario.appendChild(nuevoId);
             nuevoUsuario.appendChild(nuevoIdCasilla);
             nuevoUsuario.appendChild(nuevoDinero);
             nuevoUsuario.appendChild(nuevaFigura);
             nuevoUsuario.appendChild(nuevoNombre);
             nuevoUsuario.appendChild(nuevaIdPartida);
             nuevoUsuario.appendChild(nuevoTurno);
             nuevoUsuario.appendChild(nuevoEstadoTurno);
             nuevoUsuario.appendChild(nuevoTurnoCarcel);
             nuevoUsuario.appendChild(nuevoCogeTarjeta);
             nuevoUsuario.appendChild(estadoParaComprar);
             nodoRaiz.appendChild(nuevoUsuario);     

             util.modificarOEliminarElementoXML(new File ("xml/usuarios.xml"), doc);    
        }         
    }
    
    /**
     * Obtiene un listado de todos los Jugadores
     * @return El listado de jugadores
     * @see Jugador
     */   
    @Override
    public List<Jugador> obtenerTodosUsuarios(){
        List<Jugador> listaUsuarios= new ArrayList<Jugador>();
        UtilesXML util=new UtilesXML(new File("xml/usuarios.xml"));
           
         NodeList nodosUsuarios = util.accesoAXML("usuario");
         
         for(int i = 0; i < nodosUsuarios.getLength(); i++){
             Node usuario = nodosUsuarios.item(i);
             if(usuario.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) usuario;
                 Jugador objUsuario = new Jugador();
                 objUsuario.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objUsuario.setNombre(obtenerNodoValor("nombre", unElemento));                 
                 objUsuario.setFigura(obtenerNodoValor("figura", unElemento)); 
                 objUsuario.setDinero(Integer.parseInt(obtenerNodoValor("dinero",unElemento)));
                 objUsuario.setIdCasilla(Integer.parseInt(obtenerNodoValor("idcasilla", unElemento)));
                 objUsuario.setIdCasilla(Integer.parseInt(obtenerNodoValor("idpartida", unElemento)));
                 objUsuario.setTurno(Integer.parseInt(obtenerNodoValor("turno", unElemento)));
                 objUsuario.setTurno(Integer.parseInt(obtenerNodoValor("estadoturno", unElemento)));                 
                 objUsuario.setTurno(Integer.parseInt(obtenerNodoValor("turnoCarcel", unElemento)));
                 objUsuario.setTurno(Integer.parseInt(obtenerNodoValor("cogetarjeta", unElemento)));
                 objUsuario.setTurno(Integer.parseInt(obtenerNodoValor("estadoparacomprar", unElemento)));
                 listaUsuarios.add(objUsuario);
             }
         }    
        return listaUsuarios;
    }
}
