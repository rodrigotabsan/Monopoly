/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class NegociarServletIT {
    
    public NegociarServletIT() {
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
     * Test of processRequest method, of class NegociarServlet.
     */
    @Test
    public void testProcessRequest() {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        NegociarServlet instance = new NegociarServlet();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarString method, of class NegociarServlet.
     */
    @Test
    public void testValidarString() {
        System.out.println("validarString");
        String cadena = "";
        NegociarServlet instance = new NegociarServlet();
        boolean expResult = false;
        boolean result = instance.validarString(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirStringAInteger method, of class NegociarServlet.
     */
    @Test
    public void testConvertirStringAInteger() {
        System.out.println("convertirStringAInteger");
        String numero = "";
        NegociarServlet instance = new NegociarServlet();
        int expResult = 0;
        int result = instance.convertirStringAInteger(numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class NegociarServlet.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        NegociarServlet instance = new NegociarServlet();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class NegociarServlet.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        NegociarServlet instance = new NegociarServlet();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServletInfo method, of class NegociarServlet.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        NegociarServlet instance = new NegociarServlet();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
