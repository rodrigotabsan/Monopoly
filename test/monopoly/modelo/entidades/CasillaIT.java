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
public class CasillaIT {
    
    public CasillaIT() {
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
     * Test of getId method, of class Casilla.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Casilla instance = new Casilla();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Casilla.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Casilla instance = new Casilla();
        instance.setId(id);
    }

    /**
     * Test of getNombre method, of class Casilla.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Casilla instance = new Casilla();
        instance.setNombre("Calle Paco");
        String expResult = "Calle Paco";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Casilla.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Calle Paco";
        Casilla instance = new Casilla();        
        instance.setNombre(nombre);
    }

    /**
     * Test of getTipo method, of class Casilla.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Casilla instance = new Casilla();
        instance.setTipo("PROPIEDAD");
        String expResult = "PROPIEDAD";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTipo method, of class Casilla.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "PROPIEDAD";
        Casilla instance = new Casilla();       
        instance.setTipo(tipo);
    }
    
}
