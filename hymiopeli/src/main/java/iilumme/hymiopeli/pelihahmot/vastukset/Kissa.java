/**
 * Vastushahmo, jota yritetään muuttaa (tässä tapauksessa Tiikeriksi).
 */
package iilumme.hymiopeli.pelihahmot.vastukset;

import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Kissa extends Vastus {

    private final Image image;

    public Kissa(int x, int y) {
        super(x, y);
        image = new ImageIcon(ClassLoader.getSystemResource("Images/cc.png")).getImage();
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

}
