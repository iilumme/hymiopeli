package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
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
    public void osuukoMetodiToimiiOikeinKunOsuu() {

        Surullinen suru = new Surullinen(50, 300);

        assertTrue(hymio.osuu(suru));

    }

    @Test
    public void osuukoMetodiToimiiOikeinKunEIOsuu() {

        Surullinen suru = new Surullinen(200, 100);

        assertFalse(hymio.osuu(suru));

    }

    @Test
    public void osuukoMetodiToimiiOikeinKunEIOsuu2() {

        Surullinen suru = new Surullinen(30, 100);

        assertFalse(hymio.osuu(suru));

    }

    @Test
    public void osuukoMetodiToimiiOikeinKunEIOsuu3() {

        Surullinen suru = new Surullinen(500, 300);

        assertFalse(hymio.osuu(suru));

    }

    @Test
    public void osuuMetodiToimiiOikeinKunEIOsu4() {

        Surullinen suru = new Surullinen(50, 500);

        assertFalse(hymio.osuu(suru));

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
