/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

import java.util.ArrayList;
import java.util.List;
import monopoly.modelo.entidades.Casilla;
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
public class CasillaDALIT {
    
    public CasillaDALIT() {
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
     * Test of guardarCasilla method, of class CasillaDAL.
     */
    @Test
    public void testGuardarCasilla() {
        System.out.println("guardarCasilla");
        String fichero = "C:\\Users\\Rodrigo\\GlassFish_Server\\glassfish\\domains\\domain1\\config\\xml\\21-5-2017\\casillas.xml";
        Casilla casilla = new Casilla(40,"Casilla de Salida","ESPECIAL");
        List<Casilla> casillas = new ArrayList<>();
        CasillaDAL instance = new CasillaDAL();
        casillas.add(casilla);
        instance.guardarCasilla(fichero, casillas);
    }

    /**
     * Test of obtenerTodasCasillas method, of class CasillaDAL.
     */
    @Test
    public void testObtenerTodasCasillas_0args() {
        System.out.println("obtenerTodasCasillas");
        CasillaDAL instance = new CasillaDAL();
        List<Casilla> expResult = instance.obtenerTodasCasillas();
        List<Casilla> result = expResult;
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTodasCasillas method, of class CasillaDAL.
     */
    @Test
    public void testObtenerTodasCasillas_String() {
        System.out.println("obtenerTodasCasillas");
        String partida = "21-5-2017";
        CasillaDAL instance = new CasillaDAL();
        
        List<Casilla> expResult = instance.obtenerTodasCasillas(partida);
        List<Casilla> result = expResult;
        
        assertEquals(expResult, result);
    }
    
}
