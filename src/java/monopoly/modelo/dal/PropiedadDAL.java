/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import monopoly.modelo.entidades.Propiedad;
import monopoly.modelo.IPropiedadDAL;
import monopoly.modelo.entidades.Jugador;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
     * @param strTag la etiqueta xml
     * @param ePropiedad La propiedad a la que se quiere acceder.
     * @return 
     */     
    private static String obtenerNodoValor(String strTag, Element ePropiedad){
         Node nValor=(Node)ePropiedad.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Obtiene un listado con todas las propiedades
     * @return El listado de Propiedades
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
    
    /**
     * Guardo las propiedades
     * @param fichero fichero donde lo guardo
     * @param propiedades lista de propiedades
     */
    @Override
    public void guardarPropiedades(String fichero, List<Propiedad> propiedades) {
            UtilesXML util = new UtilesXML(new File(fichero));
                
                Document doc =util.accesoAlDocument();

                Node nodoRaiz = util.accesoANodoXML();
               
             for(Propiedad propiedad:propiedades){
                
                Element nuevoPropiedad = doc.createElement("propiedad");             
                
                
                Element nuevoId = doc.createElement("id"); 
                nuevoId.setTextContent(String.valueOf(propiedad.getId()));
                
                Element nuevoNombre = doc.createElement("nombre");
                nuevoNombre.setTextContent(String.valueOf(propiedad.getNombre()));

                Element nuevoTipo = doc.createElement("tipo");
                nuevoTipo.setTextContent(propiedad.getTipo());

                Element nuevoPrecio = doc.createElement("precio");
                nuevoPrecio.setTextContent(String.valueOf(propiedad.getPrecio()));

                Element nuevaIdUsuario = doc.createElement("idusuario");
                nuevaIdUsuario.setTextContent(String.valueOf(propiedad.getIdUsuario()));

                Element nuevoDescripcion = doc.createElement("descripcion");
                nuevoDescripcion.setTextContent(String.valueOf(propiedad.getDescripcion()));

                Element nuevoColor = doc.createElement("color");
                nuevoColor.setTextContent(String.valueOf(propiedad.getColor()));
                
                Element nuevoIdCasilla = doc.createElement("idcasilla"); 
                nuevoIdCasilla.setTextContent(String.valueOf(propiedad.getIdCasilla()));

                Element nuevaHipoteca = doc.createElement("hipoteca");
                nuevaHipoteca.setTextContent(String.valueOf(propiedad.getHipoteca()));

                Element nuevoAlquiler = doc.createElement("alquiler");
                nuevoAlquiler.setTextContent(String.valueOf(propiedad.getAlquiler()));

                Element nuevaCasa = doc.createElement("casa");
                nuevaCasa.setTextContent(String.valueOf(propiedad.getCasa()));
                
                Element nuevaAlquilerPrimeraCasa = doc.createElement("alquilerprimeracasa");
                nuevaAlquilerPrimeraCasa.setTextContent(String.valueOf(propiedad.getAlquilerPrimeraCasa()));
                
                Element nuevaAlquilerSegundaCasa = doc.createElement("alquilersegundacasa");
                nuevaAlquilerSegundaCasa.setTextContent(String.valueOf(propiedad.getAlquilerSegundaCasa()));
                
                Element nuevaAlquilerTerceraCasa = doc.createElement("alquilerprimeracasa");
                nuevaAlquilerTerceraCasa.setTextContent(String.valueOf(propiedad.getAlquilerTerceraCasa()));
                
                Element nuevaAlquilerCuartaCasa = doc.createElement("alquilerprimeracasa");
                nuevaAlquilerCuartaCasa.setTextContent(String.valueOf(propiedad.getAlquilerCuartaCasa()));
                
                Element nuevoHotel = doc.createElement("hotel");
                nuevoHotel.setTextContent(String.valueOf(propiedad.getHotel()));
                
                Element nuevoAlquilerHotel = doc.createElement("alquilerhotel");
                nuevoAlquilerHotel.setTextContent(String.valueOf(propiedad.getAlquilerHotel()));
     
                nuevoPropiedad.appendChild(nuevoId);
                nuevoPropiedad.appendChild(nuevoNombre);
                nuevoPropiedad.appendChild(nuevoTipo);
                nuevoPropiedad.appendChild(nuevoPrecio);
                nuevoPropiedad.appendChild(nuevaIdUsuario);
                
                nuevoPropiedad.appendChild(nuevoDescripcion);
                nuevoPropiedad.appendChild(nuevoColor);
                nuevoPropiedad.appendChild(nuevoIdCasilla);
                nuevoPropiedad.appendChild(nuevaHipoteca);
                nuevoPropiedad.appendChild(nuevoAlquiler);
                nuevoPropiedad.appendChild(nuevaCasa);
                
                nuevoPropiedad.appendChild(nuevaAlquilerPrimeraCasa);
                nuevoPropiedad.appendChild(nuevaAlquilerSegundaCasa);
                nuevoPropiedad.appendChild(nuevaAlquilerTerceraCasa);
                nuevoPropiedad.appendChild(nuevaAlquilerCuartaCasa);
                
                nuevoPropiedad.appendChild(nuevoHotel);
                nuevoPropiedad.appendChild(nuevoAlquilerHotel);
                nodoRaiz.appendChild(nuevoPropiedad);     

                util.modificarOEliminarElementoXML(new File(fichero), doc);    
             }
    }
}