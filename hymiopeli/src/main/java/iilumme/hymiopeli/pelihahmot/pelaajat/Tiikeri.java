package iilumme.hymiopeli.pelihahmot.pelaajat;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import iilumme.hymiopeli.pelihahmot.Hahmo;
import java.awt.Graphics;

public class Tiikeri extends Pelaaja {

    public Tiikeri() {
        super();
    }

    @Override
    public void piirra(Graphics g) {
        g.drawImage(null, x, y, null);
    }

    public boolean osuu(Hahmo hahmo) {
        if (super.getX() == hahmo.getX() && super.getY() == hahmo.getY()) {
            return true;
        }
        return false;
    }
}
