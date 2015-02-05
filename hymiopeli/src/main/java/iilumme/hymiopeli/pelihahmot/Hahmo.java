/**
 * Abstrakti luokka Hahmo määrittää kaikille Hahmo-luokan periville yhteiset metodit:
 * X- ja Y-koordinaatit, siirtymisen ja piirron.
 */

package iilumme.hymiopeli.pelihahmot;

import java.awt.Graphics;

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

    /**
     * Metodi siirtää oliota.
     * 
     * @param dx liike x-akselilla. "Käyttäjän antama syöte"
     * @param dy liike y-akselilla. "Käyttäjän antama syöte"
     */
    public void siirra(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Abstrakti metodi, jonka jokaisen luokan on itse määriteltävä.
     * 
     */
    
    public abstract void piirra(Graphics g);

}
