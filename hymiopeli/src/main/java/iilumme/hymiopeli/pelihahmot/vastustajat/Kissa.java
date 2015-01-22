package iilumme.hymiopeli.pelihahmot.vastustajat;

import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.Graphics;

public class Kissa extends Vastus {

    public Kissa(int x, int y) {
        super(x, y);
    }

    @Override
    public void piirra(Graphics g) {
        g.drawImage(null, x, y, null);
    }

}
