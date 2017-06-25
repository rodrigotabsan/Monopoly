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
        Tablero tablero = new Tablero(0, 0, 0, 0, 0);
        TableroDAL instance = new TableroDAL();
        instance.eliminarTablero(tablero);
    }

    /**
     * Test of crearTablero method, of class TableroDAL.
     */
    @Test
    public void testCrearTablero() {
        System.out.println("crearTablero");
        Tablero tablero = new Tablero(0, 0, 0, 0, 0);
        TableroDAL instance = new TableroDAL();
        instance.crearTablero(tablero);
    }

    /**
     * Test of obtenerTodosTableros method, of class TableroDAL.
     */
    @Test
    public void testObtenerTodosTableros_0args() {
        System.out.println("obtenerTodosTableros");
        TableroDAL instance = new TableroDAL();
        
        List<Tablero> result = instance.obtenerTodosTableros();
        List<Tablero> expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodosTableros method, of class TableroDAL.
     */
    @Test
    public void testObtenerTodosTableros_String() {
        System.out.println("obtenerTodosTableros");
        String partida = "21-5-2017";
        TableroDAL instance = new TableroDAL();
        
        List<Tablero> result = instance.obtenerTodosTableros(partida);
        List<Tablero> expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarTablero method, of class TableroDAL.
     */
    @Test
    public void testGuardarTablero() {
        System.out.println("guardarTablero");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\tableros.xml";
        Tablero tablero = new Tablero(0, 0, 0, 0, 0);
        TableroDAL instance = new TableroDAL();
        instance.guardarTablero(fichero, tablero);
    }
    
}
