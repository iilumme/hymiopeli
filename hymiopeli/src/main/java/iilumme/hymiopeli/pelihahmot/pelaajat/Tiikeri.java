/**
 * Yksi hahmoista, jolla voi pelata.
 */
package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tiikeri extends Pelaaja {

    public Tiikeri() {
        super();
    }

    /**
     * Haetaan hahmolle kuva.
     *
     * @param g
     */
    @Override
    public void piirra(Graphics g) {
        try {
            BufferedImage image = ImageIO.read(new File("/Users/iina/hymiopeli/hymiopeli/Images/tigerpieni.jpg"));
            g.drawImage(image, x, y, null);
        } catch (IOException ex) {
            System.out.println("Kuvaa ei löydy");
        }
    }

    /**
     * Tarkistetaan osuiko Tiikeri toiseen hahmoon.
     *
     * @param hahmo toinen hahmo
     * @return true, jos osui. False, jos ei osunut.
     */

    public boolean osuu(Hahmo hahmo) {
        if (super.getX() == hahmo.getX() && super.getY() == hahmo.getY()) {
            return true;
        }
        return false;
    }
}
