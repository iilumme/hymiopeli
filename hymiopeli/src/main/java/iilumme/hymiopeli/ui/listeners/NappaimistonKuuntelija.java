/**
 * Kuuntelija näppäimistölle.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.ui.Piirtoalusta;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {

    private final HymioPeli h;
    private final Piirtoalusta p;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int kerroin;
    private boolean kerroinMuutettu;

    public NappaimistonKuuntelija(HymioPeli h, Piirtoalusta p) {
        this.h = h;
        this.p = p;
        this.kerroin = 1;
        this.kerroinMuutettu = true;
    }

    public void setKerroinMuutettu(boolean kM) {
        this.kerroinMuutettu = kM;
    }

    /**
     * Muuttaa suunta-booleaneja trueksi.
     *
     * @param e näppäintapahtuma
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
     * Muutetaan suunta-booleaneja falseksi.
     *
     * @param e näppäintapahtuma
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
     * Asetetaan suunta-booleanit false.
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
        
        if (h.getTaso() % 5 == 0 && !kerroinMuutettu) {
            kerroinMuutettu = true;
            kerroin++;
            
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

    //turha
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
