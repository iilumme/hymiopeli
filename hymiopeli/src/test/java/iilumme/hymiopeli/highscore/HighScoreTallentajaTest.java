package iilumme.hymiopeli.highscore;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HighScoreTallentajaTest {

    private HighScoreTallentaja tallentaja;

    public HighScoreTallentajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            tallentaja = new HighScoreTallentaja();
            tallentaja.lisaaHighscore("abc", 1000);
        } catch (Exception ex) {
            Logger.getLogger(HighScoreTallentajaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void highscorenLisaysPisteetOikein() {

        assertEquals(tallentaja.getEka().getPisteet(), 1000);

    }

    @Test
    public void highscorenLisaysNimiOikein() {

        assertEquals(tallentaja.getEka().getNimi(), "abc");

    }
    
    @Test
    public void kahdenHighscorenLisaysNimiOikein() {

        tallentaja.lisaaHighscore("iina", 1995);
        tallentaja.lisaaHighscore("isi", 1963);
        assertEquals(tallentaja.getEka().getNimi(), "iina");

    }
    
    @Test
    public void kahdenHighscorenLisaysPisteetOikein() {

        tallentaja.lisaaHighscore("iina", 1995);
        tallentaja.lisaaHighscore("isi", 1963);
        assertEquals(tallentaja.getEka().getPisteet(), 1995);

    }

}
