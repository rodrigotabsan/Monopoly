/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
public class ITSorpresaSuerteDALIT {
    
    public ITSorpresaSuerteDALIT() {
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
     * Test of guardarITSorpresaSuerte method, of class ITSorpresaSuerteDAL.
     */
    @Test
    public void testGuardarITSorpresaSuerte() {
        System.out.println("guardarITSorpresaSuerte");
        String fichero = "";
        List<TSorpresaSuerte> itSorpresaSuerte = null;
        ITSorpresaSuerteDAL instance = new ITSorpresaSuerteDALImpl();
        instance.guardarITSorpresaSuerte(fichero, itSorpresaSuerte);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasTsSorpresaSuerte method, of class ITSorpresaSuerteDAL.
     */
    @Test
    public void testObtenerTodasTsSorpresaSuerte_0args() {
        System.out.println("obtenerTodasTsSorpresaSuerte");
        ITSorpresaSuerteDAL instance = new ITSorpresaSuerteDALImpl();
        List<TSorpresaSuerte> expResult = null;
        List<TSorpresaSuerte> result = instance.obtenerTodasTsSorpresaSuerte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodasTsSorpresaSuerte method, of class ITSorpresaSuerteDAL.
     */
    @Test
    public void testObtenerTodasTsSorpresaSuerte_String() {
        System.out.println("obtenerTodasTsSorpresaSuerte");
        String partida = "";
        ITSorpresaSuerteDAL instance = new ITSorpresaSuerteDALImpl();
        List<TSorpresaSuerte> expResult = null;
        List<TSorpresaSuerte> result = instance.obtenerTodasTsSorpresaSuerte(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ITSorpresaSuerteDALImpl implements ITSorpresaSuerteDAL {

        public void guardarITSorpresaSuerte(String fichero, List<TSorpresaSuerte> itSorpresaSuerte) {
        }

        public List<TSorpresaSuerte> obtenerTodasTsSorpresaSuerte() {
            return null;
        }

        public List<TSorpresaSuerte> obtenerTodasTsSorpresaSuerte(String partida) {
            return null;
        }
    }
    
}
