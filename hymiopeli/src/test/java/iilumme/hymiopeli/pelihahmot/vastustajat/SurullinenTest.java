package iilumme.hymiopeli.pelihahmot.vastustajat;

import java.awt.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SurullinenTest {

    private Surullinen suru;

    public SurullinenTest() {
    }

    @Before
    public void setUp() {
        suru = new Surullinen(40, 50);
    }
    
    @Test
    public void getRajatToimiiOikeinXAkseli() {

        Rectangle nelio = suru.getRajat();

        assertEquals(40, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseli() {

        Rectangle nelio = suru.getRajat();

        assertEquals(50, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinXAkseliSiirronJalkeen() {

        suru.siirra(5, 5);
        Rectangle nelio = suru.getRajat();

        assertEquals(45, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseliSiirronJalkeen() {

        suru.siirra(5, 5);
        Rectangle nelio = suru.getRajat();

        assertEquals(55, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinLeveys() {

        Rectangle nelio = suru.getRajat();

        assertEquals(52, nelio.width);

    }
    
    @Test
    public void getRajatToimiiOikeinKorkeus() {

        Rectangle nelio = suru.getRajat();

        assertEquals(62, nelio.height);

    }

    @Test
    public void oikeaSijaintiY() {

        suru.siirra(0, 4);

        assertEquals(54, suru.getY());
    }

    @Test
    public void oikeaSijaintiX() {

        suru.siirra(4, 0);

        assertEquals(44, suru.getX());
    }

    @Test
    public void oikeaSijaintiYNegLuku() {

        suru.siirra(0, -4);

        assertEquals(46, suru.getY());
    }

    @Test
    public void oikeaSijaintiXNegLuku() {

        suru.siirra(-4, 0);

        assertEquals(36, suru.getX());
    }

}
