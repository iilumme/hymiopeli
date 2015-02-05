/**
 * Kuuntelija näppäimistölle buttoneille.
 */

package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.pelihahmot.Pelaaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {

    private Pelaaja pelaaja;

    public NappaimistonKuuntelija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    /**
     * Käyttäjän tekemien painallusten perusteella siirretään pelaajan koordinaatteja.
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.siirra(0, -2);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.siirra(0, 2);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //vasemmalle ei voi palata
            pelaaja.siirra(0, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.siirra(2, 0);
        }

    }

    //turhat
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
