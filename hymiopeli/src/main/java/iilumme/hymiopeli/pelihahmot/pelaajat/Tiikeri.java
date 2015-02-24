/**
 * Pelaajahahmo, jonka kuvana on tiikeri.
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
        image = new ImageIcon(ClassLoader.getSystemResource("Images/tt.png")).getImage();
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void piirra(Graphics g) {
        g.drawImage(image, x, y, null);
    }
    
    @Override
    public void muutaVari(){
        image = new ImageIcon(ClassLoader.getSystemResource("Images/ttvari.png")).getImage();
    }

    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 45, 48);
    }
}
