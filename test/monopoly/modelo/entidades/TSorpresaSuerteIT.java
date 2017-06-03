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
public class TSorpresaSuerteIT {
    
    public TSorpresaSuerteIT() {
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
     * Test of getId method, of class TSorpresaSuerte.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TSorpresaSuerte instance = new TSorpresaSuerte();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class TSorpresaSuerte.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        TSorpresaSuerte instance = new TSorpresaSuerte();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class TSorpresaSuerte.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        TSorpresaSuerte instance = new TSorpresaSuerte();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class TSorpresaSuerte.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        TSorpresaSuerte instance = new TSorpresaSuerte();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class TSorpresaSuerte.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        TSorpresaSuerte instance = new TSorpresaSuerte();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class TSorpresaSuerte.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        TSorpresaSuerte instance = new TSorpresaSuerte();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBonus method, of class TSorpresaSuerte.
     */
    @Test
    public void testGetBonus() {
        System.out.println("getBonus");
        TSorpresaSuerte instance = new TSorpresaSuerte();
        int expResult = 0;
        int result = instance.getBonus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBonus method, of class TSorpresaSuerte.
     */
    @Test
    public void testSetBonus() {
        System.out.println("setBonus");
        int bonus = 0;
        TSorpresaSuerte instance = new TSorpresaSuerte();
        instance.setBonus(bonus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
