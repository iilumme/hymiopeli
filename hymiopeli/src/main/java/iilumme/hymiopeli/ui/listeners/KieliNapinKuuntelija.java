package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.Apuri;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Kuuntelija KieliPanelin napeille.
 */
public class KieliNapinKuuntelija implements ActionListener {

    private final JButton nappi;
    private final Apuri apuri;

    public KieliNapinKuuntelija(JButton nappi, Apuri a) {
        this.nappi = nappi;
        this.apuri = a;
    }

    /**
     * Asettaa kieleksi sen minkä käyttäjä on valinnut. Päivitetään
     * ValikkoPanelin tekstit ja asetetaan se näkyväksi.
     *
     * @param ae
     *
     * @see iilumme.hymiopeli.ui.Apuri#getKieliPaneeli()
     * @see iilumme.hymiopeli.ui.Apuri#getValikkoPaneeli()
     * @see iilumme.hymiopeli.ui.KieliPanel#asetaPois()
     * @see iilumme.hymiopeli.ui.ValikkoPanel#paivita()
     * @see iilumme.hymiopeli.ui.ValikkoPanel#asetaNakyviin()
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        KieliUtil.setLanguage(nappi.getText());
        apuri.getKieliPaneeli().asetaPois();
        apuri.getValikkoPaneeli().paivita();
        apuri.getValikkoPaneeli().asetaNakyviin();

    }

}
