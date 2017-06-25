/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
public class IPartidaDALIT {
    
    public IPartidaDALIT() {
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
     * Test of guardarPartida method, of class IPartidaDAL.
     */
    @Test
    public void testGuardarPartida() {
        System.out.println("guardarPartida");
        String fichero = "";
        Partida partida = null;
        IPartidaDAL instance = new IPartidaDALImpl();
        instance.guardarPartida(fichero, partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPartidas method, of class IPartidaDAL.
     */
    @Test
    public void testObtenerTodasPartidas_0args() {
        System.out.println("obtenerTodasPartidas");
        IPartidaDAL instance = new IPartidaDALImpl();
        List<Partida> expResult = null;
        List<Partida> result = instance.obtenerTodasPartidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPartidas method, of class IPartidaDAL.
     */
    @Test
    public void testObtenerTodasPartidas_String() {
        System.out.println("obtenerTodasPartidas");
        String partida = "";
        IPartidaDAL instance = new IPartidaDALImpl();
        List<Partida> expResult = null;
        List<Partida> result = instance.obtenerTodasPartidas(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPartida method, of class IPartidaDAL.
     */
    @Test
    public void testEliminarPartida() {
        System.out.println("eliminarPartida");
        Partida partida = null;
        IPartidaDAL instance = new IPartidaDALImpl();
        instance.eliminarPartida(partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IPartidaDALImpl implements IPartidaDAL {

        public void guardarPartida(String fichero, Partida partida) {
        }

        public List<Partida> obtenerTodasPartidas() {
            return null;
        }

        public List<Partida> obtenerTodasPartidas(String partida) {
            return null;
        }

        public void eliminarPartida(Partida partida) {
        }
    }
    
}
