package iilumme.hymiopeli.pelihahmot.vastustajat;

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

}
