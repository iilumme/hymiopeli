/**
 * Luokka, joka luo "paneelin", jossa on kolme JButtonia. Buttonit ovat
 * valittavia hahmoja.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.HahmoNapinKuuntelija;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HahmoPanel extends JPanel {

    private PaneelienKasittelija pK;

    public HahmoPanel(PaneelienKasittelija p) {
        super(new GridLayout(1, 3));
        this.pK = p;
        luoKomponentit();
        setBackground(new Color(0, 0, 102));
        asetaPois();
    }

    private void luoKomponentit() {

        JButton hymio = new JButton("hy", new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/hymio.jpg"));
        JButton tikru = new JButton("ti", new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/tiger.jpg"));
        JButton ironman = new JButton("ir", new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/ironman.png"));

        hymio.addActionListener(new HahmoNapinKuuntelija(hymio, pK));
        tikru.addActionListener(new HahmoNapinKuuntelija(tikru, pK));
        ironman.addActionListener(new HahmoNapinKuuntelija(ironman, pK));

        add(hymio);
        add(tikru);
        add(ironman);
    }

    /**
     * Asetaan paneeli näkyväksi sekä toiminnalliseksi.
     */

    public void asetaNakyviin() {
        setEnabled(true);
        setVisible(true);
    }

    /**
     * Asetaan paneeli näkymättömäksi sekä toimimattomaksi.
     */

    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }

}
