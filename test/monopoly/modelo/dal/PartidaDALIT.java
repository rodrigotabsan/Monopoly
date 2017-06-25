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
        Partida partida = new Partida(0, "25-96-2017", 0);
        PartidaDAL instance = new PartidaDAL();
        instance.eliminarPartida(partida);
    }

    /**
     * Test of obtenerTodasPartidas method, of class PartidaDAL.
     */
    @Test
    public void testObtenerTodasPartidas_0args() {
        System.out.println("obtenerTodasPartidas");
        PartidaDAL instance = new PartidaDAL();
        
        List<Partida> result = instance.obtenerTodasPartidas();
        List<Partida> expResult = result;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodasPartidas method, of class PartidaDAL.
     */
    @Test
    public void testObtenerTodasPartidas_String() {
        System.out.println("obtenerTodasPartidas");
        String partidaGuardada = "21-5-2017";
        PartidaDAL instance = new PartidaDAL();
        
        List<Partida> result = instance.obtenerTodasPartidas(partidaGuardada);
        List<Partida> expResult = result;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarPartida method, of class PartidaDAL.
     */
    @Test
    public void testGuardarPartida() {
        System.out.println("guardarPartida");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\partidas.xml";
        Partida partida = new Partida(0, "25-96-2017", 0);
        PartidaDAL instance = new PartidaDAL();
        instance.guardarPartida(fichero, partida);
    }
    
}
