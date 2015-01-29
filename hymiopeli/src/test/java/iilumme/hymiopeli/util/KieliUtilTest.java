package iilumme.hymiopeli.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KieliUtilTest {
    
    private KieliUtil util;

    public KieliUtilTest() {
        this.util = new KieliUtil();
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
    public void bundleAluksiSuomi() {
       
        assertEquals(KieliUtil.getString("uusipeli"), "Uusi Peli");
    }

    @Test
    public void vaihtaaBundlenEnglanniksi() {

        KieliUtil.setLanguage("EN");
        
        assertEquals(KieliUtil.getString("uusipeli"), "New Game");
    }
    
    @Test
    public void vaihtaaBundlenEspanjaksi() {

        KieliUtil.setLanguage("ES");
        
        assertEquals(KieliUtil.getString("uusipeli"), "A Jugar!");
    }
    
    @Test
    public void vaihtaaBundlenSuomeksi() {

        KieliUtil.setLanguage("ES");
        KieliUtil.setLanguage("FI");
        
        assertEquals(KieliUtil.getString("uusipeli"), "Uusi Peli");
    }
    
}
