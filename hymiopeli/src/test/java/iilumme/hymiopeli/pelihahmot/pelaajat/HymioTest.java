package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
import java.awt.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HymioTest {

    private Hymio hymio;

    public HymioTest() {
    }

    @Before
    public void setUp() {
        hymio = new Hymio();
    }

    @Test
    public void getRajatToimiiOikeinXAkseli() {

        Rectangle nelio = hymio.getRajat();

        assertEquals(50, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseli() {

        Rectangle nelio = hymio.getRajat();

        assertEquals(300, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinXAkseliSiirronJalkeen() {

        hymio.siirra(5, 5);
        Rectangle nelio = hymio.getRajat();

        assertEquals(55, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseliSiirronJalkeen() {

        hymio.siirra(5, 5);
        Rectangle nelio = hymio.getRajat();

        assertEquals(305, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinLeveys() {

        Rectangle nelio = hymio.getRajat();

        assertEquals(52, nelio.width);

    }
    
    @Test
    public void getRajatToimiiOikeinKorkeus() {

        Rectangle nelio = hymio.getRajat();

        assertEquals(62, nelio.height);

    }

    @Test
    public void oikeaSijaintiY() {

        hymio.siirra(0, 4);

        assertEquals(304, hymio.getY());
    }

    @Test
    public void oikeaSijaintiX() {

        hymio.siirra(4, 0);

        assertEquals(54, hymio.getX());
    }

    @Test
    public void oikeaSijaintiYNegLuku() {

        hymio.siirra(0, -4);

        assertEquals(296, hymio.getY());
    }

    @Test
    public void oikeaSijaintiXNegLuku() {

        hymio.siirra(-4, 0);

        assertEquals(46, hymio.getX());
    }

}
