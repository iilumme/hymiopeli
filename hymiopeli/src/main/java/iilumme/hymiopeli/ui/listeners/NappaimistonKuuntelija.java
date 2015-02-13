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

    public NappaimistonKuuntelija(HymioPeli h, Piirtoalusta p) {
        this.h = h;
        this.p = p;
    }

    /**
     * Käyttäjän tekemien painallusten perusteella siirretään pelaajan
     * koordinaatteja.
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

    }

    //turhat
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
