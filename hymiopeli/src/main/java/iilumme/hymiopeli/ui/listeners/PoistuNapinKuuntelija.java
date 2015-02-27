package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.Apuri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Kuuntelija pelistä keskenpoistumis-napille.
 */
public class PoistuNapinKuuntelija implements ActionListener {

    private final JButton nappi;
    private final Apuri apuri;

    public PoistuNapinKuuntelija(JButton nappi, Apuri a) {
        this.nappi = nappi;
        this.apuri = a;
    }

    /**
     * Asettaa pelin loppuneeksi.
     *
     * @param e
     *
     * @see iilumme.hymiopeli.ui.Apuri#getHymiopeli()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#setJatkuukoPeli(boolean)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        apuri.getHymiopeli().setJatkuukoPeli(false);
    }

}
