package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.pelihahmot.vastukset.Surullinen;
import iilumme.hymiopeli.pelihahmot.vastukset.Killian;
import iilumme.hymiopeli.pelihahmot.vastukset.Kissa;
import iilumme.hymiopeli.pelihahmot.*;
import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Vastus;
import iilumme.hymiopeli.pelihahmot.pelaajat.*;
import iilumme.hymiopeli.ui.*;
import iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 * HymioPeli on Hymiöpelin aivot. Luokka mm. luo hahmot, antaa ne käytettäväksi,
 * liikuttaa niitä, vaihtaa niiden muotoa ja huolehtii pisteidenlaskusta.
 */
public class HymioPeli extends Timer implements ActionListener {

    private final int leveys;
    private final int korkeus;

    private int hahmovalinta;
    private int taso;
    private int pisteet;

    private int vastustenmaara;
    private int muutettavana;
    private int muutetut;
    private int jaljella;

    private boolean jatkuukoPeli;
    private boolean tasoMuuttui;
    private boolean maaraSaavutettu;

    private Pelaaja pelaaja;
    private Apuri apuri;
    private NappaimistonKuuntelija nappaimistonKuuntelija;

    private final ArrayList<Hahmo> hahmot;
    private final ArrayList<Pelaaja> muutetutHahmot;

    private Piirtoalusta piirtoalusta;

    public HymioPeli(int leveys, int korkeus) {
        super(200, null);

        this.leveys = leveys;
        this.korkeus = korkeus;

        this.hahmovalinta = -1;
        this.taso = 1;
        this.pisteet = 0;
        this.muutetut = 0;

        this.jatkuukoPeli = true;
        this.tasoMuuttui = false;
        this.maaraSaavutettu = false;

        this.pelaaja = new Hymio();
        this.hahmot = new ArrayList<>();
        this.muutetutHahmot = new ArrayList<>();

        addActionListener(this);
        setInitialDelay(200);
    }

    //Hahmovalinta
    public int getHahmovalinta() {
        return hahmovalinta;
    }

    public void setHahmovalinta(int hahmovalinta) {
        this.hahmovalinta = hahmovalinta;
    }

    //Taso
    public int getTaso() {
        return taso;
    }

    public void setTaso(int taso) {
        if (taso >= 0) {
            this.taso = taso;
        }
    }

    //Pisteet
    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        if (pisteet >= 0) {
            this.pisteet = pisteet;
        }
    }

    //Muutetut
    public int getMuutetut() {
        return muutetut;
    }

    public void setMuutetut(int muutetut) {
        if (muutetut >= 0) {
            this.muutetut = muutetut;
        }
    }

    //JatkuukoPeli
    public boolean getJatkuukoPeli() {
        return jatkuukoPeli;
    }

    public void setJatkuukoPeli(boolean jatkuukoPeli) {
        this.jatkuukoPeli = jatkuukoPeli;
    }

    //TasoMuuttui
