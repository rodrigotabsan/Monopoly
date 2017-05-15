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
import monopoly.modelo.entidades.Especial;
import monopoly.modelo.IEspecialDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Utilizado para acceder al fichero XML que contiene los datos de las casillas especiales.
 * @author Rodrigo
 */
public class EspecialDAL implements IEspecialDAL{

    /**
     *
     */
    public EspecialDAL() {
    }
    
    /**
     * Obtiene el valor del nodo. Básicamente coge del tag o pestaña que se le pase,
     * en el parámetro strTag, el valor que le corresponde en el fichero XML.
     * @param strTag
     * @param eCasilla
     * @return 
     */ 
    private static String obtenerNodoValor(String strTag, Element eEspecial){
         Node nValor=(Node)eEspecial.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
        
    /**
     * Obtiene un listado de todas las casillas especiales.
     * @return Listado de Especial
     * @see Especial
     */
    @Override
    public List<Especial> obtenerTodasEspeciales(){
        List<Especial> listaEspeciales= new ArrayList<Especial>();
        UtilesXML util = new UtilesXML(new File("xml/especiales.xml"));
                 
         NodeList nodosEspeciales =  util.accesoAXML("especial");
         
         for(int i = 0; i < nodosEspeciales.getLength(); i++){
             Node especial = nodosEspeciales.item(i);
             if(especial.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) especial;  
                 Especial objEspecial = new Especial();
                 objEspecial.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objEspecial.setNombre(obtenerNodoValor("nombre", unElemento));
                 objEspecial.setTipo(obtenerNodoValor("tipo", unElemento));
                 objEspecial.setBonus(Integer.parseInt(obtenerNodoValor("bonus", unElemento)));
                 objEspecial.setIdCasilla(Integer.parseInt(obtenerNodoValor("idcasilla",unElemento)));
                 listaEspeciales.add(objEspecial);
             }
         }                 
          
        return listaEspeciales;
    }
}
