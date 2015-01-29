package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HymioTest {

    private Hymio hymio;

    public HymioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hymio = new Hymio();
    }

    @After
    public void tearDown() {
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
}
