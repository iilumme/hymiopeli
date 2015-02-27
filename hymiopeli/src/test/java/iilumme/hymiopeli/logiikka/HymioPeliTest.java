package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.pelihahmot.Hahmo;
import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import iilumme.hymiopeli.pelihahmot.pelaajat.IronMan;
import iilumme.hymiopeli.pelihahmot.pelaajat.Tiikeri;
import iilumme.hymiopeli.pelihahmot.vastukset.Killian;
import iilumme.hymiopeli.pelihahmot.vastukset.Kissa;
import iilumme.hymiopeli.pelihahmot.vastukset.Surullinen;
import iilumme.hymiopeli.ui.Apuri;
import iilumme.hymiopeli.ui.Piirtoalusta;
import iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija;
import java.io.IOException;
import java.util.ArrayList;
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
        assertEquals(0, hymiopeli.getMuutetut());
    }

    @Test
    public void hymioitaYksi() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();

        assertEquals(1, hymiopeli.getMuutetut() + 1);
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
    public void surullisia38Alussa() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();
        assertEquals(38, hymiopeli.getVastustenmaara());
    }

    @Test
    public void kissoja38Alussa() {
        hymiopeli.setHahmovalinta(2);
        hymiopeli.lisaaHahmot();
        assertEquals(38, hymiopeli.getVastustenmaara());
    }

    @Test
    public void killianeja38Alussa() {
        hymiopeli.setHahmovalinta(3);
        hymiopeli.lisaaHahmot();
        assertEquals(38, hymiopeli.getVastustenmaara());
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
    public void piirtoalustaEIAsennettu() {

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
        assertEquals(200, hymiopeli.getDelay());
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

    @Test
    public void setPisteetToimii() {

        hymiopeli.setPisteet(40);
        assertEquals(40, hymiopeli.getPisteet());
    }

    @Test
    public void setPisteetToimiiNegLuku() {

        hymiopeli.setPisteet(-20);
        assertEquals(0, hymiopeli.getPisteet());
    }

    @Test
    public void setPisteetToimiiNollalla() {

        hymiopeli.setPisteet(0);
        assertEquals(0, hymiopeli.getPisteet());
    }

    @Test
    public void getPiirrettavienVastustenMaara() {

        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();
        assertEquals(38, hymiopeli.getVastustenmaara());
    }

    @Test
    public void getPiirrettavienVastustenMaara2() {

        hymiopeli.lisaaHahmot();
        assertEquals(38, hymiopeli.getVastustenmaara());
    }

    @Test
    public void getPiirrettavienVastustenMaara3() {

        assertEquals(0, hymiopeli.getVastustenmaara());
    }

    @Test
    public void getMuutettavana() {

        assertEquals(0, hymiopeli.getMuutettavana());
    }

    @Test
    public void getMuutettavana2() {

        hymiopeli.lisaaHahmot();
        assertEquals(23, hymiopeli.getMuutettavana());
    }

    @Test
    public void getJaljella() {

        assertEquals(0, hymiopeli.getJaljella());
    }

    @Test
    public void getJaljella2() {

        hymiopeli.lisaaHahmot();
        assertEquals(0, hymiopeli.getJaljella());
    }

    @Test
    public void setTasoToimiiPos() {

        hymiopeli.setTaso(6);
        assertEquals(6, hymiopeli.getTaso());
    }

    @Test
    public void setTasoToimiiNeg() {

        hymiopeli.setTaso(2);
        hymiopeli.setTaso(-7);
        assertEquals(2, hymiopeli.getTaso());
    }

    @Test
    public void getMuutetutToimii() {
        hymiopeli.lisaaHahmot();
        assertEquals(0, hymiopeli.getMuutetut());
    }

    @Test
    public void getMuutetutToimii2() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();

        ArrayList<Hahmo> vastukset = hymiopeli.getVastukset();
        for (Hahmo v : vastukset) {
            hymiopeli.muutu(v);
        }
        assertEquals(38, hymiopeli.getMuutetut());
    }

    @Test
    public void getMuutetutToimii3() {
        hymiopeli.setMuutetut(0);
        assertEquals(0, hymiopeli.getMuutetut());
    }

    @Test
    public void getMuutetutToimii4() {
        hymiopeli.setMuutetut(6);
        assertEquals(6, hymiopeli.getMuutetut());
    }

    @Test
    public void getMuutetutToimii5() {
        hymiopeli.setMuutetut(4);
        hymiopeli.setMuutetut(-1);
        assertEquals(4, hymiopeli.getMuutetut());
    }

    @Test
    public void getMuutetutToimii6() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.lisaaHahmot();

        ArrayList<Hahmo> vastukset = hymiopeli.getVastukset();
        for (int i = 0; i < 10; i++) {
            hymiopeli.muutu(vastukset.get(i));
        }
        assertEquals(10, hymiopeli.getMuutetut());
    }

    @Test
    public void setJatkuukoPeliToimii() {
        hymiopeli.setJatkuukoPeli(true);
        assertEquals(true, hymiopeli.getJatkuukoPeli());
    }

    @Test
    public void setJatkuukoPeliToimii2() {
        hymiopeli.setJatkuukoPeli(false);
        assertEquals(false, hymiopeli.getJatkuukoPeli());
    }

    @Test
    public void setJatkuukoPeliToimii3() {
        hymiopeli.setJatkuukoPeli(false);
        hymiopeli.setJatkuukoPeli(true);
        assertEquals(true, hymiopeli.getJatkuukoPeli());
    }

    @Test
    public void setNappaimistonKuuntelijaToimii() {
        assertEquals(false, hymiopeli.onkoNappaimistonKuuntelijaAsennettu());
    }

    @Test
    public void setNappaimistonKuuntelijaToimii2() {
        hymiopeli.setNappaimistonKuuntelija(new NappaimistonKuuntelija(hymiopeli, null));
        assertEquals(true, hymiopeli.onkoNappaimistonKuuntelijaAsennettu());
    }

    @Test
    public void setApuriToimii() {
        assertEquals(false, hymiopeli.onkoApuriAsennettu());
    }

    @Test
    public void setApuriToimii2() throws IOException {
        hymiopeli.setApuri(new Apuri(hymiopeli, null));

        assertEquals(true, hymiopeli.onkoApuriAsennettu());
    }

    @Test
    public void vastustenMaaraToimiiAlle6() {
        hymiopeli.setHahmovalinta(1);
        hymiopeli.setTaso(18);
        hymiopeli.lisaaHahmot();
        assertEquals(6, hymiopeli.getVastustenmaara());
    }

    @Test
    public void peliLoppuuToimii() {
        hymiopeli.start();
        hymiopeli.setJatkuukoPeli(false);

        assertEquals(0, hymiopeli.getPisteet());
        assertEquals(1, hymiopeli.getTaso());
    }
}
