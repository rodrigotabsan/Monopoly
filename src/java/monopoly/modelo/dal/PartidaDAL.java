/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import monopoly.modelo.entidades.Partida;
import monopoly.modelo.IPartidaDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utilizado para acceder al fichero XML que contiene los datos de las partidas.
 * @author Rodrigo
 */
public class PartidaDAL implements IPartidaDAL{

    /**
     *
     */
    public PartidaDAL() {
    }
    
    /**
     * Obtiene el valor del nodo. Básicamente coge del tag o pestaña que se le pase,
     * en el parámetro strTag, el valor que le corresponde en el fichero XML.
     * @param strTag La etiqueta xml.
     * @param ePartida La partida que se quiere. 
     * @return 
     */     
    private static String obtenerNodoValor(String strTag, Element ePartida){
         Node nValor=(Node)ePartida.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Elimina una partida
     * @param partida La partida que se quiere eliminar
     * @see Partida
     */
    @Override
    public void eliminarPartida(Partida partida){        
        UtilesXML util = new UtilesXML(new File("xml/partidas.xml"));
        List<Partida> listaPartidas= new ArrayList<Partida>(); 
        
        Document doc =util.accesoAlDocument();
        NodeList nodosPartidas = util.accesoAXML("partida", doc);
        for(int i = 0; i < nodosPartidas.getLength(); i++){
            Element element= (Element) nodosPartidas.item(i);
            if(element.getAttribute("id").equalsIgnoreCase(String.valueOf(partida.getId()))){
                element.getParentNode().removeChild(element);
            }
        }
        util.modificarOEliminarElementoXML(new File ("xml/partidas.xml"), doc);         
    } 
        
    /**
     * Obtiene un listado con todas las partidas.
     * @return El listado de partidas
     * @see Partida
     */
    @Override
    public List<Partida> obtenerTodasPartidas(){
        List<Partida> listaPartidas= new ArrayList<Partida>();
        UtilesXML util = new UtilesXML(new File("xml/partidas.xml"));
        
         NodeList nodosPartidas = util.accesoAXML("partida");
         
         for(int i = 0; i < nodosPartidas.getLength(); i++){
             Node partida = nodosPartidas.item(i);
             if(partida.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) partida; 
                 Partida objPartida = new Partida();
                 objPartida.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objPartida.setNombre(obtenerNodoValor("nombre", unElemento));                 
                 objPartida.setIdTablero(Integer.parseInt(obtenerNodoValor("idtablero", unElemento)));                 
                 listaPartidas.add(objPartida);
             }
         }                 
         
        return listaPartidas;
    }
    
     /**
     * Obtiene un listado con todas las partidas.
     * @param partidaGuardada String de una partida guardada
     * @return El listado de partidas
     * @see Partida
     */
    @Override
    public List<Partida> obtenerTodasPartidas(String partidaGuardada){
        List<Partida> listaPartidas= new ArrayList<Partida>();
        UtilesXML util = new UtilesXML(new File("xml/"+partidaGuardada+"/partidas.xml"));
        
         NodeList nodosPartidas = util.accesoAXML("partida");
         
         for(int i = 0; i < nodosPartidas.getLength(); i++){
             Node partida = nodosPartidas.item(i);
             if(partida.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) partida; 
                 Partida objPartida = new Partida();
                 objPartida.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objPartida.setNombre(obtenerNodoValor("nombre", unElemento));                 
                 objPartida.setIdTablero(Integer.parseInt(obtenerNodoValor("idtablero", unElemento)));                 
                 listaPartidas.add(objPartida);
             }
         }                 
         
        return listaPartidas;
    }
    
    /**
     * Crea una Partida pasándole el objeto Partida
     * @param fichero donde quiero guardarlo
     * @param partida partida
     * @see Partida
     */
    @Override
    public void guardarPartida(String fichero, Partida partida) {
        UtilesXML util = new UtilesXML(new File(fichero));
                
             Document doc =util.accesoAlDocument();

             Node nodoRaiz = util.accesoANodoXML();          
                             
                Element nuevaPartida = doc.createElement("partida");
                
                Element nuevoId = doc.createElement("id"); 
                nuevoId.setTextContent(String.valueOf(partida.getId()));
                 
                Element nuevoNombre = doc.createElement("nombre"); 
                nuevoNombre.setTextContent(String.valueOf(partida.getNombre()));

                Element nuevoIdTablero = doc.createElement("idtablero");
                nuevoIdTablero.setTextContent(String.valueOf(partida.getIdTablero()));
                                                
                nuevaPartida.appendChild(nuevoId);
                nuevaPartida.appendChild(nuevoNombre);
                nuevaPartida.appendChild(nuevoIdTablero);
                
                nodoRaiz.appendChild(nuevaPartida);     

                util.modificarOEliminarElementoXML(new File(fichero), doc);    
          
    }
}
