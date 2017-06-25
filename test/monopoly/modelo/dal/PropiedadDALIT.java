/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.Propiedad;
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
public class PropiedadDALIT {
    
    public PropiedadDALIT() {
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
     * Test of obtenerTodasPropiedades method, of class PropiedadDAL.
     */
    @Test
    public void testObtenerTodasPropiedades_0args() {
        System.out.println("obtenerTodasPropiedades");
        PropiedadDAL instance = new PropiedadDAL();
        List<Propiedad> expResult = null;
        List<Propiedad> result = instance.obtenerTodasPropiedades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPropiedades method, of class PropiedadDAL.
     */
    @Test
    public void testObtenerTodasPropiedades_String() {
        System.out.println("obtenerTodasPropiedades");
        String partida = "";
        PropiedadDAL instance = new PropiedadDAL();
        List<Propiedad> expResult = null;
        List<Propiedad> result = instance.obtenerTodasPropiedades(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarPropiedades method, of class PropiedadDAL.
     */
    @Test
    public void testGuardarPropiedades() {
        System.out.println("guardarPropiedades");
        String fichero = "";
        List<Propiedad> propiedades = null;
        PropiedadDAL instance = new PropiedadDAL();
        instance.guardarPropiedades(fichero, propiedades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
