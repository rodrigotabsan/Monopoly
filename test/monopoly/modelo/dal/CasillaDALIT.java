/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.Casilla;
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
public class CasillaDALIT {
    
    public CasillaDALIT() {
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
     * Test of guardarCasilla method, of class CasillaDAL.
     */
    @Test
    public void testGuardarCasilla() {
        System.out.println("guardarCasilla");
        String fichero = "";
        List<Casilla> casillas = null;
        CasillaDAL instance = new CasillaDAL();
        instance.guardarCasilla(fichero, casillas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasCasillas method, of class CasillaDAL.
     */
    @Test
    public void testObtenerTodasCasillas_0args() {
        System.out.println("obtenerTodasCasillas");
        CasillaDAL instance = new CasillaDAL();
        List<Casilla> expResult = null;
        List<Casilla> result = instance.obtenerTodasCasillas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasCasillas method, of class CasillaDAL.
     */
    @Test
    public void testObtenerTodasCasillas_String() {
        System.out.println("obtenerTodasCasillas");
        String partida = "";
        CasillaDAL instance = new CasillaDAL();
        List<Casilla> expResult = null;
        List<Casilla> result = instance.obtenerTodasCasillas(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
