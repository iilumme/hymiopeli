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

        assertEquals("Uusi Peli", KieliUtil.getString("uusipeli"));
    }

    @Test
    public void vaihtaaBundlenEnglanniksi() {

        KieliUtil.setLanguage("EN");

        assertEquals("New Game", KieliUtil.getString("uusipeli"));
    }

    @Test
    public void vaihtaaBundlenEspanjaksi() {

        KieliUtil.setLanguage("ES");

        assertEquals("A Jugar!", KieliUtil.getString("uusipeli"));
    }

    @Test
    public void vaihtaaBundlenSuomeksi() {

        KieliUtil.setLanguage("ES");
        KieliUtil.setLanguage("FI");

        assertEquals("Uusi Peli", KieliUtil.getString("uusipeli"));
    }

}
