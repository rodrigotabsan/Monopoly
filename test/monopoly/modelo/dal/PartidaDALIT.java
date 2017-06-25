/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.Partida;
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
public class PartidaDALIT {
    
    public PartidaDALIT() {
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
     * Test of eliminarPartida method, of class PartidaDAL.
     */
    @Test
    public void testEliminarPartida() {
        System.out.println("eliminarPartida");
        Partida partida = null;
        PartidaDAL instance = new PartidaDAL();
        instance.eliminarPartida(partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPartidas method, of class PartidaDAL.
     */
    @Test
    public void testObtenerTodasPartidas_0args() {
        System.out.println("obtenerTodasPartidas");
        PartidaDAL instance = new PartidaDAL();
        List<Partida> expResult = null;
        List<Partida> result = instance.obtenerTodasPartidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPartidas method, of class PartidaDAL.
     */
    @Test
    public void testObtenerTodasPartidas_String() {
        System.out.println("obtenerTodasPartidas");
        String partidaGuardada = "";
        PartidaDAL instance = new PartidaDAL();
        List<Partida> expResult = null;
        List<Partida> result = instance.obtenerTodasPartidas(partidaGuardada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarPartida method, of class PartidaDAL.
     */
    @Test
    public void testGuardarPartida() {
        System.out.println("guardarPartida");
        String fichero = "";
        Partida partida = null;
        PartidaDAL instance = new PartidaDAL();
        instance.guardarPartida(fichero, partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
