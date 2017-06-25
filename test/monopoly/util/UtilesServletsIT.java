/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.util;

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
public class UtilesServletsIT {
    
    public UtilesServletsIT() {
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
     * Test of mostrarVista method, of class UtilesServlets.
     */
    @Test
    public void testMostrarVista() throws Exception {
        System.out.println("mostrarVista");
        String vista = "";
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        UtilesServlets instance = new UtilesServlets();
        instance.mostrarVista(vista, request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMensajesDeError method, of class UtilesServlets.
     */
    @Test
    public void testEliminarMensajesDeError() throws Exception {
        System.out.println("eliminarMensajesDeError");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        UtilesServlets instance = new UtilesServlets();
        instance.eliminarMensajesDeError(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mensajeErrorNumTotalJugadores method, of class UtilesServlets.
     */
    @Test
    public void testMensajeErrorNumTotalJugadores() throws Exception {
        System.out.println("mensajeErrorNumTotalJugadores");
        HttpServletRequest request = null;
        int numCPU = 0;
        UtilesServlets instance = new UtilesServlets();
        instance.mensajeErrorNumTotalJugadores(request, numCPU);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mensajeErrorFigurasJugadoresDuplicadas method, of class UtilesServlets.
     */
    @Test
    public void testMensajeErrorFigurasJugadoresDuplicadas() throws Exception {
        System.out.println("mensajeErrorFigurasJugadoresDuplicadas");
        HttpServletRequest request = null;
        int jugador = 0;
        UtilesServlets instance = new UtilesServlets();
        instance.mensajeErrorFigurasJugadoresDuplicadas(request, jugador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mensajeErrorAnhadirJugadoresNulos method, of class UtilesServlets.
     */
    @Test
    public void testMensajeErrorAnhadirJugadoresNulos() throws Exception {
        System.out.println("mensajeErrorAnhadirJugadoresNulos");
        HttpServletRequest request = null;
        UtilesServlets instance = new UtilesServlets();
        instance.mensajeErrorAnhadirJugadoresNulos(request);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
