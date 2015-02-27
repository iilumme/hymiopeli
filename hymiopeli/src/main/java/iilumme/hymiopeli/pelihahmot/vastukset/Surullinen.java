package iilumme.hymiopeli.pelihahmot.vastukset;

import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Vastushahmo, jota yritetään muuttaa (tässä tapauksessa Hymiöksi).
 */
public class Surullinen extends Vastus {

    public Surullinen(int x, int y) {
        super(x, y);
    }

    @Override
    public void piirra(Graphics g) {

        //pää
        g.drawRoundRect(x - 11, y - 11, 52, 62, 20, 20);
        g.setColor(Color.darkGray);
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
        g.drawArc(x, y + 20, 30, 30, 0, 180);
        g.setColor(Color.LIGHT_GRAY);
    }

    @Override
    public Rectangle getRajat() {
        return new Rectangle(getX(), getY(), 52, 62);
    }
}
