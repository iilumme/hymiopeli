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
            HighScoreTallentaja tallentaja = new HighScoreTallentaja();
        } catch (Exception ex) {
            Logger.getLogger(HighScoreTallentajaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void highscorenLisays() {
     
         tallentaja.lisaaHighscore("iina", 0);
         
         assertEquals(this, this);
     
     }
}
