/**
 * Yksi hahmoista, jolla voi pelata.
 */
package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class IronMan extends Pelaaja {

    private Image image;

    public IronMan() {
        super();
        image = new ImageIcon(ClassLoader.getSystemResource("Images/ii.png")).getImage();
    }

    public Image getImage() {
        return image;
    }

    /**
     * Haetaan hahmolle kuva.
     *
     * @param g
     */
    @Override
    public void piirra(Graphics g) {

        g.drawImage(image, x, y, null);

    }

    /**
     * Palauttaa Iron Manin rajat.
     *
     * @return Rectangle
     */
    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }
}
