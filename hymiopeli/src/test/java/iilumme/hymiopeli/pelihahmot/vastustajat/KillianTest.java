package iilumme.hymiopeli.pelihahmot.vastustajat;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.DebugGraphics;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KillianTest {

    private Killian killian;

    public KillianTest() {
    }

    @Before
    public void setUp() {
        killian = new Killian(40, 50);
    }
    
    @Test
    public void getRajatToimiiOikeinXAkseli() {
        
        

        Rectangle nelio = killian.getRajat();

        assertEquals(40, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseli() {

        Rectangle nelio = killian.getRajat();

        assertEquals(50, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinXAkseliSiirronJalkeen() {

        killian.siirra(5, 5);
        Rectangle nelio = killian.getRajat();

        assertEquals(45, nelio.x);

    }

    @Test
    public void getRajatToimiiOikeinYAkseliSiirronJalkeen() {

        killian.siirra(5, 5);
        Rectangle nelio = killian.getRajat();

        assertEquals(55, nelio.y);

    }
    
    @Test
    public void getRajatToimiiOikeinLeveys() {

        Rectangle nelio = killian.getRajat();

        assertEquals(45, nelio.width);

    }
    
    @Test
    public void getRajatToimiiOikeinKorkeus() {

        Rectangle nelio = killian.getRajat();

        assertEquals(48, nelio.height);

    }

    @Test
    public void oikeaSijaintiY() {

        killian.siirra(0, 4);

        assertEquals(54, killian.getY());
    }

    @Test
    public void oikeaSijaintiX() {

        killian.siirra(4, 0);

        assertEquals(44, killian.getX());
    }

    @Test
    public void oikeaSijaintiYNegLuku() {

        killian.siirra(0, -4);

        assertEquals(46, killian.getY());
    }

    @Test
    public void oikeaSijaintiXNegLuku() {

        killian.siirra(-4, 0);

        assertEquals(36, killian.getX());
    }
    
    @Test
    public void piirtoOnnistuuAluksiNull() {

        assertNull(killian.getImage());
    }   

}
