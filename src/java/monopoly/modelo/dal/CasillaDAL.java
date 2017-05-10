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
import monopoly.modelo.entidades.Casilla;
import monopoly.modelo.ICasillaDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;        
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * Utilizado para acceder al fichero XML que contiene los datos de las casillas.
 * @author Rodrigo
 */
public class CasillaDAL implements ICasillaDAL{
    
    public CasillaDAL(){
        
    }
    
    /**
     * Obtiene el valor del nodo. Básicamente coge del tag o pestaña que se le pase,
     * en el parámetro strTag, el valor que le corresponde en el fichero XML.
     * @param strTag
     * @param eCasilla
     * @return 
     */    
    private static String obtenerNodoValor(String strTag, Element eCasilla){
         Node nValor=(Node)eCasilla.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Obtiene un listado de todas las casillas
     * @return 
     * @see Casilla
     */
    @Override
    public List<Casilla> obtenerTodasCasillas(){
        List<Casilla> listaCasillas= new ArrayList<Casilla>();
        UtilesXML util = new UtilesXML(new File("xml/casillas.xml"));
        try{         
         NodeList nodosCasillas = util.accesoAXML("casilla");
         
         for(int i = 0; i < nodosCasillas.getLength(); i++){
             Node casilla = nodosCasillas.item(i);
             if(casilla.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) casilla;                 
                 Casilla objCasilla = new Casilla();
                 objCasilla.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objCasilla.setNombre(obtenerNodoValor("nombre", unElemento));
                 objCasilla.setTipo(obtenerNodoValor("tipo", unElemento));
                 listaCasillas.add(objCasilla);
             }
         }                 
        }catch(ParserConfigurationException | SAXException | IOException parseE){
            System.out.println("Error: monopoly.dal.CasillaDAL.obtenerTodasCasillas() "+parseE.getMessage());
        }   
        return listaCasillas;
    }
}
