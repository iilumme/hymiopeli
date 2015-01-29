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

    private int leveys;
    private int korkeus;
    private int taso;
    private boolean jatkuukoPeli;

    private Pelaaja pelaaja;
    private ArrayList<Hahmo> hahmot;
    private Piirtoalusta piirtoalusta;

    public HymioPeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.taso = 1;
        this.jatkuukoPeli = true;

        this.hahmot = new ArrayList<>();
        this.piirtoalusta = new Piirtoalusta(this);

        addActionListener(this);
        setInitialDelay(1000);
    }

    public void lisaaHahmot(int hahmovalinta) {

        int vastustenmaara = 40;

        if (hahmovalinta == 1) {

            pelaaja = new Hymio();
            this.hahmot.add(pelaaja);

            for (int i = 0; i < vastustenmaara; i++) {
                Random random = new Random();
                int luku = random.nextInt(korkeus + 1);
                this.hahmot.add(new Surullinen(leveys + 50, luku));
            }

        } else if (hahmovalinta == 2) {
            
            pelaaja = new Tiikeri();
            this.hahmot.add(pelaaja);

            for (int i = 0; i < vastustenmaara; i++) {
                Random random = new Random();
                int luku = random.nextInt(korkeus + 1);
                this.hahmot.add(new Kissa(leveys + 50, luku));
            }
        } else if (hahmovalinta == 3) {
            
            pelaaja = new IronMan();
            this.hahmot.add(pelaaja);

            for (int i = 0; i < vastustenmaara; i++) {
                Random random = new Random();
                int luku = random.nextInt(korkeus + 1);
                this.hahmot.add(new Killian(leveys + 50, luku));
            }
        }        

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

    public int hyvistenMaara() {
        int maara = 0;

        for (Hahmo hahmo : hahmot) {
            if (hahmo instanceof Pelaaja) {
                maara++;
            }
        }

        return maara;
    }

    public int vastustenMaara() {

        return getVastukset().size();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jatkuukoPeli) {
            return;

        } else {
            for (Hahmo hahmo : getVastukset()) {
                hahmo.siirra(-3, 0);
            }

            piirtoalusta.paivita();
        }
    }

}
