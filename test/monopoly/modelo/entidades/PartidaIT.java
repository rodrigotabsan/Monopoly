/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

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
public class PartidaIT {
    
    public PartidaIT() {
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
     * Test of getId method, of class Partida.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Partida instance = new Partida();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Partida.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Partida instance = new Partida();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Partida.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Partida instance = new Partida();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Partida.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Partida instance = new Partida();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTablero method, of class Partida.
     */
    @Test
    public void testGetIdTablero() {
        System.out.println("getIdTablero");
        Partida instance = new Partida();
        int expResult = 0;
        int result = instance.getIdTablero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTablero method, of class Partida.
     */
    @Test
    public void testSetIdTablero() {
        System.out.println("setIdTablero");
        int idTablero = 0;
        Partida instance = new Partida();
        instance.setIdTablero(idTablero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
