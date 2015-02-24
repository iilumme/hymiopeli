/**
 * Kuuntelija HahmoPanelin napeille.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.PaneelienKasittelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class HahmoNapinKuuntelija implements ActionListener {

    private final JButton nappi;
    private final PaneelienKasittelija pK;

    public HahmoNapinKuuntelija(JButton nappi, PaneelienKasittelija p) {
        this.nappi = nappi;
        this.pK = p;
    }

    /**
     * Käyttäjän valitseman hahmon perusteella luodatetaan HymioPelilla hahmot.
     * Asetetaan myös ValikkoPanel ja HahmoPanel toimimattomiksi, ja kerrotaan
     * käyttöliittymälle, että voidaan aloittaa.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (nappi.getName()) {
            case "hy":
                pK.getHymiopeli().setHahmovalinta(1);
                pK.getHymiopeli().lisaaHahmot();
                break;
            case "ti":
                pK.getHymiopeli().setHahmovalinta(2);
                pK.getHymiopeli().lisaaHahmot();
                break;
            case "ir":
                pK.getHymiopeli().setHahmovalinta(3);
                pK.getHymiopeli().lisaaHahmot();
                break;
        }

        pK.getValikkoPaneeli().asetaPois();
        pK.getHahmoPaneeli().asetaPois();
        pK.aloita();
    }

}
