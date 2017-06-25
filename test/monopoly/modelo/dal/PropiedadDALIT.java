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
        
        List<Propiedad> result = instance.obtenerTodasPropiedades();
        List<Propiedad> expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodasPropiedades method, of class PropiedadDAL.
     */
    @Test
    public void testObtenerTodasPropiedades_String() {
        System.out.println("obtenerTodasPropiedades");
        String partida = "";
        PropiedadDAL instance = new PropiedadDAL();
        
        List<Propiedad> result = instance.obtenerTodasPropiedades(partida);
        List<Propiedad> expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarPropiedades method, of class PropiedadDAL.
     */
    @Test
    public void testGuardarPropiedades() {
        System.out.println("guardarPropiedades");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\propiedades.xml";
        
        PropiedadDAL instance = new PropiedadDAL();
        List<Propiedad> propiedades = instance.obtenerTodasPropiedades();
        instance.guardarPropiedades(fichero, propiedades);
    }
    
}
