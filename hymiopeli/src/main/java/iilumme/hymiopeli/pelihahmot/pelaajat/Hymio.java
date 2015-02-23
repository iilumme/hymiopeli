/**
 * Yksi Hahmoista, jolla voi pelata.
 */
package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hymio extends Pelaaja {

    public Hymio() {
        super();
    }

    /**
     * Piirretään erittäin oudon näköinen hymiö.
     *
     * @param g
     */
    @Override
    public void piirra(Graphics g) {

        //pää
        g.setColor(Color.BLACK);
        g.drawRoundRect(x - 11, y - 11, 52, 62, 20, 20);
        g.setColor(Color.YELLOW);
        g.fillRoundRect(x - 10, y - 10, 50, 60, 20, 20);

        //silmät
        g.setColor(Color.BLACK);
        g.drawOval(x - 1, y - 1, 12, 16);
        g.drawOval(x + 19, y - 1, 12, 16);

        g.setColor(Color.WHITE);
        g.fillOval(x, y, 10, 14);
        g.fillOval(x + 20, y, 10, 14);

        g.setColor(Color.BLACK);
        g.fillOval(x + 3, y + 3, 5, 7);
        g.fillOval(x + 23, y + 3, 5, 7);

        //suu
        g.drawArc(x, y + 10, 30, 30, 170, 200);
        g.setColor(Color.RED);
        g.fillArc(x, y + 10, 30, 30, 170, 200);
        g.setColor(Color.WHITE);
        g.fillArc(x + 5, y + 18, 20, 18, 170, 200);

    }

    /**
     * Palauttaa hymiön rajat.
     *
     * @return Rectangle
     */
    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 52, 62);
    }

}
