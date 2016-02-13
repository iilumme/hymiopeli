package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Alusta, joka piirtää hahmot.
 */
public class Piirtoalusta extends JPanel {

    private final HymioPeli hymiopeli;

    public Piirtoalusta(HymioPeli hymiopeli) {
        super.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        super.setSize(600, 475);
        this.hymiopeli = hymiopeli;
    }

    /**
     * Piirtää hahmot.
     *
     * @param g Graphics
     * 
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getHahmot()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getMuutetutHahmot()
     * @see iilumme.hymiopeli.pelihahmot.Hahmo#piirra(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image tausta = null;
        try {
            tausta = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource("Images/tausta.png"), "tausta.png"));
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g.drawImage(tausta, 0, 0, null);

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
