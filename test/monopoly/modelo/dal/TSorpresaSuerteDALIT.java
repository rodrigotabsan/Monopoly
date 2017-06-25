/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.List;
import monopoly.modelo.entidades.TSorpresaSuerte;
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
public class TSorpresaSuerteDALIT {
    
    public TSorpresaSuerteDALIT() {
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
     * Test of obtenerTodasTsSorpresaSuerte method, of class TSorpresaSuerteDAL.
     */
    @Test
    public void testObtenerTodasTsSorpresaSuerte_0args() {
        System.out.println("obtenerTodasTsSorpresaSuerte");
        TSorpresaSuerteDAL instance = new TSorpresaSuerteDAL();
        List<TSorpresaSuerte> expResult = null;
        List<TSorpresaSuerte> result = instance.obtenerTodasTsSorpresaSuerte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasTsSorpresaSuerte method, of class TSorpresaSuerteDAL.
     */
    @Test
    public void testObtenerTodasTsSorpresaSuerte_String() {
        System.out.println("obtenerTodasTsSorpresaSuerte");
        String partida = "";
        TSorpresaSuerteDAL instance = new TSorpresaSuerteDAL();
        List<TSorpresaSuerte> expResult = null;
        List<TSorpresaSuerte> result = instance.obtenerTodasTsSorpresaSuerte(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarITSorpresaSuerte method, of class TSorpresaSuerteDAL.
     */
    @Test
    public void testGuardarITSorpresaSuerte() {
        System.out.println("guardarITSorpresaSuerte");
        String fichero = "";
        List<TSorpresaSuerte> tarjetasSorpresaSuerte = null;
        TSorpresaSuerteDAL instance = new TSorpresaSuerteDAL();
        instance.guardarITSorpresaSuerte(fichero, tarjetasSorpresaSuerte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
