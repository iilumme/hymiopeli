/**
 * Kuuntelija ValikkoPanelin buttoneille.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.PaneelienKasittelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ValikkoNapinKuuntelija implements ActionListener {

    private JButton nappi;
    private PaneelienKasittelija pK;

    public ValikkoNapinKuuntelija(JButton nappi, PaneelienKasittelija p) {
        this.nappi = nappi;
        this.pK = p;
    }

    /**
     * Käyttäjän tekemän valinnan perusteella käynnistetään joko uusi peli,
     * (tulossa) näytetään highscore sivu tai poistutaan.
     *
     * @param ae
     */

    @Override
    public void actionPerformed(ActionEvent ae) {

        String teksti = nappi.getText();

        if (teksti.equals(KieliUtil.getString("uusipeli"))) {
            pK.getHahmoPaneeli().asetaNakyviin();
        } else if (teksti.equals(KieliUtil.getString("highscore"))) {
            //tulossa
        } else if (teksti.equals(KieliUtil.getString("poistu"))) {
            //tulossa
        }
    }

}
