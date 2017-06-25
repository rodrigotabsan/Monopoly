/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
public class IJugadorDALIT {
    
    public IJugadorDALIT() {
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
     * Test of eliminarUsuario method, of class IJugadorDAL.
     */
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        Jugador usuario = null;
        IJugadorDAL instance = new IJugadorDALImpl();
        instance.eliminarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearUsuario method, of class IJugadorDAL.
     */
    @Test
    public void testCrearUsuario() {
        System.out.println("crearUsuario");
        Jugador usuario = null;
        IJugadorDAL instance = new IJugadorDALImpl();
        instance.crearUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarUsuario method, of class IJugadorDAL.
     */
    @Test
    public void testGuardarUsuario() {
        System.out.println("guardarUsuario");
        String fichero = "";
        List<Jugador> jugadores = null;
        IJugadorDAL instance = new IJugadorDALImpl();
        instance.guardarUsuario(fichero, jugadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosUsuarios method, of class IJugadorDAL.
     */
    @Test
    public void testObtenerTodosUsuarios_0args() {
        System.out.println("obtenerTodosUsuarios");
        IJugadorDAL instance = new IJugadorDALImpl();
        List<Jugador> expResult = null;
        List<Jugador> result = instance.obtenerTodosUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodosUsuarios method, of class IJugadorDAL.
     */
    @Test
    public void testObtenerTodosUsuarios_String() {
        System.out.println("obtenerTodosUsuarios");
        String partida = "";
        IJugadorDAL instance = new IJugadorDALImpl();
        List<Jugador> expResult = null;
        List<Jugador> result = instance.obtenerTodosUsuarios(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IJugadorDALImpl implements IJugadorDAL {

        public void eliminarUsuario(Jugador usuario) {
        }

        public void crearUsuario(Jugador usuario) {
        }

        public void guardarUsuario(String fichero, List<Jugador> jugadores) {
        }

        public List<Jugador> obtenerTodosUsuarios() {
            return null;
        }

        public List<Jugador> obtenerTodosUsuarios(String partida) {
            return null;
        }
    }
    
}
