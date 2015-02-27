package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Pelaajahahmo, jonka kuvana on tiikeri.
 */
public class Tiikeri extends Pelaaja {

    private Image image;
    private static final String TIIKERIPELIHAHMONKUVA = "Images/tt.png";
    private static final String TIIKERIMUUTETUNHAHMONKUVA = "Images/ttvari.png";

    public Tiikeri() {
        super();
        image = new ImageIcon(ClassLoader.getSystemResource(TIIKERIPELIHAHMONKUVA)).getImage();
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void piirra(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    @Override
    public void muutaVari() {
        image = new ImageIcon(ClassLoader.getSystemResource(TIIKERIMUUTETUNHAHMONKUVA)).getImage();
    }

    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }
}
