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
import javax.xml.transform.TransformerException;
import monopoly.modelo.entidades.Partida;
import monopoly.modelo.IPartidaDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
     * @param strTag
     * @param eCasilla
     * @return 
     */     
    private static String obtenerNodoValor(String strTag, Element ePartida){
         Node nValor=(Node)ePartida.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Elimina una partida
     * @param partida 
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
    
    /*public static void crearPartida(Partida partida) {
        UtilesXML util = new UtilesXML(new File("src/java/xml/partidas.xml"));
        int id=1;   
        ArrayList<Partida> listadoPartidas=obtenerTodasPartidas();
        try{  
         Document doc =util.accesoAlDocument();
                
         Node nodoRaiz = util.accesoANodoXML("partidas");         
         Element nuevoPartida = doc.createElement("partida");
         Element nuevoId = doc.createElement("id");  
         if(listadoPartidas.size()>0){
             id=listadoPartidas.size()+1;
         }
         partida.setId(id);
         nuevoId.setTextContent(String.valueOf(partida.getId()));
         
         Element nuevoIdCasilla = doc.createElement("idcasilla"); 
         nuevoIdCasilla.setTextContent(String.valueOf(partida.getIdCasilla()));
         
         Element nuevoIdSorpresaSuerte = doc.createElement("idsorpresasuerte");
         nuevoIdSorpresaSuerte.setTextContent(String.valueOf(partida.getIdTSorpresaSuerte()));
         nuevoPartida.appendChild(nuevoId);
         nuevoPartida.appendChild(nuevoIdCasilla);
         nuevoPartida.appendChild(nuevoIdSorpresaSuerte);
         nodoRaiz.appendChild(nuevoPartida);     
         
         util.modificarOEliminarElementoXML(new File ("src/java/xml/partidas.xml"),doc);         
                         
        }catch(ParserConfigurationException | SAXException | IOException | TransformerConfigurationException parseE){
            System.out.println("Error: monopoly.dal.PartidaDAL.obtenerTodasPartidas() "+parseE.getMessage());
        }catch (TransformerException parseE){
            System.out.println("Error: monopoly.dal.PartidaDAL.obtenerTodasPartidas() "+parseE.getMessage());
        }                
    }
    */
    /**
     * Obtiene un listado con todas las partidas.
     * @return 
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
}
