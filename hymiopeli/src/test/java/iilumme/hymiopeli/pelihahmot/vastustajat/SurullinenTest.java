package iilumme.hymiopeli.pelihahmot.vastustajat;

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
