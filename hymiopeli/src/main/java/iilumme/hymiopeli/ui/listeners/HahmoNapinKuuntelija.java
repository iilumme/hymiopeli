/**
 * Kuuntelija HahmoPanelin buttoneille.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.PaneelienKasittelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class HahmoNapinKuuntelija implements ActionListener {

    private JButton nappi;
    private PaneelienKasittelija pK;

    public HahmoNapinKuuntelija(JButton nappi, PaneelienKasittelija p) {
        this.nappi = nappi;
        this.pK = p;
    }

    /**
     * Käyttäjän valitseman hahmojen perusteella luodatetaan HymioPelilla
     * hahmot. Asetetaan myös ValikkoPanel ja HahmoPanel toimimattomiksi, ja
     * kerrotaan käyttöliittymälle, että voidaan aloittaa.
     *
     * @param e
     */
    //tätä pitää miettiä vielä :]
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (nappi.getText()) {
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
