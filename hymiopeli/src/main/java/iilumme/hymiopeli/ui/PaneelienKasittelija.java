/**
 * Ns apuluokka, joka luo paneelit ja auttaa niiden keskenäisen yhteistyön hallinnassa.
 * Tarjoaa kaikki eri paneelit käytettäviksi.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.highscore.HighScoreTallentaja;
import iilumme.hymiopeli.logiikka.HymioPeli;
import java.io.IOException;

public class PaneelienKasittelija {

    private final HymioPeli hymiopeli;

    private final KieliPanel kieliPaneeli;
    private final HahmoPanel hahmoPaneeli;
    private final ValikkoPanel valikkoPaneeli;
    private final TietoPanel tietoPaneeli;
    private final HighScoreTallentaja hst;

    private Kayttoliittyma liittyma;

    public PaneelienKasittelija(HymioPeli h, Kayttoliittyma liittyma) throws IOException {
        this.hymiopeli = h;
        this.kieliPaneeli = new KieliPanel(this);
        this.hahmoPaneeli = new HahmoPanel(this);
        this.valikkoPaneeli = new ValikkoPanel(this);
        this.tietoPaneeli = new TietoPanel(this);
        this.hst = new HighScoreTallentaja();
        this.liittyma = liittyma;
    }

    public KieliPanel getKieliPaneeli() {
        return kieliPaneeli;
    }

    public HahmoPanel getHahmoPaneeli() {
        return hahmoPaneeli;
    }

    public ValikkoPanel getValikkoPaneeli() {
        return valikkoPaneeli;
    }

    public TietoPanel getTietoPaneeli() {
        return tietoPaneeli;
    }

    public HymioPeli getHymiopeli() {
        return hymiopeli;
    }

    public Kayttoliittyma getLiittyma() {
        return liittyma;
    }

    public HighScoreTallentaja getHst() {
        return hst;
    }
    
    
    /**
     * Käskee käyttöliittymää tekemään valmisteluja ja sitten aloittaa pelin.
     */

    public void aloita() {       
        liittyma.siirraPiirtoalusta();
        liittyma.getPiirtoalusta().setVisible(true);
        tietoPaneeli.asetaNakyviin();
        hymiopeli.start();
    }

}
