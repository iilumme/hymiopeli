/**
 * Alusta pelitilanteelle.
 * Piirtää hahmot.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {

    private HymioPeli hymiopeli;

    public Piirtoalusta(HymioPeli hymiopeli) {
        super.setBackground(new Color(0, 0, 110));
        this.hymiopeli = hymiopeli;
        this.hymiopeli.start();
    }

    /**
     * Piirtää hahmot.
     * @param g 
     */
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
