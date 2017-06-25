/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelo;

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
@Suite.SuiteClasses({monopoly.modelo.ICasillaDALIT.class, monopoly.modelo.IPartidaDALIT.class, monopoly.modelo.ITSorpresaSuerteDALIT.class, monopoly.modelo.entidades.EntidadesITSuite.class, monopoly.modelo.IPropiedadDALIT.class, monopoly.modelo.dal.DalITSuite.class, monopoly.modelo.ITableroDALIT.class, monopoly.modelo.IJugadorDALIT.class, monopoly.modelo.IEspecialDALIT.class})
public class ModeloITSuite {

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
