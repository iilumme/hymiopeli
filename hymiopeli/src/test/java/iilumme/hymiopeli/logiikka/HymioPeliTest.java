package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import iilumme.hymiopeli.pelihahmot.pelaajat.IronMan;
import iilumme.hymiopeli.pelihahmot.pelaajat.Tiikeri;
import iilumme.hymiopeli.ui.Piirtoalusta;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HymioPeliTest {

    private HymioPeli hymiopeli;

    public HymioPeliTest() {
    }

    @Before
    public void setUp() {
        hymiopeli = new HymioPeli(600, 600);
    }

    @Test
    public void korkeusOikein() {
        assertEquals(600, hymiopeli.getKorkeus());
    }

    @Test
    public void leveysOikein() {
        assertEquals(600, hymiopeli.getLeveys());
    }

    @Test
    public void tasoOikein() {
        assertEquals(1, hymiopeli.getTaso());
    }

    @Test
    public void tasoOikein2() {
        hymiopeli.kasvataTasoa();
        assertEquals(2, hymiopeli.getTaso());
    }

    @Test
    public void hymioitaNolla() {
        assertEquals(0, hymiopeli.hyvistenMaara());
    }

    @Test
    public void hymioitaYksi() {

        hymiopeli.lisaaHahmot(1);

        assertEquals(1, hymiopeli.hyvistenMaara());
    }

    @Test
    public void hymioitaYksiAlussa() {
        hymiopeli.lisaaHahmot(1);

        Pelaaja pelaaja = hymiopeli.getPelaaja();
        Pelaaja actual = new Hymio();

        assertEquals(pelaaja.getClass(), actual.getClass());

    }

    @Test
    public void tiikereitaYksiAlussa() {
        hymiopeli.lisaaHahmot(2);

        Pelaaja pelaaja = hymiopeli.getPelaaja();
        Pelaaja actual = new Tiikeri();

        assertEquals(pelaaja.getClass(), actual.getClass());

    }

    @Test
    public void ironmanejaYksiAlussa() {
        hymiopeli.lisaaHahmot(3);

        Pelaaja pelaaja = hymiopeli.getPelaaja();
        Pelaaja actual = new IronMan();

        assertEquals(pelaaja.getClass(), actual.getClass());

    }

    @Test
    public void surullisia20Alussa() {
        hymiopeli.lisaaHahmot(1);
        assertEquals(20, hymiopeli.vastustenMaara());
    }

    @Test
    public void kissoja20Alussa() {
        hymiopeli.lisaaHahmot(2);
        assertEquals(20, hymiopeli.vastustenMaara());
    }

    @Test
    public void killianeja20Alussa() {
        hymiopeli.lisaaHahmot(3);
        assertEquals(20, hymiopeli.vastustenMaara());
    }

    @Test
    public void getVastuksetEiNull() {
        hymiopeli.lisaaHahmot(3);
        assertNotNull(hymiopeli.getVastukset());
    }

    @Test
    public void getVastuksetIsEmpty() {
        assertEquals(true, hymiopeli.getVastukset().isEmpty());
    }

    @Test
    public void getHahmotIsEmpty() {
        assertEquals(true, hymiopeli.getHahmot().isEmpty());
    }

    @Test
    public void getHahmotEiOleTyhja() {
        hymiopeli.lisaaHahmot(1);
        assertEquals(false, hymiopeli.getHahmot().isEmpty());
    }

    @Test
    public void piirtoalustaAsennettu() {
        hymiopeli.setPiirtoalusta(new Piirtoalusta(hymiopeli));

        assertTrue(hymiopeli.onkoPiirtoalustaAsennettu());

    }

    @Test
    public void paivitettavaEIAsennettu() {

        assertFalse(hymiopeli.onkoPiirtoalustaAsennettu());

    }
}
