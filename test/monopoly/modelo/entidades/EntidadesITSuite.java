/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.entidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Rodrigo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({monopoly.modelo.entidades.PropiedadIT.class, monopoly.modelo.entidades.JugadorIT.class, monopoly.modelo.entidades.TSorpresaSuerteIT.class, monopoly.modelo.entidades.CasillaIT.class, monopoly.modelo.entidades.TableroIT.class, monopoly.modelo.entidades.PartidaIT.class, monopoly.modelo.entidades.EspecialIT.class})
public class EntidadesITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
