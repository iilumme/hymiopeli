package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.KieliNapinKuuntelija;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luokka, joka luo paneelin, jossa on kolme nappia. Napit edustavat valittavia
 * kieliä.
 */
public class KieliPanel extends JPanel {

    private final Apuri apuri;

    public KieliPanel(Apuri a) {
        super(new GridLayout(1, 3));
        this.apuri = a;
        luoKomponentit();
        setBackground(new Color(249, 108, 57));
    }

    private void luoKomponentit() {

        JButton suomi = new JButton("FI");
        JButton englanti = new JButton("EN");
        JButton espanja = new JButton("ES");

        suomi.addActionListener(new KieliNapinKuuntelija(suomi, apuri));
        englanti.addActionListener(new KieliNapinKuuntelija(englanti, apuri));
        espanja.addActionListener(new KieliNapinKuuntelija(espanja, apuri));

        add(suomi);
        add(englanti);
        add(espanja);
    }

    /**
     * Asettaa paneelin näkymättömäksi sekä toimimattomaksi.
     */
    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }

}
