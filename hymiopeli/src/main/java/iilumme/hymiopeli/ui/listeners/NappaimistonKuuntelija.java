/**
 * Kuuntelija näppäimistölle buttoneille.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.ui.Piirtoalusta;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {

    private HymioPeli h;
    private Piirtoalusta p;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public NappaimistonKuuntelija(HymioPeli h, Piirtoalusta p) {
        this.h = h;
        this.p = p;
    }

    /**
     * Käyttäjän tekemien painallusten perusteella muutetaan booleaneja.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
    }

    /**
     * Käyttäjän tekemien painallusten perusteella muutetaan booleaneja.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
    }

    /**
     * Asetetaan booleanit false.
     */

    public void asetaFalse() {
        up = false;
        down = false;
        left = false;
        right = false;
    }

    /**
     * Päivitetään Pelaajan sijaintia.
     */
    public void paivita() {

        int kerroin = h.getTaso() / 2;

        if (kerroin == 0) {
            kerroin = 1;
        }

        if (up) {
            h.getPelaaja().siirra(0, -10 * kerroin);
        }
        if (down) {
            h.getPelaaja().siirra(0, 10 * kerroin);
        }
        if (right) {
            h.getPelaaja().siirra(10 * kerroin, 0);
        }
        if (left) {
            h.getPelaaja().siirra(-10 * kerroin, 0);
        }

        p.paivita();
    }

    //turhat
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
