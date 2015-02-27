package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.Apuri;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Kuuntelija ValikkoPanelin napeille.
 */
public class ValikkoNapinKuuntelija implements ActionListener {

    private final JButton nappi;
    private final Apuri apuri;

    public ValikkoNapinKuuntelija(JButton nappi, Apuri a) {
        this.nappi = nappi;
        this.apuri = a;
    }

    /**
     * Käyttäjän tekemän valinnan perusteella käynnistetään joko uusi peli,
     * näytetään Highscore-sivu, näytetään ohjeet tai poistutaan pelistä.
     *
     * @param ae
     *
     * @see iilumme.hymiopeli.ui.Apuri#getHahmoPaneeli()
     * @see iilumme.hymiopeli.ui.ViestiApuri#highScoreNayttoJOptionPane()
     * @see iilumme.hymiopeli.ui.ViestiApuri#ohjeetNayttoJOptionPane()
     * @see iilumme.hymiopeli.ui.HahmoPanel#asetaNakyviin()
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String teksti = nappi.getText();

        if (teksti.equals(KieliUtil.getString("uusipeli"))) {
            apuri.getHahmoPaneeli().asetaNakyviin();
        } else if (teksti.equals(KieliUtil.getString("highscore"))) {
            apuri.getViestiapuri().highScoreNayttoJOptionPane();
        } else if (teksti.equals(KieliUtil.getString("ohjeet"))) {
            apuri.getViestiapuri().ohjeetNayttoJOptionPane();
        } else if (teksti.equals(KieliUtil.getString("poistu"))) {
            System.exit(0);
        }
    }
}
