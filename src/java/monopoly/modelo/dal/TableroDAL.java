/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import monopoly.modelo.entidades.Tablero;
import monopoly.modelo.ITableroDAL;
import monopoly.util.UtilesXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utilizado para acceder al fichero XML que contiene los datos de los tableros.
 * @author Rodrigo
 */
public class TableroDAL implements ITableroDAL{

    /**
     *
     */
    public TableroDAL() {
    }
    
    /**
     * Obtiene el valor del nodo. Básicamente coge del tag o pestaña que se le pase,
     * en el parámetro strTag, el valor que le corresponde en el fichero XML.
     * @param strTag La etiqueta xml a la que se quiere acceder
     * @param eTablero El tablero que se quiere obtener
     * @return 
     */ 
    private static String obtenerNodoValor(String strTag, Element eTablero){
         Node nValor=(Node)eTablero.getElementsByTagName(strTag).item(0).getFirstChild();
         return nValor.getNodeValue();
    }  
    
    /**
     * Elimina el tablero. Para ello se le pasa un objeto Tablero.
     * @param tablero El tablero que se quiere eliminar
     * @see Tablero
     */
    @Override
    public void eliminarTablero(Tablero tablero){        
        UtilesXML util = new UtilesXML(new File("xml/tableros.xml"));
        List<Tablero> listaTableros= new ArrayList<>(); 
        
         Document doc =util.accesoAlDocument();
         NodeList nodosTableros = util.accesoAXML("tablero", doc);         
         for(int i = 0; i < nodosTableros.getLength(); i++){
             Element element= (Element) nodosTableros.item(i);
             if(element.getAttribute("id").equalsIgnoreCase(String.valueOf(tablero.getId()))){
                  element.getParentNode().removeChild(element);
             }
         }
         util.modificarOEliminarElementoXML(new File ("xml/tableros.xml"), doc);
           
    } 
    
    /**
     * Crea un nuevo tablero. Se le pasa un objeto tipo Tablero
     * @param tablero El tablero que se quiere crear
     * @see Tablero
     */
    @Override
    public void crearTablero(Tablero tablero) {
        UtilesXML util = new UtilesXML(new File("xml/tableros.xml"));
        int id=1;   
        List<Tablero> listadoTableros=obtenerTodosTableros();
        if(!listadoTableros.isEmpty()){
  
             Document doc =util.accesoAlDocument();

             Node nodoRaiz = util.accesoANodoXML();         
             Element nuevoTablero = doc.createElement("tablero");
             Element nuevoId = doc.createElement("id");  
             if(listadoTableros.size()>0){
                 id=listadoTableros.size()+1;
             }
             tablero.setId(id);
             nuevoId.setTextContent(String.valueOf(tablero.getId()));

             Element nuevoIdCasilla = doc.createElement("idcasilla"); 
             nuevoIdCasilla.setTextContent(String.valueOf(tablero.getIdCasilla()));

             Element nuevoIdSorpresaSuerte = doc.createElement("idsorpresasuerte");
             nuevoIdSorpresaSuerte.setTextContent(String.valueOf(tablero.getIdTSorpresaSuerte()));

             Element nuevoTurno = doc.createElement("turno");
             nuevoTurno.setTextContent(String.valueOf(tablero.getTurno()));
             
             nuevoTablero.appendChild(nuevoId);
             nuevoTablero.appendChild(nuevoIdCasilla);
             nuevoTablero.appendChild(nuevoIdSorpresaSuerte);
             nuevoTablero.appendChild(nuevoTurno);
             System.out.println("pasa por aqui4");
             nodoRaiz.appendChild(nuevoTablero);     

             util.modificarOEliminarElementoXML(new File ("xml/tableros.xml"),doc);         

        }
    }
    
    /**
     * Obtiene un listado con todos los tableros
     * @return Devuelve un listado de Tableros
     * @see Tablero
     */
    @Override
    public List<Tablero> obtenerTodosTableros(){
        List<Tablero> listaTableros= new ArrayList<Tablero>();
        UtilesXML util = new UtilesXML(new File("xml/tableros.xml"));
               
         NodeList nodosTableros = util.accesoAXML("tablero");
         
         for(int i = 0; i < nodosTableros.getLength(); i++){
             Node tablero = nodosTableros.item(i);
             if(tablero.getNodeType()== Node.ELEMENT_NODE){
                 Element unElemento = (Element) tablero;                 
                 Tablero objTablero = new Tablero();
                 objTablero.setId(Integer.parseInt(obtenerNodoValor("id", unElemento)));               
                 objTablero.setIdCasilla(Integer.parseInt(obtenerNodoValor("idcasilla", unElemento)));
                 objTablero.setIdTSorpresaSuerte(Integer.parseInt(obtenerNodoValor("idtsorpresasuerte", unElemento)));
                 objTablero.setTurno(Integer.parseInt(obtenerNodoValor("turno", unElemento)));
                 listaTableros.add(objTablero);
             }
         }                 
          
        return listaTableros;
    }
}
