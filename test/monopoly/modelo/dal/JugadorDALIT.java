/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.ArrayList;
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
        Jugador usuario = new Jugador(0, "Admin", "sombrero", 0, 0, 0, 0, 0, 0, 0, 0);
        JugadorDAL instance = new JugadorDAL();
        instance.eliminarUsuario(usuario);
    }

    /**
     * Test of crearUsuario method, of class JugadorDAL.
     */
    @Test
    public void testCrearUsuario() {
        System.out.println("crearUsuario");
        Jugador usuario = new Jugador(5, "Admin", "sombrero", 0, 0, 0, 0, 0, 0, 0, 0);
        JugadorDAL instance = new JugadorDAL();
        instance.crearUsuario(usuario);
    }

    /**
     * Test of guardarUsuario method, of class JugadorDAL.
     */
    @Test
    public void testGuardarUsuario() {
        System.out.println("guardarUsuario");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\usuarios.xml";
        Jugador usuario = new Jugador(10, "Admin", "sombrero", 0, 0, 0, 0, 0, 0, 0, 0);
        List<Jugador> jugadores = new ArrayList<>();
        JugadorDAL instance = new JugadorDAL();
        jugadores.add(usuario);
        instance.guardarUsuario(fichero, jugadores);
    }

    /**
     * Test of obtenerTodosUsuarios method, of class JugadorDAL.
     */
    @Test
    public void testObtenerTodosUsuarios_0args() {
        
        
        System.out.println("obtenerTodosUsuarios");
        JugadorDAL instance = new JugadorDAL();
        List<Jugador> expResult = instance.obtenerTodosUsuarios();
        List<Jugador> result = expResult;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodosUsuarios method, of class JugadorDAL.
     */
    @Test
    public void testObtenerTodosUsuarios_String() {
        System.out.println("obtenerTodosUsuarios");
        String partidaGuardada = "21-5-2017";
        JugadorDAL instance = new JugadorDAL();
        List<Jugador> expResult = instance.obtenerTodosUsuarios(partidaGuardada);
        List<Jugador> result = expResult;
        assertEquals(expResult, result);
        
        
        
        
    }
    
}
