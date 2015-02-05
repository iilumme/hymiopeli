package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IronManTest {

    private IronMan ironman;

    public IronManTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ironman = new IronMan();
    }

    @After
    public void tearDown() {
    }

    //iron manin sijanti alussa: x=50 y=300
    @Test
    public void osuuMetodiToimiiOikeinKunOsuu() {

        Surullinen suru = new Surullinen(50, 300);

        assertTrue(ironman.osuu(suru));

    }

    @Test
    public void osuuMetodiToimiiOikeinKunEIOsu() {

        Surullinen suru = new Surullinen(200, 100);

        assertFalse(ironman.osuu(suru));

    }

    @Test
    public void osuuMetodiToimiiOikeinKunEIOsu2() {

        Surullinen suru = new Surullinen(30, 100);

        assertFalse(ironman.osuu(suru));

    }

    @Test
    public void osuuMetodiToimiiOikeinKunEIOsu3() {

        Surullinen suru = new Surullinen(500, 300);

        assertFalse(ironman.osuu(suru));

    }

    @Test
    public void osuuMetodiToimiiOikeinKunEIOsu4() {

        Surullinen suru = new Surullinen(50, 500);

        assertFalse(ironman.osuu(suru));

    }
    
     @Test
    public void oikeaSijaintiY() {

        ironman.siirra(0, 4);

        assertEquals(304, ironman.getY());
    }

    @Test
    public void oikeaSijaintiX() {

        ironman.siirra(4, 0);

        assertEquals(54, ironman.getX());
    }

    @Test
    public void oikeaSijaintiYNegLuku() {

        ironman.siirra(0, -4);

        assertEquals(296, ironman.getY());
    }

    @Test
    public void oikeaSijaintiXNegLuku() {

        ironman.siirra(-4, 0);

        assertEquals(46, ironman.getX());
    }

}
