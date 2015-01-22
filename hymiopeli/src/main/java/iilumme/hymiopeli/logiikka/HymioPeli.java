package iilumme.hymiopeli.logiikka;


import iilumme.hymiopeli.pelihahmot.*;
import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class HymioPeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuukoPeli;
    
    private ArrayList<Hahmo> hahmot;

    public HymioPeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuukoPeli = true;
        
        this.hahmot = new ArrayList<>();

        addActionListener(this);
        setInitialDelay(1000);
    }

    public ArrayList<Hahmo> getHahmot() {
        return hahmot;
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
    
    public int pahistenMaara() {
        
        int maara = 0;
        
        for (Hahmo hahmo : hahmot) {
            if (hahmo instanceof Vastus) {
                maara--;
            }
        }
        
        return maara;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
