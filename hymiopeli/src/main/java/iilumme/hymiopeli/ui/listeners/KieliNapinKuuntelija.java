/**
 * Kuuntelija KieliPanelin napeillw.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.PaneelienKasittelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class KieliNapinKuuntelija implements ActionListener {

    private final JButton nappi;
    private final PaneelienKasittelija pK;

    public KieliNapinKuuntelija(JButton nappi, PaneelienKasittelija p) {
        this.nappi = nappi;
        this.pK = p;
    }

    /**
     * Asetetaan kieleksi se minkä käyttäjä on valinnut. Päivitetään
     * ValikkoPanelin tekstit ja asetetaan se näkyväksi.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        KieliUtil.setLanguage(nappi.getText());
        pK.getKieliPaneeli().asetaPois();
        pK.getValikkoPaneeli().paivita();
        pK.getValikkoPaneeli().asetaNakyviin();

    }

}
