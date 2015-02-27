package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.PoistuNapinKuuntelija;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luokka, joka luo paneelin, jossa on neljä tietoa ja poistumisnappi.
 */
public class TietoPanel extends JPanel {

    private final Apuri apuri;

    private JLabel taso;
    private JLabel pelihahmot;
    private JLabel jaljella;
    private JLabel pisteet;

    private JButton poistu;

    public TietoPanel(Apuri a) {
        super(new GridLayout(1, 5));
        this.apuri = a;
        luoKomponentit();
        super.setBackground(new Color(204, 204, 204));
        setVisible(false);
    }

    private void luoKomponentit() {

        taso = new JLabel(" ");
        pelihahmot = new JLabel(" ");
        jaljella = new JLabel(" ");
        pisteet = new JLabel(" ");
        poistu = new JButton();
        poistu.addActionListener(new PoistuNapinKuuntelija(poistu, apuri));

        add(pelihahmot);
        add(jaljella);
        add(taso);
        add(pisteet);
        add(poistu);

    }

    /**
     * Asettaa paneelin näkyväksi sekä poistu-JButtonin toiminnalliseksi.
     */
    public void asetaNakyviin() {
        setVisible(true);
        poistu.setEnabled(true);
    }

    /**
     * Asettaa paneelin näkymättömäksi sekä poistu-JButtonin toimimattomaksi.
     */
    public void asetaPois() {
        setVisible(false);
        poistu.setEnabled(false);
    }

    /**
     * Päivittää paneelia, hakee tekstit ja luvut.
     *
     * @see iilumme.hymiopeli.ui.Apuri#getHymiopeli()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getHahmovalinta()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getHyvistenMaara()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getJaljella()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getTaso()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#getPisteet()
     * @see iilumme.hymiopeli.util.KieliUtil#getString(java.lang.String)
     */
    public void paivita() {

        String hahmoTeksti = getHahmoteksti();
        pelihahmot.setText(hahmoTeksti);

        String jalj = getJaljellaTeksti();
        jaljella.setText(jalj);

        String tasoTeksti = KieliUtil.getString("taso") + ": " + apuri.getHymiopeli().getTaso();
        taso.setText(tasoTeksti);

        String piste = "" + apuri.getHymiopeli().getPisteet();
        pisteet.setText(piste);

        String kasky = KieliUtil.getString("lopeta");
        poistu.setText(kasky);
    }

    private String getJaljellaTeksti() {
        String jalj;
        if (apuri.getHymiopeli().getJaljella() < 0) {
            jalj = "EXTRA";
        } else {
            jalj = "" + apuri.getHymiopeli().getJaljella();
        }
        return jalj;
    }

    private String getHahmoteksti() {
        String hahmoTeksti = new String();
        switch (apuri.getHymiopeli().getHahmovalinta()) {
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
        hahmoTeksti += ": " + apuri.getHymiopeli().getMuutetut();
        return hahmoTeksti;
    }
}
