/**
 * Abstrakti luokka Hahmo määrittää kaikille Hahmo-luokan periville yhteiset
 * metodit.
 */
package iilumme.hymiopeli.pelihahmot;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Hahmo {

    protected int x;
    protected int y;

    public Hahmo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        if (x > -1) {
            this.x = x;
        }

        if (y > -1) {
            this.y = y;
        }

    }

    /**
     * Siirtää Hahmo-oliota.
     *
     * @param dx liike x-akselilla
     * @param dy liike y-akselilla
     */
    public void siirra(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Piirtää Hahmo-olion.
     *
     * @param g Graphics
     */
    public abstract void piirra(Graphics g);

    /**
     * Palauttaa Hahmo-olion rajat.
     *
     * @return Rectangle
     */
    public abstract Rectangle getRajat();

}
