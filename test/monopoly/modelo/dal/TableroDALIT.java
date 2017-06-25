/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.Tablero;
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
public class TableroDALIT {
    
    public TableroDALIT() {
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
     * Test of eliminarTablero method, of class TableroDAL.
     */
    @Test
    public void testEliminarTablero() {
        System.out.println("eliminarTablero");
        Tablero tablero = null;
        TableroDAL instance = new TableroDAL();
        instance.eliminarTablero(tablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearTablero method, of class TableroDAL.
     */
    @Test
    public void testCrearTablero() {
        System.out.println("crearTablero");
        Tablero tablero = null;
        TableroDAL instance = new TableroDAL();
        instance.crearTablero(tablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosTableros method, of class TableroDAL.
     */
    @Test
    public void testObtenerTodosTableros_0args() {
        System.out.println("obtenerTodosTableros");
        TableroDAL instance = new TableroDAL();
        List<Tablero> expResult = null;
        List<Tablero> result = instance.obtenerTodosTableros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosTableros method, of class TableroDAL.
     */
    @Test
    public void testObtenerTodosTableros_String() {
        System.out.println("obtenerTodosTableros");
        String partida = "";
        TableroDAL instance = new TableroDAL();
        List<Tablero> expResult = null;
        List<Tablero> result = instance.obtenerTodosTableros(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarTablero method, of class TableroDAL.
     */
    @Test
    public void testGuardarTablero() {
        System.out.println("guardarTablero");
        String fichero = "";
        Tablero tablero = null;
        TableroDAL instance = new TableroDAL();
        instance.guardarTablero(fichero, tablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
