/**
 * Kuuntelija ValikkoPanelin buttoneille.
 */
package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.highscore.HighScore;
import iilumme.hymiopeli.ui.PaneelienKasittelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ValikkoNapinKuuntelija implements ActionListener {

    private JButton nappi;
    private PaneelienKasittelija pK;

    public ValikkoNapinKuuntelija(JButton nappi, PaneelienKasittelija p) {
        this.nappi = nappi;
        this.pK = p;        
    }

    /**
     * Käyttäjän tekemän valinnan perusteella käynnistetään joko uusi peli,
     * näytetään highscore sivu tai poistutaan.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String teksti = nappi.getText();

        if (teksti.equals(KieliUtil.getString("uusipeli"))) {
            pK.getHahmoPaneeli().asetaNakyviin();
        } else if (teksti.equals(KieliUtil.getString("highscore"))) {

            JOptionPane.showMessageDialog(pK.getLiittyma().getFrame(),
                    getScoret(), KieliUtil.getString("highscorenaytto"), JOptionPane.PLAIN_MESSAGE, new ImageIcon(ClassLoader.getSystemResource("Images/caticon.png")));

        } else if (teksti.equals(KieliUtil.getString("poistu"))) {
            System.exit(0);
        }
    }

    private String getScoret() {
        String palautus = new String();
        if (pK.getHst().getHighscoret().size() <= 10) {
            int sija = 1;
            for (HighScore s : pK.getHst().getHighscoret()) {
                palautus += sija + ". " + s.getNimi() + " " + s.getPisteet() + "\n";
                sija++;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                palautus += i + 1 + ". " + pK.getHst().getHighscoret().get(i).getNimi() + " " + pK.getHst().getHighscoret().get(i).getPisteet() + "\n";
            }
        }
        return palautus;
    }
}
