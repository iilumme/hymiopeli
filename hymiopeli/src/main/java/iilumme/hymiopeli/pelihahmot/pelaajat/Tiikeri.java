/**
 * Yksi hahmoista, jolla voi pelata.
 */
package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Tiikeri extends Pelaaja {

    private Image image;

    public Tiikeri() {
        super();
        
        image = new ImageIcon(ClassLoader.getSystemResource("Images/tigerpieni.jpg")).getImage();
        
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
     * Palauttaa tiikerin rajat.
     *
     * @return Rectangle
     */
    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }
}
