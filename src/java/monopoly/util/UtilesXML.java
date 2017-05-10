/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


/**
 *
 * @author Rodrigo
 */
public class UtilesXML {
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;
    private Document doc; 

    /**
     *
     */
    public UtilesXML() {
    }
       
    /**
     *
     * @param file
     */
    public UtilesXML(File file) {
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder= docFactory.newDocumentBuilder();
            doc= docBuilder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("monopoly.util.Utiles.<init>() "+ex);
        }
    }
    
    /**
     * Obtiene el listado de nodos (los tags del XML). Por defecto coge un Document
     * reutilizable.
     * @param tagName
     * @see Document
     * @return
     */
    public NodeList accesoAXML(String tagName) {           
        doc.getDocumentElement().normalize();
        NodeList nodos = doc.getElementsByTagName(tagName);
        return nodos;
    }
    
    /**
     * Obtenemos el listado de nodos (los tags del XML). Hay que pasarle un Document
     * nuevo.
     * @param tagName
     * @param document
     * @see Document
     * @return
     */
    public NodeList accesoAXML(String tagName, Document document) {                 
         document.getDocumentElement().normalize();
         NodeList nodosUsuarios = document.getElementsByTagName(tagName);
         return nodosUsuarios;
    }
    
    /**
     * Devuelve el nodo padre (el tag padre o etiqueta).
     * @return
     */
    public Node accesoANodoXML() {                 
         doc.getDocumentElement().normalize();
         Node nodoUsuario = doc.getDocumentElement();
         return nodoUsuario;
    }
    
    /**
     * Retorna el Document por defecto.
     * @see Document
     * @return Document
     */
    public Document accesoAlDocument() {                  
         return doc;
    }
    
    /**
     * Modifica o elimina un elemento XML. Se le indica el fichero y el Document
     * @see File
     * @see Document
     * @param file
     * @param document 
     */
    public void modificarOEliminarElementoXML(File file, Document document) {
        try{
         TransformerFactory transFactory = TransformerFactory.newInstance();
         Transformer transformer = transFactory.newTransformer();
         DOMSource source = new DOMSource(document);
         StreamResult result =  new StreamResult(file);
         transformer.transform(source, result);
        }catch(TransformerException te){
            System.out.println("Error al modificar o eliminar un elemento XML");
        }
    }
    
    /**
     * Comprueba si el XML existe. En caso negativo, crea un XML con el nombre 
     * dado, y devuelve true. Sino devuelve false.
     * @param nombreXML
     * @return 
     */
    public boolean crearXML(String nombreXML){
        try {
            File xml = new File("xml/"+nombreXML);
            
            if(!xml.exists()) {
                BufferedWriter bw;
                bw = new BufferedWriter(new FileWriter(xml));
                bw.write("<?xml version='1.0' encoding='UTF-8'?>");
                switch (nombreXML){
                    case "usuarios.xml":
                        bw.write("\r\n<usuarios>"
                                + "\r\n<usuario>"
                                + "\r\n<id>0</id>"
                                + "\r\n<nombre>Admin</nombre>"
                                + "\r\n<figura>sombrero</figura>"
                                + "\r\n<dinero>9999999</dinero>"
                                + "\r\n<idcasilla>0</idcasilla>"
                                + "\r\n<idpartida>0</idpartida>"
                                + "\r\n<turno>1</turno>"
                                + "\r\n<estadoturno>1</estadoturno>"
                                + "\r\n</usuario>"
                                + "\r\n</usuarios>");
                        break;
                    case "tableros.xml":
                        bw.write("\r\n<tableros>"
                                + "\r\n<tablero>"
                                + "\r\n<id>0</id>"
                                + "\r\n<idcasilla>0</idcasilla>"
                                + "\r\n<idtsorpresasuerte>0</idtsorpresasuerte>"
                                + "\r\n<turno>1</turno>"
                                + "\r\n</tablero>"
                                + "\r\n</tableros>");
                        break;
                    case "partidas.xml":
                        bw.write("\r\n<partidas>"
                                + "\r\n<partida>"
                                + "\r\n<id>0</id>"
                                + "\r\n<nombre>prueba</nombre>"
                                + "\r\n<idtablero>0</idtablero>"
                                + "\r\n</partida>"
                                + "\r\n</partidas>");
                        break;
                        
                    default:                        
                        System.out.println("Parece un caso de XML no contemplado: "+nombreXML);
                        break;
                }
                bw.close();
                return true;
            }        
                
        } catch (IOException ex) {
            System.out.println("Parece que ha habido un error al generar las etiquetas del XML. Error: "+ ex);
        }
        return false;
    }
    
    
    
}
