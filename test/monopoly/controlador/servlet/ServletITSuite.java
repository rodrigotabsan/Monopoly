/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador.servlet;

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
@Suite.SuiteClasses({monopoly.controlador.servlet.NegociarServletIT.class, monopoly.controlador.servlet.LanzarDadosServletIT.class, monopoly.controlador.servlet.InicioServletIT.class, monopoly.controlador.servlet.SeleccionarJugadorServletIT.class, monopoly.controlador.servlet.GuardarPartidaServletIT.class, monopoly.controlador.servlet.TerminarTurnoServletIT.class})
public class ServletITSuite {

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
