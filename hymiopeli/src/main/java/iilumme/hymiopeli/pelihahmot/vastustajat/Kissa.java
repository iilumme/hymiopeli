/**
 * Yksi hahmoista, jota yritetään muuttaa (tässä tapauksessa Tiikeriksi).
 */
package iilumme.hymiopeli.pelihahmot.vastustajat;

import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Kissa extends Vastus {

    public Kissa(int x, int y) {
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
            BufferedImage image = ImageIO.read(new File("/Users/iina/hymiopeli/hymiopeli/Images/catpieni.jpg"));
            g.drawImage(image, x, y, null);
        } catch (IOException ex) {
            System.out.println("Kuvaa ei löydy");
        }
    }

}
