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
//    private boolean up;
//    private boolean down;
//    private boolean left;
//    private boolean right;

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

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            h.getPelaaja().siirra(0, -5);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            h.getPelaaja().siirra(0, 5);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            h.getPelaaja().siirra(5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            h.getPelaaja().siirra(-5, 0);
        }

        p.paivita();

//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            up = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            down = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            right = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            left = true;
//        }
    }

    /**
     * Käyttäjän tekemien painallusten perusteella muutetaan booleaneja.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            up = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            down = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            right = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            left = false;
//        }
    }

//    public void paivita() {
//        if (up) {
//            h.getPelaaja().siirra(0, -6);
//        }
//        if (down) {
//            h.getPelaaja().siirra(0, 6);
//        }
//        if (right) {
//            h.getPelaaja().siirra(6, 0);
//        }
//        if (left) {
//            h.getPelaaja().siirra(-6, 0);
//        }
//
//        p.paivita();
//    }
    //turhat
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
