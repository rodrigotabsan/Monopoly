/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
public class ITableroDALIT {
    
    public ITableroDALIT() {
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
     * Test of guardarTablero method, of class ITableroDAL.
     */
    @Test
    public void testGuardarTablero() {
        System.out.println("guardarTablero");
        String fichero = "";
        Tablero tablero = null;
        ITableroDAL instance = new ITableroDALImpl();
        instance.guardarTablero(fichero, tablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTablero method, of class ITableroDAL.
     */
    @Test
    public void testEliminarTablero() {
        System.out.println("eliminarTablero");
        Tablero tablero = null;
        ITableroDAL instance = new ITableroDALImpl();
        instance.eliminarTablero(tablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosTableros method, of class ITableroDAL.
     */
    @Test
    public void testObtenerTodosTableros_0args() {
        System.out.println("obtenerTodosTableros");
        ITableroDAL instance = new ITableroDALImpl();
        List<Tablero> expResult = null;
        List<Tablero> result = instance.obtenerTodosTableros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosTableros method, of class ITableroDAL.
     */
    @Test
    public void testObtenerTodosTableros_String() {
        System.out.println("obtenerTodosTableros");
        String partida = "";
        ITableroDAL instance = new ITableroDALImpl();
        List<Tablero> expResult = null;
        List<Tablero> result = instance.obtenerTodosTableros(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearTablero method, of class ITableroDAL.
     */
    @Test
    public void testCrearTablero() {
        System.out.println("crearTablero");
        Tablero tablero = null;
        ITableroDAL instance = new ITableroDALImpl();
        instance.crearTablero(tablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ITableroDALImpl implements ITableroDAL {

        public void guardarTablero(String fichero, Tablero tablero) {
        }

        public void eliminarTablero(Tablero tablero) {
        }

        public List<Tablero> obtenerTodosTableros() {
            return null;
        }

        public List<Tablero> obtenerTodosTableros(String partida) {
            return null;
        }

        public void crearTablero(Tablero tablero) {
        }
    }
    
}
