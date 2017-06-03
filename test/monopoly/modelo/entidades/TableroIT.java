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
public class TableroIT {
    
    public TableroIT() {
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
     * Test of getId method, of class Tablero.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tablero instance = new Tablero();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Tablero.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Tablero instance = new Tablero();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCasilla method, of class Tablero.
     */
    @Test
    public void testGetIdCasilla() {
        System.out.println("getIdCasilla");
        Tablero instance = new Tablero();
        int expResult = 0;
        int result = instance.getIdCasilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCasilla method, of class Tablero.
     */
    @Test
    public void testSetIdCasilla() {
        System.out.println("setIdCasilla");
        int idCasilla = 0;
        Tablero instance = new Tablero();
        instance.setIdCasilla(idCasilla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTSorpresaSuerte method, of class Tablero.
     */
    @Test
    public void testGetIdTSorpresaSuerte() {
        System.out.println("getIdTSorpresaSuerte");
        Tablero instance = new Tablero();
        int expResult = 0;
        int result = instance.getIdTSorpresaSuerte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTSorpresaSuerte method, of class Tablero.
     */
    @Test
    public void testSetIdTSorpresaSuerte() {
        System.out.println("setIdTSorpresaSuerte");
        int idTSorpresaSuerte = 0;
        Tablero instance = new Tablero();
        instance.setIdTSorpresaSuerte(idTSorpresaSuerte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurno method, of class Tablero.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        Tablero instance = new Tablero();
        int expResult = 0;
        int result = instance.getTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurno method, of class Tablero.
     */
    @Test
    public void testSetTurno() {
        System.out.println("setTurno");
        int turno = 0;
        Tablero instance = new Tablero();
        instance.setTurno(turno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
