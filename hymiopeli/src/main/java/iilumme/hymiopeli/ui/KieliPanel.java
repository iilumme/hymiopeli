/**
 * Luokka, joka luo "paneelin", jossa on kolme JButtonia. Buttonit edustavat
 * valittavia kieliä.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.KieliNapinKuuntelija;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class KieliPanel extends JPanel {

    private PaneelienKasittelija pK;

    public KieliPanel(PaneelienKasittelija p) {
        super(new GridLayout(1, 3));
        this.pK = p;
        luoKomponentit();
        setBackground(new Color(249, 108, 57));
    }

    private void luoKomponentit() {

        JButton suomi = new JButton("FI");
        JButton englanti = new JButton("EN");
        JButton espanja = new JButton("ES");

        suomi.addActionListener(new KieliNapinKuuntelija(suomi, pK));
        englanti.addActionListener(new KieliNapinKuuntelija(englanti, pK));
        espanja.addActionListener(new KieliNapinKuuntelija(espanja, pK));

        add(suomi);
        add(englanti);
        add(espanja);

    }

    /**
     * Asetaan paneeli näkymättömäksi sekä toimimattomaksi.
     */

    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }

}
