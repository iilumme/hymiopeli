/**
 * Luokka, joka luo paneelin, jossa on kolme nappia. Napit edustavat eri
 * valikkovalintoja.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.ValikkoNapinKuuntelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ValikkoPanel extends JPanel {
    
    private final PaneelienKasittelija pK;
    
    private JButton uusiPeli;
    private JButton highscore;
    private JButton poistu;
    
    public ValikkoPanel(PaneelienKasittelija p) {
        super(new GridLayout(1, 3));
        
        this.pK = p;
        luoKomponentit();
        setBackground(new Color(249, 108, 57));
        asetaPois();
    }
    
    private void luoKomponentit() {
        
        uusiPeli = new JButton();
        highscore = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/trophy.png")));
        poistu = new JButton();
        
        uusiPeli.addActionListener(new ValikkoNapinKuuntelija(uusiPeli, pK));
        highscore.addActionListener(new ValikkoNapinKuuntelija(highscore, pK));
        poistu.addActionListener(new ValikkoNapinKuuntelija(poistu, pK));
        
        add(uusiPeli);
        add(highscore);
        add(poistu);
    }

    /**
     * Päivittää napeille oikean kieliset tekstit.
     */
    public void paivita() {
        uusiPeli.setText(KieliUtil.getString("uusipeli"));       
        highscore.setText(KieliUtil.getString("highscore"));
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
