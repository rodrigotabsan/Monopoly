/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.ArrayList;
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
        List<Especial> expResult = instance.obtenerTodasEspeciales();
        List<Especial> result = expResult;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodasEspeciales method, of class EspecialDAL.
     */
    @Test
    public void testObtenerTodasEspeciales_String() {
        System.out.println("obtenerTodasEspeciales");
        String partidaGuardada = "21-5-2017";
        EspecialDAL instance = new EspecialDAL();
        List<Especial> expResult = instance.obtenerTodasEspeciales(partidaGuardada);
        List<Especial> result = expResult;
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarEspecial method, of class EspecialDAL.
     */
    @Test
    public void testGuardarEspecial() {
        System.out.println("guardarEspecial");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\especiales.xml";
        List<Especial> especiales = new ArrayList<>();
        Especial especial=new Especial(0, "especiales.xml", "SUERTE", 0, 0);
        EspecialDAL instance = new EspecialDAL();
        
        instance.guardarEspecial(fichero, especiales);
    }
    
}
