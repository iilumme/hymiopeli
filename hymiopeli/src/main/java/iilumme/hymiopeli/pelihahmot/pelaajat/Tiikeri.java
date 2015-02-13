/**
 * Yksi hahmoista, jolla voi pelata.
 */
package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tiikeri extends Pelaaja {
    
    private BufferedImage image;

    public Tiikeri() {
        super();
    }

        public BufferedImage getImage() {
        return image;
    }
    
    /**
     * Haetaan hahmolle kuva.
     *
     * @param g
     */
    @Override
    public void piirra(Graphics g) {
        try {
            image = ImageIO.read(new File("/Users/iina/hymiopeli/hymiopeli/Images/tigerpieni.jpg"));
            g.drawImage(image, x, y, null);
        } catch (IOException ex) {
            System.out.println("Kuvaa ei löydy");
        }
    }
    
    /**
     * Palauttaa tiikerin rajat.
     * @return Rectangle
     */
    
    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }
}
