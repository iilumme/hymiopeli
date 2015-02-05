package iilumme.hymiopeli.pelihahmot.vastustajat;

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

}
