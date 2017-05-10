/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import monopoly.modelo.entidades.Jugador;
import monopoly.modelo.IJugadorDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
     * @param strTag
     * @param eCasilla
     * @return 
     */ 
    private static String obtenerNodoValor(String strTag, Element eUsuario){
         Node nValor=(Node)eUsuario.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Elimina un jugador pasándole el objeto Jugador.
     * @param usuario 
     * @see Jugador
     */
    @Override
    public void eliminarUsuario(Jugador usuario){        
        UtilesXML util = new UtilesXML(new File("xml/usuarios.xml"));
        ArrayList<Jugador> listaUsuarios= new ArrayList<>(); 
        
        try{ 
         Document doc =util.accesoAlDocument();
         NodeList nodosUsuarios = util.accesoAXML("usuario", doc);         
         for(int i = 0; i < nodosUsuarios.getLength(); i++){
             Element element= (Element) nodosUsuarios.item(i);
             if(element.getAttribute("id").equalsIgnoreCase(String.valueOf(usuario.getId()))){
                  element.getParentNode().removeChild(element);
             }
         }
         util.modificarOEliminarElementoXML(new File ("xml/usuarios.xml"), doc);
        }catch(SAXException | IOException | ParserConfigurationException | TransformerException ex){
            System.out.println("monopoly.dal.UsuarioDAL.eliminarUsuario() "+ ex.getMessage());  
        }         
    } 
    
    /**
     * Crea un Jugador pasándole el objeto Jugador
     * @param usuario 
     * @see Jugador
     */
    @Override
    public void crearUsuario(Jugador usuario) {
        UtilesXML util = new UtilesXML(new File("xml/usuarios.xml"));
        int id=1;   
        List<Jugador> listadoTableros=obtenerTodosUsuarios();
        try{  
         Document doc =util.accesoAlDocument();
                
         Node nodoRaiz = util.accesoANodoXML("usuarios");         
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
         
         Element nuevaIdPartida = doc.createElement("idPartida");
         nuevaIdPartida.setTextContent(String.valueOf(usuario.getIdPartida()));
         
         Element nuevoTurno = doc.createElement("turno");
         nuevoTurno.setTextContent(String.valueOf(usuario.getTurno()));
         
         Element nuevoEstadoTurno = doc.createElement("estadoturno");
         nuevoEstadoTurno.setTextContent(String.valueOf(usuario.getEstadoTurno()));
                 
         nuevoUsuario.appendChild(nuevoId);
         nuevoUsuario.appendChild(nuevoIdCasilla);
         nuevoUsuario.appendChild(nuevoDinero);
         nuevoUsuario.appendChild(nuevaFigura);
         nuevoUsuario.appendChild(nuevoNombre);
         nuevoUsuario.appendChild(nuevaIdPartida);
         nuevoUsuario.appendChild(nuevoTurno);
         nuevoUsuario.appendChild(nuevoEstadoTurno);
         nodoRaiz.appendChild(nuevoUsuario);     
         
         util.modificarOEliminarElementoXML(new File ("xml/usuarios.xml"), doc);
                         
        }catch(ParserConfigurationException | SAXException | IOException | TransformerException parseE){
            System.out.println("Error: monopoly.dal.TableroDAL.obtenerTodasTableros() "+parseE.getMessage());
        }             
    }
    
    /**
     * Obtiene un listado de todos los Jugadores
     * @return 
     * @see Jugador
     */   
    @Override
    public List<Jugador> obtenerTodosUsuarios(){
        List<Jugador> listaUsuarios= new ArrayList<Jugador>();
        UtilesXML util=new UtilesXML(new File("xml/usuarios.xml"));
        try{         
         NodeList nodosUsuarios = util.accesoAXML("usuario");
         
         for(int i = 0; i < nodosUsuarios.getLength(); i++){
             Node usuario = nodosUsuarios.item(i);
             if(usuario.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) usuario;
                 Jugador objUsuario = new Jugador();
                 objUsuario.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objUsuario.setNombre(obtenerNodoValor("nombre", unElemento));                 
                 objUsuario.setIdCasilla(Integer.parseInt(obtenerNodoValor("idcasilla", unElemento)));
                 objUsuario.setDinero(Integer.parseInt(obtenerNodoValor("dinero",unElemento)));
                 objUsuario.setFigura(obtenerNodoValor("figura", unElemento)); 
                 objUsuario.setIdCasilla(Integer.parseInt(obtenerNodoValor("idpartida", unElemento)));
                 objUsuario.setTurno(Integer.valueOf(obtenerNodoValor("turno", unElemento)));
                 objUsuario.setTurno(Integer.valueOf(obtenerNodoValor("estadoturno", unElemento)));
                 listaUsuarios.add(objUsuario);
             }
         }                 
        }catch(ParserConfigurationException | SAXException | IOException parseE){
            System.out.println("Error: monopoly.dal.UsuarioDAL.obtenerTodasUsuarios() "+parseE.getMessage());
        }   
        return listaUsuarios;
    }
}
