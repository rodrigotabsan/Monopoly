/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import monopoly.modelo.entidades.Especial;
import monopoly.modelo.IEspecialDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * Utilizado para acceder al fichero XML que contiene los datos de las casillas especiales.
 * @author Rodrigo
 */
public class EspecialDAL implements IEspecialDAL{

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
     * Crea un elemento.
     * @param datoEmple
     * @param valor
     * @param raiz
     * @param document 
     */
    private static void crearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elemento = document.createElement(datoEmple);
        Text texto = document.createTextNode(valor);
        raiz.appendChild(elemento);
        elemento.appendChild(texto);
    }
    
    /**
     * Obtiene un listado de todas las casillas especiales.
     * @return 
     * @see Especial
     */
    @Override
    public ArrayList<Especial> obtenerTodasEspeciales(){
        ArrayList<Especial> listaEspeciales= new ArrayList<Especial>();
        UtilesXML util = new UtilesXML(new File("xml/especiales.xml"));
        try{         
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
        }catch(ParserConfigurationException | SAXException | IOException parseE){
            System.out.println("Error: monopoly.dal.EspecialDAL.obtenerTodasEspeciales() "+parseE.getMessage());
        }   
        return listaEspeciales;
    }
}
