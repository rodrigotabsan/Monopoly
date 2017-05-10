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
import monopoly.modelo.entidades.Propiedad;
import monopoly.modelo.IPropiedadDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Utilizado para acceder al fichero XML que contiene los datos de las propiedades.
 * @author Rodrigo
 */
public class PropiedadDAL implements IPropiedadDAL{

    /**
     *
     */
    public PropiedadDAL() {
    }
    
    /**
     * Obtiene el valor del nodo. Básicamente coge del tag o pestaña que se le pase,
     * en el parámetro strTag, el valor que le corresponde en el fichero XML.
     * @param strTag
     * @param eCasilla
     * @return 
     */     
    private static String obtenerNodoValor(String strTag, Element ePropiedad){
         Node nValor=(Node)ePropiedad.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Obtiene un listado con todas las propiedades
     * @return 
     * @see Propiedad
     */
    @Override
    public List<Propiedad> obtenerTodasPropiedades(){
        List<Propiedad> listaPropiedades= new ArrayList<Propiedad>();
        
        UtilesXML util = new UtilesXML(new File("xml/propiedades.xml"));
              
         NodeList nodosPropiedades = util.accesoAXML("propiedad");
         
         for(int i = 0; i < nodosPropiedades.getLength(); i++){
             Node propiedad = nodosPropiedades.item(i);
             if(propiedad.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) propiedad;
                 Propiedad objPropiedad = new Propiedad();
                 objPropiedad.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));
                 objPropiedad.setNombre(obtenerNodoValor("nombre", unElemento));    
                 objPropiedad.setTipo(obtenerNodoValor("tipo", unElemento));  
                 objPropiedad.setPrecio(Integer.parseInt(obtenerNodoValor("precio", unElemento)));  
                 objPropiedad.setIdUsuario(Integer.parseInt(obtenerNodoValor("idusuario",unElemento))); 
                 objPropiedad.setDescripcion(obtenerNodoValor("descripcion", unElemento));
                 objPropiedad.setColor(obtenerNodoValor("color", unElemento));        
                 objPropiedad.setIdCasilla(Integer.parseInt(obtenerNodoValor("idcasilla", unElemento)));
                 objPropiedad.setHipoteca(Integer.parseInt(obtenerNodoValor("hipoteca", unElemento)));
                 objPropiedad.setAlquiler(Integer.parseInt(obtenerNodoValor("alquiler", unElemento)));
                 objPropiedad.setCasa(Integer.parseInt(obtenerNodoValor("casa", unElemento)));
                 objPropiedad.setAlquilerPrimeraCasa(Integer.parseInt(obtenerNodoValor("alquilerprimeracasa", unElemento)));
                 objPropiedad.setAlquilerSegundaCasa(Integer.parseInt(obtenerNodoValor("alquilersegundacasa", unElemento)));
                 objPropiedad.setAlquilerTerceraCasa(Integer.parseInt(obtenerNodoValor("alquilerterceracasa", unElemento)));
                 objPropiedad.setAlquilerCuartaCasa(Integer.parseInt(obtenerNodoValor("alquilercuartacasa", unElemento)));
                 objPropiedad.setHotel(Integer.parseInt(obtenerNodoValor("hotel", unElemento)));
                 objPropiedad.setAlquilerHotel(Integer.parseInt(obtenerNodoValor("alquilerhotel", unElemento)));
                 
                 listaPropiedades.add(objPropiedad);
             }
         }   
        return listaPropiedades;
    }
}
