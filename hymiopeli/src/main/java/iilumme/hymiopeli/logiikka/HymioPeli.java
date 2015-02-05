/**
 * HymioPeli on koko pelin aivot.
 * Luokka luo hahmot, antaa ne käytettäväksi, liikuttaa niitä 
 * ja tulee mahdollisesti huolehtimaan pisteidenlaskusta.
 */

package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.pelihahmot.*;
import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Vastus;
import iilumme.hymiopeli.pelihahmot.pelaajat.Hymio;
import iilumme.hymiopeli.pelihahmot.pelaajat.IronMan;
import iilumme.hymiopeli.pelihahmot.pelaajat.Tiikeri;
import iilumme.hymiopeli.pelihahmot.vastustajat.Killian;
import iilumme.hymiopeli.pelihahmot.vastustajat.Kissa;
import iilumme.hymiopeli.pelihahmot.vastustajat.Surullinen;
import iilumme.hymiopeli.ui.Piirtoalusta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class HymioPeli extends Timer implements ActionListener {

    private final int leveys;
    private final int korkeus;
    private int taso;
    private boolean jatkuukoPeli;

    private Pelaaja pelaaja;
    private ArrayList<Hahmo> hahmot;
    private Piirtoalusta p;
    private Random random;

    public HymioPeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.taso = 1;
        this.jatkuukoPeli = true;

        this.hahmot = new ArrayList<>();
        this.random = new Random();

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

    public Pelaaja getPelaaja() {
        return pelaaja;
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
    
    /**
     * Tarkistetaan onko HymiöPelille asetettu Piirtoalusta
     * 
     * @return true tai false
     */

    public boolean onkoPiirtoalustaAsennettu() {
        return p != null;
    }
    
    /**
     * Taso muuttuu ja tulevaisuudessa tulee myös kasvattamaan nopeutta ja väehntämään luotavien hahmojen määrää.
     */

    public void kasvataTasoa() {
        this.taso++;
    }
    
    /**
     * Asetetaan Piirtoalusta HymioPelille.
     */

    public void setPiirtoalusta(Piirtoalusta p) {
        this.p = p;
    }

    /**
     * Luodaan hahmot pelille, lisätään ne ArrayList:aan.
     * 
     * @param hahmovalinta Käyttäjän tekemä valinta, millä hahmoilla haluaa pelata
     */
    public void lisaaHahmot(int hahmovalinta) {

        int vastustenmaara = 20;

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
            int kor = random.nextInt(korkeus + 1);
            int lev = random.nextInt(300);
            this.hahmot.add(new Surullinen(leveys + lev, kor));
        }
    }

    private void tiikeriVSkissat(int vastustenmaara) {
        pelaaja = new Tiikeri();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            int kor = random.nextInt(korkeus + 1);
            int lev = random.nextInt(300);
            this.hahmot.add(new Kissa(leveys + lev, kor));
        }
    }

    private void ironmanVSkillian(int vastustenmaara) {
        pelaaja = new IronMan();
        this.hahmot.add(pelaaja);

        for (int i = 0; i < vastustenmaara; i++) {
            int kor = random.nextInt(korkeus + 1);
            int lev = random.nextInt(300);
            this.hahmot.add(new Killian(leveys + lev, kor));
        }
    }

    /**
     * Lasketaan kuinka paljon "hyviksiä" eli pelaaja-olioita on.
     * @return pelaajien määrä
     */
    public int hyvistenMaara() {
        int maara = 0;

        for (Hahmo hahmo : hahmot) {
            if (hahmo instanceof Pelaaja) {
                maara++;
            }
        }

        return maara;
    }
    
    /**
     * Lasketaan kuinka paljon vastus-olioita on.
     * @return vastusten määrä
     */
    public int vastustenMaara() {

        return getVastukset().size();
    }

    /**
     * Liikutetaan vastuksia ja päivitetään piirtoalustaa.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jatkuukoPeli) {
            return;

        } else {
            for (Hahmo hahmo : getVastukset()) {
                hahmo.siirra(-5, 0);
            }

            p.paivita();
            setDelay(10);
        }
    }

}
