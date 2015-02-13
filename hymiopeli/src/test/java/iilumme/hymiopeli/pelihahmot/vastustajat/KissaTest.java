package iilumme.hymiopeli.pelihahmot.vastustajat;

import java.awt.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KissaTest {

    private Kissa kisu;

    public KissaTest() {
    }

    @Before
    public void setUp() {
        kisu = new Kissa(40, 50);
    }
    
    @Test
    public void getRajatToimiiOikeinXAkseli() {

        Rectangle nelio = kisu.getRajat();

        assertEquals(40, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseli() {

        Rectangle nelio = kisu.getRajat();

        assertEquals(50, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinXAkseliSiirronJalkeen() {

        kisu.siirra(5, 5);
        Rectangle nelio = kisu.getRajat();

        assertEquals(45, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseliSiirronJalkeen() {

        kisu.siirra(5, 5);
        Rectangle nelio = kisu.getRajat();

        assertEquals(55, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinLeveys() {

        Rectangle nelio = kisu.getRajat();

        assertEquals(45, nelio.width);

    }
    
    @Test
    public void getRajatToimiiOikeinKorkeus() {

        Rectangle nelio = kisu.getRajat();

        assertEquals(48, nelio.height);

    }

    @Test
    public void oikeaSijaintiY() {

        kisu.siirra(0, 4);

        assertEquals(54, kisu.getY());
    }

    @Test
    public void oikeaSijaintiX() {

        kisu.siirra(4, 0);

        assertEquals(44, kisu.getX());
    }

    @Test
    public void oikeaSijaintiYNegLuku() {

        kisu.siirra(0, -4);

        assertEquals(46, kisu.getY());
    }

    @Test
    public void oikeaSijaintiXNegLuku() {

        kisu.siirra(-4, 0);

        assertEquals(36, kisu.getX());
    }
    
    @Test
    public void piirtoOnnistuuAluksiNull() {

        assertNull(kisu.getImage());
    } 

}
