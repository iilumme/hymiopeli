package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.pelihahmot.Hahmo;
import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import iilumme.hymiopeli.pelihahmot.pelaajat.IronMan;
import iilumme.hymiopeli.pelihahmot.pelaajat.Tiikeri;
import iilumme.hymiopeli.pelihahmot.vastustajat.Killian;
import iilumme.hymiopeli.pelihahmot.vastustajat.Kissa;
import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
import iilumme.hymiopeli.ui.PaneelienKasittelija;
import iilumme.hymiopeli.ui.Piirtoalusta;
import java.awt.event.ActionEvent;
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
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();

        assertEquals(1, hymiopeli.hyvistenMaara() + 1);
    }

    @Test
    public void hymioitaYksiAlussa() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();

        Pelaaja pelaaja = hymiopeli.getPelaaja();
        Pelaaja actual = new Hymio();

        assertEquals(pelaaja.getClass(), actual.getClass());

    }

    @Test
    public void tiikereitaYksiAlussa() {
        hymiopeli.setHahmovalinta(2);
        hymiopeli.lisaaHahmot();

        Pelaaja pelaaja = hymiopeli.getPelaaja();
        Pelaaja actual = new Tiikeri();

        assertEquals(pelaaja.getClass(), actual.getClass());

    }

    @Test
    public void ironmanejaYksiAlussa() {
        hymiopeli.setHahmovalinta(3);
        hymiopeli.lisaaHahmot();

        Pelaaja pelaaja = hymiopeli.getPelaaja();
        Pelaaja actual = new IronMan();

        assertEquals(pelaaja.getClass(), actual.getClass());

    }

    @Test
    public void surullisia20Alussa() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();
        assertEquals(20, hymiopeli.vastustenMaara());
    }

    @Test
    public void kissoja20Alussa() {
        hymiopeli.setHahmovalinta(2);
        hymiopeli.lisaaHahmot();
        assertEquals(20, hymiopeli.vastustenMaara());
    }

    @Test
    public void killianeja20Alussa() {
        hymiopeli.setHahmovalinta(3);
        hymiopeli.lisaaHahmot();
        assertEquals(20, hymiopeli.vastustenMaara());
    }

    @Test
    public void getVastuksetEiNull() {
        hymiopeli.setHahmovalinta(3);
        hymiopeli.lisaaHahmot();
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
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();
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

    @Test
    public void pisteetOikein() {

        assertEquals(0, hymiopeli.getPisteet());

    }

    @Test
    public void pisteetVäärin() {

        assertNotSame(-4, hymiopeli.getPisteet());

    }

    @Test
    public void getMuutetutHahmot() {

        assertEquals(0, hymiopeli.getMuutetutHahmot().size());
    }

    @Test
    public void getMuutetutHahmot2() {

        assertNotNull(hymiopeli.getMuutetutHahmot());
    }

    @Test
    public void getDelayHakeeoikeanArvon() {
        assertEquals(1000, hymiopeli.getDelay());
    }

    @Test
    public void getInitialDelayHakeeoikeanArvon() {
        assertEquals(200, hymiopeli.getInitialDelay());
    }

    @Test
    public void muutuToimiiHymioSuru() {

        Hahmo hahmo = new Surullinen(20, 20);
        hymiopeli.setHahmovalinta(1);
        hymiopeli.muutu(hahmo);

        assertEquals(1, hymiopeli.getMuutetutHahmot().size());
    }

    @Test
    public void muutuToimiiTiikeriKissa() {

        Hahmo hahmo = new Kissa(20, 20);
        hymiopeli.setHahmovalinta(2);
        hymiopeli.muutu(hahmo);

        assertEquals(1, hymiopeli.getMuutetutHahmot().size());
    }

    @Test
    public void muutuToimiiIronManKillian() {

        Hahmo hahmo = new Killian(20, 20);
        hymiopeli.setHahmovalinta(3);
        hymiopeli.muutu(hahmo);

        assertEquals(1, hymiopeli.getMuutetutHahmot().size());
    }

    @Test
    public void muutuToimiiHgetX() {

        Hahmo hahmo = new Surullinen(20, 20);
        hymiopeli.setHahmovalinta(1);
        hymiopeli.muutu(hahmo);

        assertEquals(20, hymiopeli.getMuutetutHahmot().get(0).getX());
    }

    @Test
    public void muutuToimiiTgetX() {

        Hahmo hahmo = new Kissa(20, 20);
        hymiopeli.setHahmovalinta(2);
        hymiopeli.muutu(hahmo);

        assertEquals(20, hymiopeli.getMuutetutHahmot().get(0).getX());
    }

    @Test
    public void muutuToimiiIgetX() {

        Hahmo hahmo = new Killian(20, 20);
        hymiopeli.setHahmovalinta(3);
        hymiopeli.muutu(hahmo);

        assertEquals(20, hymiopeli.getMuutetutHahmot().get(0).getX());
    }

    @Test
    public void muutuToimiiHgetY() {

        Hahmo hahmo = new Surullinen(20, 20);
        hymiopeli.setHahmovalinta(1);
        hymiopeli.muutu(hahmo);

        assertEquals(20, hymiopeli.getMuutetutHahmot().get(0).getY());
    }

    @Test
    public void muutuToimiiTgetY() {

        Hahmo hahmo = new Kissa(20, 20);
        hymiopeli.setHahmovalinta(2);
        hymiopeli.muutu(hahmo);

        assertEquals(20, hymiopeli.getMuutetutHahmot().get(0).getY());
    }

    @Test
    public void muutuToimiiIgetY() {

        Hahmo hahmo = new Killian(20, 20);
        hymiopeli.setHahmovalinta(3);
        hymiopeli.muutu(hahmo);
        assertEquals(20, hymiopeli.getMuutetutHahmot().get(0).getY());
    }

    @Test
    public void getHahmovalintaToimii() {

        hymiopeli.setHahmovalinta(3);
        assertEquals(3, hymiopeli.getHahmovalinta());
    }

    @Test
    public void getHahmovalintaToimii2() {

        hymiopeli.setHahmovalinta(2);
        assertEquals(2, hymiopeli.getHahmovalinta());
    }

    @Test
    public void getHahmovalintaToimii1() {

        hymiopeli.setHahmovalinta(1);
        assertEquals(1, hymiopeli.getHahmovalinta());
    }

}
