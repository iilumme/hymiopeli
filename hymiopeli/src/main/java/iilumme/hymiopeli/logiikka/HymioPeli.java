/**
 * HymioPeli on koko pelin aivot. Luokka luo hahmot, antaa ne käytettäväksi,
 * liikuttaa niitä ja tulee mahdollisesti huolehtimaan pisteidenlaskusta.
 */
package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.pelihahmot.*;
import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Vastus;
import iilumme.hymiopeli.pelihahmot.pelaajat.*;
import iilumme.hymiopeli.pelihahmot.vastustajat.*;
import iilumme.hymiopeli.ui.PaneelienKasittelija;
import iilumme.hymiopeli.ui.Piirtoalusta;
import iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.AbstractAction;
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
    private int jaljella;

    private boolean jatkuukoPeli;
    private boolean tasoMuuttui;

    private Pelaaja pelaaja;
    private PaneelienKasittelija pK;
    private NappaimistonKuuntelija nK;

    private ArrayList<Hahmo> hahmot;
    private ArrayList<Hahmo> muutetutHahmot;

    private Piirtoalusta p;

    public HymioPeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.hahmovalinta = -1;

        this.taso = 1;
        this.pisteet = 0;

        this.jatkuukoPeli = true;
        this.tasoMuuttui = false;

        this.pelaaja = new Hymio();
        this.hahmot = new ArrayList<>();
        this.muutetutHahmot = new ArrayList<>();

        addActionListener(this);
        setInitialDelay(200);
    }

    //getterit
    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getTaso() {
        return taso;
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

    public int getPiirrettavienVastustenmaara() {
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

    public int getHahmovalinta() {
        return hahmovalinta;
    }

    public void setHahmovalinta(int hahmovalinta) {
        this.hahmovalinta = hahmovalinta;
    }

    public ArrayList<Hahmo> getHahmot() {
        return hahmot;
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
        return muutetutHahmot;
    }

    /**
     * Tarkistetaan onko HymiöPelille asetettu Piirtoalusta
     *
     * @return true tai false
     */
    public boolean onkoPiirtoalustaAsennettu() {
        return p != null;
    }

    public void setTaso(int taso) {
        this.taso = taso;
    }

    /**
     * Taso muuttuu ja tulevaisuudessa tulee myös kasvattamaan nopeutta ja
     * väehntämään luotavien hahmojen määrää.
     */
    public void kasvataTasoa() {
        this.taso++;
    }

    /**
     * Asetetaan Piirtoalusta HymioPelille.
     *
     * @param p
     */
    public void setPiirtoalusta(Piirtoalusta p) {
        this.p = p;
    }

    public void setNappaimistonKuuntelija(NappaimistonKuuntelija nK) {
        this.nK = nK;
    }

    /**
     * Asetetaan PaneelienKasittelija HymioPelille.
     *
     * @param p
     */
    public void setPaneelienKasittelija(PaneelienKasittelija p) {
        this.pK = p;
    }

    /**
     * Luodaan hahmot pelille, lisätään ne ArrayList:aan.
     */
    public void lisaaHahmot() {

        vastustenmaara = 40 - (taso * 2);
        muutettavana = (int) Math.round(vastustenmaara * (3.0 / 5.0));

        switch (hahmovalinta) {
            case 1:
                hymioVSsurullset(vastustenmaara);
                break;
            case 2:
                tiikeriVSkissat(vastustenmaara);
                break;
            case 3:
                ironmanVSkillian(vastustenmaara);
                break;
        }
    }

    private void hymioVSsurullset(int vastustenmaara) {
        pelaaja = new Hymio();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            Random ran = new Random();
            int kor = ran.nextInt(450 + 1);
            int lev = ran.nextInt(300);
            this.hahmot.add(new Surullinen(leveys + lev, kor));
        }
    }

    private void tiikeriVSkissat(int vastustenmaara) {
        pelaaja = new Tiikeri();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            Random ran = new Random();
            int kor = ran.nextInt(450 + 1);
            int lev = ran.nextInt(300);
            this.hahmot.add(new Kissa(leveys + lev, kor));
        }
    }

    private void ironmanVSkillian(int vastustenmaara) {
        pelaaja = new IronMan();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            Random ran = new Random();
            int kor = ran.nextInt(450 + 1);
            int lev = ran.nextInt(300);
            this.hahmot.add(new Killian(leveys + lev, kor));
        }
    }

    /**
     * Lasketaan kuinka paljon "hyviksiä" eli pelaaja-olioita on.
     *
     * @return pelaajien määrä
     */
    public int getHyvistenMaara() {
        return muutetutHahmot.size();
    }

    /**
     * Lasketaan kuinka paljon vastus-olioita on.
     *
     * @return vastusten määrä
     */
    public int getVastustenMaara() {

        return getVastukset().size();
    }

    /**
     * Liikutetaan vastuksia ja päivitetään piirtoalustaa.
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

            for (Hahmo hahmo : getVastukset()) {
                hahmo.siirra(-5, 0);

                if (getPelaaja().getRajat().intersects(hahmo.getRajat())) {
                    pisteet += 5;
                    muutu(hahmo);
                }

                jaljella = muutettavana - muutetutHahmot.size();

                if (muutetutHahmot.size() >= muutettavana) {
                    jatkuukoPeli = false;
                    tasoMuuttui = true;
                    kasvataTasoa();
                    break;
                }

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

            p.paivita();
            //nK.paivita();

            pK.getTietoPaneeli().paivita();

            setDelay(200 - taso * 20);
        }
    }

    private void tasoMuuttui() {

        p.setVisible(false);

        JOptionPane optionPane = new JOptionPane(KieliUtil.getString("tasonvaihdos") + " " + taso, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialogi = new JDialog();
        dialogi.setTitle(KieliUtil.getString("tasomuuttui"));
        dialogi.setModal(true);
        dialogi.setContentPane(optionPane);
        dialogi.setLocation(170, 270);
        dialogi.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogi.pack();

        Timer aika = new Timer(2700, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialogi.dispose();
            }
        });
        aika.setRepeats(false);
        aika.start();
        dialogi.setVisible(true);

        stop();
        this.muutetutHahmot.clear();
        this.hahmot.clear();
        lisaaHahmot();
        jatkuukoPeli = true;
        tasoMuuttui = false;
        start();
        p.setVisible(true);

    }

    private void peliLoppui() throws HeadlessException {
        stop();
        highscore();
        p.setVisible(false);
        pK.getValikkoPaneeli().asetaNakyviin();
        this.muutetutHahmot.clear();
        this.hahmot.clear();
        jatkuukoPeli = true;
        setTaso(1);
        setPisteet(0);
    }

    private void highscore() throws HeadlessException {

        String[] options = {"OK"};
        JPanel panel = new JPanel();
        JLabel label = new JLabel(KieliUtil.getString("annanimi"));
        JTextField name = new JTextField(10);
        panel.add(label);
        panel.add(name);
        int selectedOption = JOptionPane.showOptionDialog(pK.getLiittyma().getFrame(), panel, KieliUtil.getString("highscorelistalle"), JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (selectedOption == 0) {
            String nimi = name.getText();
            if (nimi.length() == 0) {
                pK.getHst().lisaaHighscore(KieliUtil.getString("pelaaja"), this.pisteet);
            } else {
                pK.getHst().lisaaHighscore(nimi, this.pisteet);
            }
            pK.getHst().paivitaLista();

        }

//        String nimi = JOptionPane.showInputDialog(
//                pK.getLiittyma().getFrame(),
//                KieliUtil.getString("annanimi"),
//                KieliUtil.getString("highscorelistalle"),
//                JOptionPane.PLAIN_MESSAGE
//        );
//
//        if (nimi.length() == 0) {
//            pK.getHst().lisaaHighscore(KieliUtil.getString("pelaaja"), this.pisteet);
//        } else {
//            pK.getHst().lisaaHighscore(nimi, this.pisteet);
//        }
//        pK.getHst().paivitaLista();
    }

    /**
     * Muuttaa parametrinä annetun hahmon "vastaavaksi" pelaajahahmoksi.
     *
     * @param hahmo
     */
    public void muutu(Hahmo hahmo) {

        int x = hahmo.getX();
        int y = hahmo.getY();

        switch (hahmovalinta) {
            case 1:
                Hymio hymio = new Hymio();
                hymio.setXY(x, y);
                this.muutetutHahmot.add(hymio);
                break;
            case 2:
                Tiikeri tikru = new Tiikeri();
                tikru.setXY(x, y);
                this.muutetutHahmot.add(tikru);
                break;
            case 3:
                IronMan iron = new IronMan();
                iron.setXY(x, y);
                this.muutetutHahmot.add(iron);
                break;
        }

        this.hahmot.remove(hahmo);
    }

}
