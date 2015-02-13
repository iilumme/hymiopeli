package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
import java.awt.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiikeriTest {

    private Tiikeri tiikeri;

    public TiikeriTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tiikeri = new Tiikeri();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getRajatToimiiOikeinXAkseli() {

        Rectangle nelio = tiikeri.getRajat();

        assertEquals(50, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseli() {

        Rectangle nelio = tiikeri.getRajat();

        assertEquals(300, nelio.y);

    }

    @Test
    public void getRajatToimiiOikeinXAkseliSiirronJalkeen() {

        tiikeri.siirra(5, 5);
        Rectangle nelio = tiikeri.getRajat();

        assertEquals(55, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseliSiirronJalkeen() {

        tiikeri.siirra(5, 5);
        Rectangle nelio = tiikeri.getRajat();

        assertEquals(305, nelio.y);

    }

    @Test
    public void getRajatToimiiOikeinLeveys() {

        Rectangle nelio = tiikeri.getRajat();

        assertEquals(45, nelio.width);

    }

    @Test
    public void getRajatToimiiOikeinKorkeus() {

        Rectangle nelio = tiikeri.getRajat();

        assertEquals(48, nelio.height);

    }

    @Test
    public void oikeaSijaintiY() {

        tiikeri.siirra(0, 4);

        assertEquals(304, tiikeri.getY());
    }

    @Test
    public void oikeaSijaintiX() {

        tiikeri.siirra(4, 0);

        assertEquals(54, tiikeri.getX());
    }

    @Test
    public void oikeaSijaintiYNegLuku() {

        tiikeri.siirra(0, -4);

        assertEquals(296, tiikeri.getY());
    }

    @Test
    public void oikeaSijaintiXNegLuku() {

        tiikeri.siirra(-4, 0);

        assertEquals(46, tiikeri.getX());
    }

    @Test
    public void piirtoOnnistuuAluksiNull() {

        assertNull(tiikeri.getImage());
    }

}
