/**
 * Luokka, joka luo paneelin, jossa on kolme nappia. Napit ovat valittavia
 * hahmoja.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.HahmoNapinKuuntelija;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HahmoPanel extends JPanel {

    private final PaneelienKasittelija pK;

    public HahmoPanel(PaneelienKasittelija p) {
        super(new GridLayout(1, 3));
        this.pK = p;
        luoKomponentit();
        setBackground(new Color(249, 108, 57));
        asetaPois();
    }

    private void luoKomponentit() {

        JButton hymio = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/hymio.jpg")));
        JButton tikru = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/tiger.jpg")));
        JButton ironman = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/ironman.png")));

        hymio.addActionListener(new HahmoNapinKuuntelija(hymio, pK));
        tikru.addActionListener(new HahmoNapinKuuntelija(tikru, pK));
        ironman.addActionListener(new HahmoNapinKuuntelija(ironman, pK));

        hymio.setName("hy");
        tikru.setName("ti");
        ironman.setName("ir");

        add(hymio);
        add(tikru);
        add(ironman);
    }

    /**
     * Asettaa paneelin näkyväksi sekä toiminnalliseksi.
     */
    public void asetaNakyviin() {
        setEnabled(true);
        setVisible(true);
    }

    /**
     * Asettaa paneelin näkymättömäksi sekä toimimattomaksi.
     */
    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }
}
