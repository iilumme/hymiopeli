/**
 * Kuuntelija poistumis-napille.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.PaneelienKasittelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class PoistuNapinKuuntelija implements ActionListener {
    
    private final JButton nappi;
    private final PaneelienKasittelija pK;

    public PoistuNapinKuuntelija(JButton nappi, PaneelienKasittelija pK) {
        this.nappi = nappi;
        this.pK = pK;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        pK.getHymiopeli().setJatkuukoPeli(false);
        nappi.setEnabled(false);
        nappi.setVisible(false);
    }
    
}
