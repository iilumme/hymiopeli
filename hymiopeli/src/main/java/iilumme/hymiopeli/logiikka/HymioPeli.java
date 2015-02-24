/**
 * HymioPeli on Hymiöpelin aivot. Luokka luo hahmot, antaa ne käytettäväksi,
 * liikuttaa niitä, vaihtaa niiden muotoa ja huolehtii pisteidenlaskusta.
 */
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
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

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

    private Pelaaja pelaaja;
    private PaneelienKasittelija pK;
    private NappaimistonKuuntelija nK;

    private final ArrayList<Hahmo> hahmot;
    private final ArrayList<Hahmo> muutetutHahmot;

    private Piirtoalusta p;

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

        this.pelaaja = new Hymio();
        this.hahmot = new ArrayList<>();
        this.muutetutHahmot = new ArrayList<>();

        addActionListener(this);
        setInitialDelay(200);
    }

    //Get Set
    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getHahmovalinta() {
        return hahmovalinta;
    }

    public void setHahmovalinta(int hahmovalinta) {
        this.hahmovalinta = hahmovalinta;
    }

    public int getTaso() {
        return taso;
    }

    public void setTaso(int taso) {
        if (taso >= 0) {
            this.taso = taso;
        } else {
            this.taso = 0;
        }
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        if (pisteet >= 0) {
            this.pisteet = pisteet;
        } else {
            this.pisteet = 0;
        }
    }

    public int getMuutetut() {
        return muutetut;
    }

    public void setMuutetut(int muutetut) {
        if (muutetut >= 0) {
            this.muutetut = muutetut;
        } else {
            this.muutetut = 0;
        }
    }

    public void setJatkuukoPeli(boolean jatkuukoPeli) {
        this.jatkuukoPeli = jatkuukoPeli;
    }

    public int getVastustenmaara() {
        return vastustenmaara;
    }

    public int getMuutettavana() {
        return muutettavana;
    }

    public int getJaljella() {
        return jaljella;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public ArrayList<Hahmo> getHahmot() {
        return this.hahmot;
    }

    public ArrayList<Hahmo> getVastukset() {
        ArrayList<Hahmo> vastukset = new ArrayList<>();

        for (Hahmo hahmo : hahmot) {
            if (hahmo instanceof Vastus) {
                vastukset.add(hahmo);
            }
        }

        return vastukset;
    }

    public ArrayList<Hahmo> getMuutetutHahmot() {
        return this.muutetutHahmot;
    }

    /**
     * Laskee kuinka monta pelaaja-oliota pelissä on.
     *
     * @return pelaajien määrä
     */
    public int getHyvistenMaara() {
        return this.muutetut;
    }

    /**
     * Tarkistaa onko HymioPelille asetettu Piirtoalusta.
     *
     * @return true/false
     */
    public boolean onkoPiirtoalustaAsennettu() {
        return this.p != null;
    }

    /**
     * Kasvattaa tasoa yhdellä.
     */
    public void kasvataTasoa() {
        this.taso++;
    }

    public void setPiirtoalusta(Piirtoalusta a) {
        this.p = a;
    }

    public void setNappaimistonKuuntelija(NappaimistonKuuntelija n) {
        this.nK = n;
    }

    public void setPaneelienKasittelija(PaneelienKasittelija p) {
        this.pK = p;
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

                pelaajaOsuu(hahmo);
                jaljella = muutettavana - muutetut;
                if (vaihtuukoTaso()) {
                    break;
                }
                onkoVastuksetUlkona();
            }

            p.paivita();
            nK.paivita();
            pK.getTietoPaneeli().paivita();
            setDelay(200);
        }
    }

    private void pelaajaOsuu(Hahmo hahmo) {
        if (getPelaaja().getRajat().intersects(hahmo.getRajat())) {
            pisteet += 5;
            muutu(hahmo);
        }
    }

    /**
     * Muuttaa parametrinä annetun hahmon "vastaavaksi" pelaajahahmoksi. Poistaa
     * aikaisemmin muutettuja hahmoja.
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
                break;
            case 2:
                Tiikeri tikru = new Tiikeri();
                tikru.setXY(x, y);
                this.muutetutHahmot.add(tikru);
                tikru.muutaVari();
                break;
            case 3:
                IronMan iron = new IronMan();
                iron.setXY(x, y);
                this.muutetutHahmot.add(iron);
                iron.muutaVari();
                break;
        }
        
        this.muutetut++;

        this.hahmot.remove(hahmo);
        if (muutetut > 1) {
            muutetutHahmot.remove(0);
        }
    }

    private void onkoVastuksetUlkona() {
        boolean vastuksetUlkona = true;

        for (Hahmo h : getVastukset()) {
            if (h.getX() + 55 > 0) {
                vastuksetUlkona = false;
                break;
            }
        }

        if (vastuksetUlkona) {
            jatkuukoPeli = false;
        }
    }

    //Tasoihin liittyvät metodit
    private boolean vaihtuukoTaso() {
        if (muutetut >= muutettavana) {
            jatkuukoPeli = false;
            tasoMuuttui = true;            
            kasvataTasoa();
            nK.setKerroinMuutettu(false);
            return true;
        }
        return false;
    }

    private void tasoMuuttui() {

        p.setVisible(false);
        tasoMessage();
        stop();
        this.muutetutHahmot.clear();
        this.muutetut = 0;
        this.hahmot.clear();
        lisaaHahmot();
        nK.asetaFalse();
        jatkuukoPeli = true;
        tasoMuuttui = false;
        start();
        p.setVisible(true);

    }

    private void tasoMessage() {

        JOptionPane optionPane = new JOptionPane(KieliUtil.getString("tasonvaihdos") + " " + taso, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialogi = new JDialog();
        dialogi.setTitle(KieliUtil.getString("tasomuuttui"));
        dialogi.setModal(true);
        dialogi.setContentPane(optionPane);
        dialogi.setLocation(170, 270);
        dialogi.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogi.pack();

        Timer aika = new Timer(2500, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialogi.dispose();
            }
        });
        aika.setRepeats(false);
        aika.start();
        dialogi.setVisible(true);
    }

    //Pelin loppumiseen liittyvät metodit
    private void peliLoppui() throws HeadlessException {
        stop();
        highscore();
        p.setVisible(false);
        pK.getValikkoPaneeli().asetaNakyviin();
        this.muutetutHahmot.clear();
        this.muutetut = 0;
        this.hahmot.clear();
        setTaso(1);
        setPisteet(0);
        nK.asetaFalse();
        jatkuukoPeli = true;

    }

    private void highscore() throws HeadlessException {

        String[] options = {"OK"};
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        JLabel label = new JLabel(KieliUtil.getString("annanimi"));
        JTextField name = new JTextField(10);
        panel.add(label);
        panel.add(name);

        int valinta = JOptionPane.showOptionDialog(pK.getLiittyma().getFrame(), panel, KieliUtil.getString("highscorelistalle"), JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(ClassLoader.getSystemResource("Images/gameo.png")), options, options[0]);

        if (valinta == 0) {
            String nimi = name.getText();
            if (nimi.length() == 0) {
                pK.getHst().lisaaHighscore(KieliUtil.getString("pelaaja"), this.pisteet);
            } else {
                pK.getHst().lisaaHighscore(nimi, this.pisteet);
            }
            pK.getHst().paivitaLista();
        }
    }

}
