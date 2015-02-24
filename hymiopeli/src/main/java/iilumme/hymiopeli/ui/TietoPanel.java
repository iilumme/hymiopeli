/**
 * Luokka, joka luo paneelin, jossa on neljä tietoa.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.PoistuNapinKuuntelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TietoPanel extends JPanel {

    private final PaneelienKasittelija pK;
    private JLabel taso;
    private JLabel pelihahmot;
    private JLabel jaljella;
    private JLabel pisteet;
    //private JButton poistu;

    public TietoPanel(PaneelienKasittelija pK) {
        super(new GridLayout(1, 4));
        this.pK = pK;
        luoKomponentit();
        super.setBackground(new Color(204, 204, 204));
        asetaPois();
    }

    private void luoKomponentit() {

        taso = new JLabel(" ");
        pelihahmot = new JLabel(" ");
        jaljella = new JLabel(" ");
        pisteet = new JLabel(" ");
        //poistu = new JButton("Lopeta");

        add(pelihahmot);
        add(jaljella);
        add(taso);
        add(pisteet);
        //add(poistu);
        
        //poistu.addActionListener(new PoistuNapinKuuntelija(poistu, pK));
    }

    /**
     * Asettaa paneelin näkyväksi sekä toiminnalliseksi.
     */
    public void asetaNakyviin() {
        setVisible(true);
//        poistu.setVisible(true);
//        poistu.setEnabled(true);
    }

    /**
     * Asettaa paneelin näkymättömäksi sekä toimimattomaksi.
     */
    public void asetaPois() {
        setVisible(false);
    }

    /**
     * Päivittaa paneelia, hakee tekstit ja luvut.
     */
    public void paivita() {

        String tasoTeksti = KieliUtil.getString("taso") + ": " + pK.getHymiopeli().getTaso();
        taso.setText(tasoTeksti);

        String hahmoTeksti = new String();
        switch (pK.getHymiopeli().getHahmovalinta()) {
            case 1:
                hahmoTeksti = KieliUtil.getString("hymis");
                break;
            case 2:
                hahmoTeksti = KieliUtil.getString("tikru");
                break;
            case 3:
                hahmoTeksti = KieliUtil.getString("ironm");
                break;
        }

        hahmoTeksti += ": " + pK.getHymiopeli().getHyvistenMaara();
        pelihahmot.setText(hahmoTeksti);

        String jalj = "" + pK.getHymiopeli().getJaljella();
        jaljella.setText(jalj);

        String piste = "" + pK.getHymiopeli().getPisteet();
        pisteet.setText(piste);
        
        //poistu.setVisible(true);
        
    }
}
