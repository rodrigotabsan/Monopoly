/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.Jugador;
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
public class JugadorDALIT {
    
    public JugadorDALIT() {
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
     * Test of eliminarUsuario method, of class JugadorDAL.
     */
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        Jugador usuario = null;
        JugadorDAL instance = new JugadorDAL();
        instance.eliminarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearUsuario method, of class JugadorDAL.
     */
    @Test
    public void testCrearUsuario() {
        System.out.println("crearUsuario");
        Jugador usuario = null;
        JugadorDAL instance = new JugadorDAL();
        instance.crearUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarUsuario method, of class JugadorDAL.
     */
    @Test
    public void testGuardarUsuario() {
        System.out.println("guardarUsuario");
        String fichero = "";
        List<Jugador> jugadores = null;
        JugadorDAL instance = new JugadorDAL();
        instance.guardarUsuario(fichero, jugadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosUsuarios method, of class JugadorDAL.
     */
    @Test
    public void testObtenerTodosUsuarios_0args() {
        System.out.println("obtenerTodosUsuarios");
        JugadorDAL instance = new JugadorDAL();
        List<Jugador> expResult = null;
        List<Jugador> result = instance.obtenerTodosUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosUsuarios method, of class JugadorDAL.
     */
    @Test
    public void testObtenerTodosUsuarios_String() {
        System.out.println("obtenerTodosUsuarios");
        String partida = "";
        JugadorDAL instance = new JugadorDAL();
        List<Jugador> expResult = null;
        List<Jugador> result = instance.obtenerTodosUsuarios(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