//    public boolean getTasoMuuttui() {
//        return tasoMuuttui;
//    }
    public void setTasoMuuttui(boolean tasoMuuttui) {
        this.tasoMuuttui = tasoMuuttui;
    }

    //Vastustenmaara
    public int getVastustenmaara() {
        return vastustenmaara;
    }

    //Muutettavana
    public int getMuutettavana() {
        return muutettavana;
    }

    //Jaljella
    public int getJaljella() {
        return jaljella;
    }

    //maaraSaavutettu
    public boolean getMaaraSaavutettu() {
        return maaraSaavutettu;
    }

    //Pelaaja
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    //Kaikki hahmot
    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    //Vain vastukset
    public ArrayList<Hahmo> getVastukset() {
        ArrayList<Hahmo> vastukset = new ArrayList<>();

        for (Hahmo hahmo : hahmot) {
            if (hahmo instanceof Vastus) {
                vastukset.add(hahmo);
            }
        }

        return vastukset;
    }

    //Muutetut Hahmot
    public ArrayList<Pelaaja> getMuutetutHahmot() {
        return this.muutetutHahmot;
    }

    //Piirtoalusta
    public void setPiirtoalusta(Piirtoalusta a) {
        this.piirtoalusta = a;
    }

    public boolean onkoPiirtoalustaAsennettu() {
        return this.piirtoalusta != null;
    }

    //NappaimistonKuuntelija
    public void setNappaimistonKuuntelija(NappaimistonKuuntelija n) {
        this.nappaimistonKuuntelija = n;
    }

    public boolean onkoNappaimistonKuuntelijaAsennettu() {
        return this.nappaimistonKuuntelija != null;
    }

    //Apuri
    public void setApuri(Apuri a) {
        this.apuri = a;
    }

    public boolean onkoApuriAsennettu() {
        return this.apuri != null;
    }

    /**
     * Kasvattaa tasoa yhdellä.
     */
    public void kasvataTasoa() {
        this.taso++;
    }

    /**
     * Luo hahmot pelille ja lisää ne HymioPelin listaan.
     */
    public void lisaaHahmot() {

        vastustenmaara = 40 - (taso * 2);

        if (vastustenmaara < 6) {
            vastustenmaara = 6;
        }

        muutettavana = (int) Math.round(vastustenmaara * (3.0 / 5.0));

        switch (hahmovalinta) {
            case 1:
                hymioVSsurullset();
                break;
            case 2:
                tiikeriVSkissat();
                break;
            case 3:
                ironmanVSkillian();
                break;
        }
    }

    private void hymioVSsurullset() {
        pelaaja = new Hymio();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            Random ran = new Random();
            int kor = ran.nextInt(410 + 1);
            int lev = ran.nextInt(1000);
            this.hahmot.add(new Surullinen(leveys + lev, kor));
        }
    }

    private void tiikeriVSkissat() {
        pelaaja = new Tiikeri();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            Random ran = new Random();
            int kor = ran.nextInt(410 + 1);
            int lev = ran.nextInt(1000);
            this.hahmot.add(new Kissa(leveys + lev, kor));
        }
    }

    private void ironmanVSkillian() {
        pelaaja = new IronMan();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            Random ran = new Random();
            int kor = ran.nextInt(410 + 1);
            int lev = ran.nextInt(1000);
            this.hahmot.add(new Killian(leveys + lev, kor));
        }
    }

    /**
     * Liikuttaa vastuksia ja päivittää piirtoalustaa, pelihahmon sijaintia ja
     * TietoPaneelin lukuja.
     *
     * @param e
     * @see iilumme.hymiopeli.pelihahmot.Hahmo#siirra(int, int)
     * @see iilumme.hymiopeli.pelihahmot.Hahmo#getRajat()
     * @see iilumme.hymiopeli.pelihahmot.Hahmo#setXY(int, int)
     * @see iilumme.hymiopeli.pelihahmot.Pelaaja#muutaVari()
     * @see iilumme.hymiopeli.pelihahmot.Pelaaja#setMuutettu(boolean)
     * @see iilumme.hymiopeli.ui.Piirtoalusta#paivita()
     * @see iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija#paivita()
     * @see iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija#setKerroinMuutettu(boolean)
     * @see iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija#asetaFalse()
     * @see iilumme.hymiopeli.ui.Apuri#getTietoPaneeli()
     * @see iilumme.hymiopeli.ui.Apuri#getViestiapuri()
     * @see iilumme.hymiopeli.ui.Apuri#getValikkoPaneeli()
     * @see iilumme.hymiopeli.ui.TietoPanel#paivita()
     * @see iilumme.hymiopeli.ui.TietoPanel#asetaPois()
     * @see iilumme.hymiopeli.ui.ViestiApuri#tasonVaihtumisJOptionPane()
     * @see iilumme.hymiopeli.ui.ViestiApuri#highScoreLisaysJOptionPane()
     * @see iilumme.hymiopeli.ui.ValikkoPanel#asetaNakyviin()
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jatkuukoPeli) {

            if (tasoMuuttui) {
                tasoMuuttui();
            } else {
                peliLoppui();
            }

        } else {

            int kerroin = taso / 2;
            if (taso == 1) {
                kerroin = 1;
            }

            for (Hahmo hahmo : getVastukset()) {
                hahmo.siirra(-5 * kerroin, 0);

                pelaajaVastaanVastusTarkistukset(hahmo);
            }

            for (Hahmo hahmo : this.muutetutHahmot) {
                hahmo.siirra(-5 * kerroin, 0);
            }

            paivita();
            setDelay(200);
        }
    }

    private void pelaajaVastaanVastusTarkistukset(Hahmo hahmo) {
        pelaajaOsuu(hahmo);
        jaljella = muutettavana - muutetut;
        onkoMaaraSaavutettu();
        vaihtuukoTasoVaiLoppuukoPeli();
    }

    private void pelaajaOsuu(Hahmo hahmo) {
        if (getPelaaja().getRajat().intersects(hahmo.getRajat())) {
            if (maaraSaavutettu) {
                pisteet += 4;
            } else {
                pisteet += 2;
            }
            muutu(hahmo);
        }
    }

    /**
     * Muuttaa parametrinä annetun hahmon "vastaavaksi" pelaajahahmoksi.
     *
     * @param hahmo muutettava hahmo
     */
    public void muutu(Hahmo hahmo) {

        int x = hahmo.getX();
        int y = hahmo.getY();

        switch (hahmovalinta) {
            case 1:
                Hymio hymio = new Hymio();
                hymio.setXY(x, y);
                this.muutetutHahmot.add(hymio);
                hymio.muutaVari();
                hymio.setMuutettu(true);
                break;
            case 2:
                Tiikeri tikru = new Tiikeri();
                tikru.setXY(x, y);
                this.muutetutHahmot.add(tikru);
                tikru.muutaVari();
                tikru.setMuutettu(true);
                break;
            case 3:
                IronMan iron = new IronMan();
                iron.setXY(x, y);
                this.muutetutHahmot.add(iron);
                iron.muutaVari();
                iron.setMuutettu(true);
                break;
        }

        this.muutetut++;

        this.hahmot.remove(hahmo);
    }

    private void paivita() {
        piirtoalusta.paivita();
        nappaimistonKuuntelija.paivita();
        apuri.getTietoPaneeli().paivita();
    }

    //Tasoihin liittyvät metodit
    private boolean onkoVastuksetUlkona() {
        boolean vastuksetUlkona = true;

        for (Hahmo h : getVastukset()) {
            if (h.getX() + 55 > 0) {
                vastuksetUlkona = false;
                break;
            }
        }
        return vastuksetUlkona;
    }

    private void onkoMaaraSaavutettu() {
        if (muutetut >= muutettavana) {
            maaraSaavutettu = true;
        }
    }

    private void tasoMuuttui() {

        //Näkyvyys, taso ja stop
        piirtoalusta.setVisible(false);
        nappaimistonKuuntelija.setKerroinMuutettu(false);
        nappaimistonKuuntelija.asetaFalse();
        kasvataTasoa();
        apuri.getViestiapuri().tasonVaihtumisJOptionPane();
        stop();

        //Hahmo-kontrolli
        this.muutetutHahmot.clear();
        this.muutetut = 0;
        this.hahmot.clear();
        lisaaHahmot();

        //Booleans
        jatkuukoPeli = true;
        tasoMuuttui = false;
        maaraSaavutettu = false;

        //Näkyvyys ja start
        piirtoalusta.setVisible(true);
        start();

    }

    private void vaihtuukoTasoVaiLoppuukoPeli() {
        if (maaraSaavutettu && onkoVastuksetUlkona()) {
            jatkuukoPeli = false;
            tasoMuuttui = true;
        } else if (!maaraSaavutettu && onkoVastuksetUlkona()) {
            jatkuukoPeli = false;
            tasoMuuttui = false;
        }
    }

    //Pelin loppumiseen liittyvä metodi
    private void peliLoppui() {

        //Näkyvyys, HighscoreKysely, Paneelit
        stop();
        apuri.getViestiapuri().highScoreLisaysJOptionPane();
        piirtoalusta.setVisible(false);
        nappaimistonKuuntelija.asetaFalse();
        apuri.getTietoPaneeli().asetaPois();
        apuri.getValikkoPaneeli().asetaNakyviin();

        //Hahmo-, taso- ja pistekontrolli
        this.muutetutHahmot.clear();
        this.muutetut = 0;
        this.hahmot.clear();
        setTaso(1);
        setPisteet(0);

        //Booleans
        jatkuukoPeli = true;
        maaraSaavutettu = false;
    }

}
