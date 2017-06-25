/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
public class IPropiedadDALIT {
    
    public IPropiedadDALIT() {
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
     * Test of guardarPropiedades method, of class IPropiedadDAL.
     */
    @Test
    public void testGuardarPropiedades() {
        System.out.println("guardarPropiedades");
        String ficheroPropiedades = "";
        List<Propiedad> propiedades = null;
        IPropiedadDAL instance = new IPropiedadDALImpl();
        instance.guardarPropiedades(ficheroPropiedades, propiedades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPropiedades method, of class IPropiedadDAL.
     */
    @Test
    public void testObtenerTodasPropiedades_0args() {
        System.out.println("obtenerTodasPropiedades");
        IPropiedadDAL instance = new IPropiedadDALImpl();
        List<Propiedad> expResult = null;
        List<Propiedad> result = instance.obtenerTodasPropiedades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasPropiedades method, of class IPropiedadDAL.
     */
    @Test
    public void testObtenerTodasPropiedades_String() {
        System.out.println("obtenerTodasPropiedades");
        String partida = "";
        IPropiedadDAL instance = new IPropiedadDALImpl();
        List<Propiedad> expResult = null;
        List<Propiedad> result = instance.obtenerTodasPropiedades(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IPropiedadDALImpl implements IPropiedadDAL {

        public void guardarPropiedades(String ficheroPropiedades, List<Propiedad> propiedades) {
        }

        public List<Propiedad> obtenerTodasPropiedades() {
            return null;
        }

        public List<Propiedad> obtenerTodasPropiedades(String partida) {
            return null;
        }
    }
    
}
