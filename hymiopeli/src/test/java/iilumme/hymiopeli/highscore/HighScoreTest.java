package iilumme.hymiopeli.highscore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HighScoreTest {

    public HighScoreTest() {
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

    @Test
    public void vertaaOikein() {

        HighScore eka = new HighScore("Iina", 1995);
        HighScore toka = new HighScore("Taavetti", 2011);

        assertTrue(eka.compareTo(toka) > 0);

    }

    @Test
    public void vertaaOikeinSamat() {

        HighScore eka = new HighScore("Iina", 1995);
        HighScore toka = new HighScore("Taavetti", 1995);

        assertTrue(eka.compareTo(toka) == 0);

    }

    @Test
    public void vertaaOikein2() {

        HighScore eka = new HighScore("Iina", 1995);
        HighScore toka = new HighScore("Taavetti", 1670);

        assertTrue(eka.compareTo(toka) < 0);

    }
}
