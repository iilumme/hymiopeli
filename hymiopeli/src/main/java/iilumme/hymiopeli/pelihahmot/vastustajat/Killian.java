package iilumme.hymiopeli.pelihahmot.vastustajat;

import iilumme.hymiopeli.pelihahmot.Vastus;
import java.awt.Graphics;


public class Killian extends Vastus {

    public Killian(int x, int y) {
        super(x, y);
    }

    @Override
    public void piirra(Graphics g) {
        g.drawImage(null, x, y, null);
    }
    
}
