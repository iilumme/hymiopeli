package iilumme.hymiopeli.pelihahmot;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import iilumme.hymiopeli.pelihahmot.vastukset.Surullinen;
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
public class PelaajaTest {

    public PelaajaTest() {
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
    public void onkoMuutettuToimii() {

        Pelaaja pelaaja = new Hymio();

        assertEquals(false, pelaaja.onkoMuutettu());
    }

    @Test
    public void onkoMuutettuToimii2() {

        Vastus vastus = new Surullinen(30, 40);
        HymioPeli h = new HymioPeli(100, 100);
        h.setHahmovalinta(1);
        h.lisaaHahmot();
        for (int i = 0; i < 1; i++) {
            h.muutu(h.getVastukset().get(i));
        }

        Pelaaja pelaaja = h.getMuutetutHahmot().get(0);

        assertEquals(true, pelaaja.onkoMuutettu());
    }
    
    
    @Test
    public void pelaajaLiikkuuOikein() {

        Pelaaja pelaaja = new Hymio();
        pelaaja.siirra(-60, 0);

        assertEquals(0, pelaaja.getX());
        assertEquals(300, pelaaja.getY());
    }
    
    @Test
    public void pelaajaLiikkuuOikeinJosMuuttunu() {

        Vastus vastus = new Surullinen(30, 40);
        HymioPeli h = new HymioPeli(100, 100);
        h.setHahmovalinta(1);
        h.lisaaHahmot();
        for (int i = 0; i < 1; i++) {
            h.muutu(h.getVastukset().get(i));
        }

        Pelaaja pelaaja = h.getMuutetutHahmot().get(0);
        
        pelaaja.setXY(20, 20);
        pelaaja.siirra(-100, 0);

        assertEquals(-80, pelaaja.getX());
        assertEquals(20, pelaaja.getY());
    }
}
