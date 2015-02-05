package iilumme.hymiopeli.highscore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HighScoreTallentajaTyhjaTest {

    private HighScoreTallentaja tallentaja;

    public HighScoreTallentajaTyhjaTest() {
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
        } catch (Exception e) {

        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getEkaPalauttaaNull() {
        assertEquals(null, tallentaja.getEka());
    }
}
