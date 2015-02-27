package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.HahmoNapinKuuntelija;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luokka, joka luo paneelin, jossa on kolme nappia. Napit ovat valittavia
 * hahmoja.
 */
public class HahmoPanel extends JPanel {

    private final Apuri apuri;
    private static final String IRONMANLOGO = "Images/ironman.png";
    private static final String TIIKERILOGO = "Images/tiger.jpg";
    private static final String HYMIOLOGO = "Images/hymio.jpg";

    public HahmoPanel(Apuri a) {
        super(new GridLayout(1, 3));
        this.apuri = a;
        luoKomponentit();
        setBackground(new Color(249, 108, 57));
        asetaPois();
    }

    private void luoKomponentit() {

        JButton hymio = new JButton(new ImageIcon(ClassLoader.getSystemResource(HYMIOLOGO)));
        JButton tikru = new JButton(new ImageIcon(ClassLoader.getSystemResource(TIIKERILOGO)));
        JButton ironman = new JButton(new ImageIcon(ClassLoader.getSystemResource(IRONMANLOGO)));

        hymio.addActionListener(new HahmoNapinKuuntelija(hymio, apuri));
        tikru.addActionListener(new HahmoNapinKuuntelija(tikru, apuri));
        ironman.addActionListener(new HahmoNapinKuuntelija(ironman, apuri));

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
