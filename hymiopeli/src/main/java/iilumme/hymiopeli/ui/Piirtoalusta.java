/**
 * Alusta pelitilanteelle.
 * Piirtää hahmot.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Piirtoalusta extends JPanel {

    private HymioPeli hymiopeli;

    public Piirtoalusta(HymioPeli hymiopeli) {
        super.setBackground(new Color(253, 243, 218));
        super.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        this.hymiopeli = hymiopeli;
        //this.hymiopeli.start();
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
        for (Hahmo hahmo : hymiopeli.getMuutetutHahmot()) {
            hahmo.piirra(g);
        }
        
//        JLabel pisteet = new JLabel("Pisteet: " + hymiopeli.getPisteet());
//        add(pisteet);
    }

    public void paivita() {
        super.repaint();
    }

}
