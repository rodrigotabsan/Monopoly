/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.util;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Rodrigo
 */
public class UtilesXMLIT {
    
    public UtilesXMLIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of accesoAXML method, of class UtilesXML.
     */
    @Test
    public void testAccesoAXML_String() {
        System.out.println("accesoAXML");
        String tagName = "";
        UtilesXML instance = new UtilesXML();
        NodeList expResult = null;
        NodeList result = instance.accesoAXML(tagName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accesoAXML method, of class UtilesXML.
     */
    @Test
    public void testAccesoAXML_String_Document() {
        System.out.println("accesoAXML");
        String tagName = "";
        Document document = null;
        UtilesXML instance = new UtilesXML();
        NodeList expResult = null;
        NodeList result = instance.accesoAXML(tagName, document);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accesoANodoXML method, of class UtilesXML.
     */
    @Test
    public void testAccesoANodoXML() {
        System.out.println("accesoANodoXML");
        UtilesXML instance = new UtilesXML();
        Node expResult = null;
        Node result = instance.accesoANodoXML();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accesoAlDocument method, of class UtilesXML.
     */
    @Test
    public void testAccesoAlDocument() {
        System.out.println("accesoAlDocument");
        UtilesXML instance = new UtilesXML();
        Document expResult = null;
        Document result = instance.accesoAlDocument();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarOEliminarElementoXML method, of class UtilesXML.
     */
    @Test
    public void testModificarOEliminarElementoXML() {
        System.out.println("modificarOEliminarElementoXML");
        File file = null;
        Document document = null;
        UtilesXML instance = new UtilesXML();
        instance.modificarOEliminarElementoXML(file, document);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearXML method, of class UtilesXML.
     */
    @Test
    public void testCrearXML() {
        System.out.println("crearXML");
        String nombreXML = "";
        UtilesXML instance = new UtilesXML();
        boolean expResult = false;
        boolean result = instance.crearXML(nombreXML);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearXMLGuardar method, of class UtilesXML.
     */
    @Test
    public void testCrearXMLGuardar() {
        System.out.println("crearXMLGuardar");
        String directorio = "";
        String nombreXML = "";
        UtilesXML instance = new UtilesXML();
        boolean expResult = false;
        boolean result = instance.crearXMLGuardar(directorio, nombreXML);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
