package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {

    private HymioPeli hymiopeli;

    public Piirtoalusta(HymioPeli hymiopeli) {
        this.hymiopeli = hymiopeli;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Hahmo hahmo : hymiopeli.getHahmot()) {
            hahmo.piirra(g);
        }
    }
    
    public void paivita() {
        super.repaint();
    }

}
