package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.ValikkoNapinKuuntelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luokka, joka luo paneelin, jossa on neljä nappia. Napit edustavat eri
 * valikkovalintoja.
 */
public class ValikkoPanel extends JPanel {

    private final Apuri apuri;

    private JButton uusiPeli;
    private JButton highscore;
    private JButton ohjeet;
    private JButton poistu;
    private static final String POKAALIKUVA = "Images/trophy.png";

    public ValikkoPanel(Apuri a) {
        super(new GridLayout(1, 4));
        this.apuri = a;
        luoKomponentit();
        setBackground(new Color(249, 108, 57));
        asetaPois();
    }

    private void luoKomponentit() {

        uusiPeli = new JButton();
        highscore = new JButton(new ImageIcon(ClassLoader.getSystemResource(POKAALIKUVA)));
        ohjeet = new JButton();
        poistu = new JButton();

        uusiPeli.addActionListener(new ValikkoNapinKuuntelija(uusiPeli, apuri));
        highscore.addActionListener(new ValikkoNapinKuuntelija(highscore, apuri));
        ohjeet.addActionListener(new ValikkoNapinKuuntelija(ohjeet, apuri));
        poistu.addActionListener(new ValikkoNapinKuuntelija(poistu, apuri));

        add(uusiPeli);
        add(highscore);
        add(ohjeet);
        add(poistu);
    }

    /**
     * Päivittää napeille oikean kieliset tekstit.
     *
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     */
    public void paivita() {
        uusiPeli.setText(KieliUtil.getString("uusipeli"));
        highscore.setText(KieliUtil.getString("highscore"));
        ohjeet.setText(KieliUtil.getString("ohjeet"));
        poistu.setText(KieliUtil.getString("poistu"));

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
