/**
 * Yksi hahmoista, jota yritetään muuttaa (tässä tapauksessa IronManiksi).
 */
package iilumme.hymiopeli.pelihahmot.vastustajat;

import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Killian extends Vastus {

    public Killian(int x, int y) {
        super(x, y);
    }

    /**
     * Haetaan hahmolle kuva.
     *
     * @param g
     */
    @Override
    public void piirra(Graphics g) {
        try {
            BufferedImage image = ImageIO.read(new File("/Users/iina/hymiopeli/hymiopeli/Images/killianpieni.jpg"));
            g.drawImage(image, x, y, null);
        } catch (IOException ex) {
            System.out.println("Kuvaa ei löydy");
        }
    }
    
    /**
     * Palauttaa Killianin rajat.
     * @return Rectangle
     */

    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }

}
