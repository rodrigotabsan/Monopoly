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
        
        List<TSorpresaSuerte> result = instance.obtenerTodasTsSorpresaSuerte();
        List<TSorpresaSuerte> expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodasTsSorpresaSuerte method, of class TSorpresaSuerteDAL.
     */
    @Test
    public void testObtenerTodasTsSorpresaSuerte_String() {
        System.out.println("obtenerTodasTsSorpresaSuerte");
        String partida = "21-5-2017";
        TSorpresaSuerteDAL instance = new TSorpresaSuerteDAL();
        
        List<TSorpresaSuerte> result = instance.obtenerTodasTsSorpresaSuerte(partida);
        List<TSorpresaSuerte> expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarITSorpresaSuerte method, of class TSorpresaSuerteDAL.
     */
    @Test
    public void testGuardarITSorpresaSuerte() {
        System.out.println("guardarITSorpresaSuerte");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\tsorpresasuerte.xml";
        TSorpresaSuerteDAL instance = new TSorpresaSuerteDAL();
        List<TSorpresaSuerte> tarjetasSorpresaSuerte = instance.obtenerTodasTsSorpresaSuerte();
        instance.guardarITSorpresaSuerte(fichero, tarjetasSorpresaSuerte);
    }
    
}
