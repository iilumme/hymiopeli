package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.pelaajat.IronMan;
import java.awt.Graphics;
import java.awt.Rectangle;
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

    @Test
    public void getRajatToimiiOikeinXAkseli() {

        Rectangle nelio = ironman.getRajat();

        assertEquals(50, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseli() {

        Rectangle nelio = ironman.getRajat();

        assertEquals(300, nelio.y);

    }

    @Test
    public void getRajatToimiiOikeinXAkseliSiirronJalkeen() {

        ironman.siirra(5, 5);
        Rectangle nelio = ironman.getRajat();

        assertEquals(55, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseliSiirronJalkeen() {

        ironman.siirra(5, 5);
        Rectangle nelio = ironman.getRajat();

        assertEquals(305, nelio.y);

    }

    @Test
    public void getRajatToimiiOikeinLeveys() {

        Rectangle nelio = ironman.getRajat();

        assertEquals(45, nelio.width);

    }

    @Test
    public void getRajatToimiiOikeinKorkeus() {

        Rectangle nelio = ironman.getRajat();

        assertEquals(48, nelio.height);

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
