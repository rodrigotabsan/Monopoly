/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
public class IEspecialDALIT {
    
    public IEspecialDALIT() {
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
     * Test of guardarEspecial method, of class IEspecialDAL.
     */
    @Test
    public void testGuardarEspecial() {
        System.out.println("guardarEspecial");
        String fichero = "";
        List<Especial> especiales = null;
        IEspecialDAL instance = new IEspecialDALImpl();
        instance.guardarEspecial(fichero, especiales);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasEspeciales method, of class IEspecialDAL.
     */
    @Test
    public void testObtenerTodasEspeciales_0args() {
        System.out.println("obtenerTodasEspeciales");
        IEspecialDAL instance = new IEspecialDALImpl();
        List<Especial> expResult = null;
        List<Especial> result = instance.obtenerTodasEspeciales();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasEspeciales method, of class IEspecialDAL.
     */
    @Test
    public void testObtenerTodasEspeciales_String() {
        System.out.println("obtenerTodasEspeciales");
        String partida = "";
        IEspecialDAL instance = new IEspecialDALImpl();
        List<Especial> expResult = null;
        List<Especial> result = instance.obtenerTodasEspeciales(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IEspecialDALImpl implements IEspecialDAL {

        public void guardarEspecial(String fichero, List<Especial> especiales) {
        }

        public List<Especial> obtenerTodasEspeciales() {
            return null;
        }

        public List<Especial> obtenerTodasEspeciales(String partida) {
            return null;
        }
    }
    
}
