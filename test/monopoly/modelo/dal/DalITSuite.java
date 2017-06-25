/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo.dal;

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
@Suite.SuiteClasses({monopoly.modelo.dal.TSorpresaSuerteDALIT.class, monopoly.modelo.dal.JugadorDALIT.class, monopoly.modelo.dal.PropiedadDALIT.class, monopoly.modelo.dal.TableroDALIT.class, monopoly.modelo.dal.EspecialDALIT.class, monopoly.modelo.dal.CasillaDALIT.class, monopoly.modelo.dal.PartidaDALIT.class})
public class DalITSuite {

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
