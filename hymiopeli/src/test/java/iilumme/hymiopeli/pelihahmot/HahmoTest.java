/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iilumme.hymiopeli.pelihahmot;

import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iina
 */
public class HahmoTest {

    public HahmoTest() {
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

    @Test
    public void hahmoLiikkuuOikeinX_AkselillaPositiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();
        
        hahmo.siirra(20, 0);
        
        assertEquals(hahmo.getX(), 70);
        
    }
    
    @Test
    public void hahmoLiikkuuOikeinY_AkselillaPositiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();
        
        hahmo.siirra(0, 50);
        
        assertEquals(hahmo.getY(), 350);
        
    }
    
    @Test
    public void hahmoLiikkuuOikeinX_AkselillaPNegatiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();
        
        hahmo.siirra(-10, 0);
        
        assertEquals(hahmo.getX(), 40);
        
    }
    
    @Test
    public void hahmoLiikkuuOikeinY_AkselillaPNegatiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();
        
        hahmo.siirra(0, -10);
        
        assertEquals(hahmo.getY(), 290);
        
    }
}
