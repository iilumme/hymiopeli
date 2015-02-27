package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Pelaajahahmo, jonka kuvana on Iron Man.
 */
public class IronMan extends Pelaaja {

    private Image image;
    private static final String IRONMANPELIHAHMONKUVA = "Images/ii.png";
    private static final String IRONMANMUUTETUNHAHMONKUVA = "Images/iivari.png";

    public IronMan() {
        super();
        image = new ImageIcon(ClassLoader.getSystemResource(IRONMANPELIHAHMONKUVA)).getImage();
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void piirra(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }

    @Override
    public void muutaVari() {
        image = new ImageIcon(ClassLoader.getSystemResource(IRONMANMUUTETUNHAHMONKUVA)).getImage();
    }
}
