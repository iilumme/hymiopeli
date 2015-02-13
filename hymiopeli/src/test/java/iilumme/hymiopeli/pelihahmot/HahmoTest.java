package iilumme.hymiopeli.pelihahmot;

import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import iilumme.hymiopeli.pelihahmot.vastustajat.Kissa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmoTest {

    public HahmoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    
    //pelaaja hahmot eivät saa liikku rajojen ulkopuolelle

    @Test
    public void hahmoLiikkuuOikeinX_AkselillaPositiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(20, 0);

        assertEquals(hahmo.getX(), 70);

    }

    @Test
    public void hahmoLiikkuuOikeinY_AkselillaPositiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(0, 50);

        assertEquals(hahmo.getY(), 350);

    }

    @Test
    public void hahmoLiikkuuOikeinX_AkselillaPNegatiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(-10, 0);

        assertEquals(hahmo.getX(), 40);

    }

    @Test
    public void hahmoLiikkuuOikeinY_AkselillaPNegatiivisellaLuvulla() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(0, -10);

        assertEquals(hahmo.getY(), 290);

    }

    @Test
    public void hahmoEiLiikuRajojenUlkopuolelleXAkseli() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(-51, 0);

        assertEquals(0, hahmo.getX());

    }

    @Test
    public void hahmoEiLiikuRajojenUlkopuolelleYAkseli() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(0, -400);

        assertEquals(0, hahmo.getY());

    }

    @Test
    public void hahmoEiLiikuRajojenUlkopuolelleXAkseli2() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(700, 0);

        assertEquals(600, hahmo.getX());

    }

    @Test
    public void hahmoEiLiikuRajojenUlkopuolelleYAkseli2() {

        Hahmo hahmo = new Hymio();

        hahmo.siirra(0, 400);

        assertEquals(600, hahmo.getY());

    }
    
    
    //vastustajat tulevat ulkopuolelta ja päätyvät ulkopuolelle
    
    
    @Test
    public void vastusLiikkuuRajojenUlkopuolelleXAkseli() {

        Hahmo hahmo = new Kissa(0,0);

        hahmo.siirra(-51, 0);

        assertEquals(-51, hahmo.getX());

    }

    @Test
    public void vastusLiikkuuRajojenUlkopuolelleYAkseli() {

        Hahmo hahmo = new Kissa(0,600);

        hahmo.siirra(0, 50);

        assertEquals(650, hahmo.getY());

    }

    @Test
    public void vastusVoiOllaRajojenUlkopuolelleXAkseli2() {

        Hahmo hahmo = new Kissa(700,0);

        hahmo.siirra(100, 0);

        assertEquals(800, hahmo.getX());

    }

    @Test
    public void vastusVoiOllaRajojenUlkopuolelleYAkseli2() {

        Hahmo hahmo = new Kissa(0,700);

        hahmo.siirra(0, 100);

        assertEquals(800, hahmo.getY());

    }
    
    @Test
    public void setYXToimiiX() {

        Hahmo hahmo = new Kissa(0,700);

        hahmo.setXY(3, 0);

        assertEquals(3, hahmo.getX());

    }
    
    @Test
    public void setYXToimiiY() {

        Hahmo hahmo = new Kissa(0,200);

        hahmo.setXY(0, 7);

        assertEquals(7, hahmo.getY());

    }
    
    @Test
    public void setYXToimiiXY() {

        Hahmo hahmo = new Kissa(100,200);

        hahmo.setXY(5, 5);

        assertEquals(5, hahmo.getX());
        assertEquals(5, hahmo.getY());

    }
    
    @Test
    public void setYXToimiiXYNeg() {

        Hahmo hahmo = new Kissa(100,200);

        hahmo.setXY(-5, -5);

        assertEquals(-5, hahmo.getX());
        assertEquals(-5, hahmo.getY());

    }
    
}
