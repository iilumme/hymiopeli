/**
 * Alusta,joka piirtää hahmot.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Piirtoalusta extends JPanel {

    private final HymioPeli hymiopeli;

    public Piirtoalusta(HymioPeli hymiopeli) {
        super.setBackground(new Color(253, 243, 218));
        super.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        super.setSize(600, 475);
        this.hymiopeli = hymiopeli;
    }

    /**
     * Piirtää hahmot.
     *
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Hahmo hahmo : hymiopeli.getHahmot()) {
            hahmo.piirra(g);
        }
        for (Hahmo hahmo : hymiopeli.getMuutetutHahmot()) {
            hahmo.piirra(g);
        }
    }
    
    /**
     * Päivittää alustan.
     */

    public void paivita() {
        super.repaint();
    }

}
