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
public class EspecialIT {
    
    public EspecialIT() {
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
     * Test of getId method, of class Especial.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Especial instance = new Especial();
        
        int result = instance.getId();
        int expResult = result;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Especial.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Especial instance = new Especial();
        instance.setId(id);
        
    }

    /**
     * Test of getNombre method, of class Especial.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Especial instance = new Especial();
        String expResult = "SUERTE";
        String result = instance.getNombre();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setNombre method, of class Especial.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "PACO";
        Especial instance = new Especial();
        instance.setNombre(nombre);
    }

    /**
     * Test of getTipo method, of class Especial.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Especial instance = new Especial();
        String expResult = "SORPRESA";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTipo method, of class Especial.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "SUERTE";
        Especial instance = new Especial();
        instance.setTipo(tipo);
    }

    /**
     * Test of getBonus method, of class Especial.
     */
    @Test
    public void testGetBonus() {
        System.out.println("getBonus");
        Especial instance = new Especial();
        int expResult = 0;
        int result = instance.getBonus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBonus method, of class Especial.
     */
    @Test
    public void testSetBonus() {
        System.out.println("setBonus");
        int bonus = 0;
        Especial instance = new Especial();
        instance.setBonus(bonus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCasilla method, of class Especial.
     */
    @Test
    public void testGetIdCasilla() {
        System.out.println("getIdCasilla");
        Especial instance = new Especial();
        int expResult = 0;
        int result = instance.getIdCasilla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCasilla method, of class Especial.
     */
    @Test
    public void testSetIdCasilla() {
        System.out.println("setIdCasilla");
        int idCasilla = 0;
        Especial instance = new Especial();
        instance.setIdCasilla(idCasilla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
