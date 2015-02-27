package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.Apuri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Kuuntelija HahmoPanelin napeille.
 */
public class HahmoNapinKuuntelija implements ActionListener {

    private final JButton nappi;
    private final Apuri apuri;

    public HahmoNapinKuuntelija(JButton nappi, Apuri a) {
        this.nappi = nappi;
        this.apuri = a;
    }

    /**
     * Käyttäjän valitseman hahmon perusteella luodatetaan HymioPelilla hahmot.
     * Asetetaan myös ValikkoPanel ja HahmoPanel toimimattomiksi, ja kerrotaan
     * käyttöliittymälle, että voidaan aloittaa.
     *
     * @param e
     * @see iilumme.hymiopeli.ui.Apuri#getHymiopeli()
     * @see iilumme.hymiopeli.ui.Apuri#getValikkoPaneeli()
     * @see iilumme.hymiopeli.ui.Apuri#getHahmoPaneeli()
     * @see iilumme.hymiopeli.ui.Apuri#aloita()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#setHahmovalinta(int)
     * @see iilumme.hymiopeli.logiikka.HymioPeli#lisaaHahmot()
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (nappi.getName()) {
            case "hy":
                apuri.getHymiopeli().setHahmovalinta(1);
                apuri.getHymiopeli().lisaaHahmot();
                break;
            case "ti":
                apuri.getHymiopeli().setHahmovalinta(2);
                apuri.getHymiopeli().lisaaHahmot();
                break;
            case "ir":
                apuri.getHymiopeli().setHahmovalinta(3);
                apuri.getHymiopeli().lisaaHahmot();
                break;
        }

        apuri.getValikkoPaneeli().asetaPois();
        apuri.getHahmoPaneeli().asetaPois();
        apuri.aloita();
    }

}
