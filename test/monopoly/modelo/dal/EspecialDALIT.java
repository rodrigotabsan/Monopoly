/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.Especial;
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
public class EspecialDALIT {
    
    public EspecialDALIT() {
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
     * Test of obtenerTodasEspeciales method, of class EspecialDAL.
     */
    @Test
    public void testObtenerTodasEspeciales_0args() {
        System.out.println("obtenerTodasEspeciales");
        EspecialDAL instance = new EspecialDAL();
        List<Especial> expResult = null;
        List<Especial> result = instance.obtenerTodasEspeciales();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasEspeciales method, of class EspecialDAL.
     */
    @Test
    public void testObtenerTodasEspeciales_String() {
        System.out.println("obtenerTodasEspeciales");
        String partidaGuardada = "";
        EspecialDAL instance = new EspecialDAL();
        List<Especial> expResult = null;
        List<Especial> result = instance.obtenerTodasEspeciales(partidaGuardada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEspecial method, of class EspecialDAL.
     */
    @Test
    public void testGuardarEspecial() {
        System.out.println("guardarEspecial");
        String fichero = "";
        List<Especial> especiales = null;
        EspecialDAL instance = new EspecialDAL();
        instance.guardarEspecial(fichero, especiales);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
