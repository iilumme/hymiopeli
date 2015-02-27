package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.highscore.HighScoreTallentaja;
import iilumme.hymiopeli.logiikka.HymioPeli;
import java.io.IOException;

/**
 * Apuluokka, joka luo paneelit, auttaa niiden keskenäisen sekä muiden luokkien
 * yhteistyön hallinnassa. Tarjoaa kaikki eri paneelit käytettäviksi.
 */
public class Apuri {

    private final HymioPeli hymiopeli;
    private final HighScoreTallentaja highScoreTallentaja;
    private final Kayttoliittyma liittyma;

    private final KieliPanel kieliPaneeli;
    private final HahmoPanel hahmoPaneeli;
    private final ValikkoPanel valikkoPaneeli;
    private final TietoPanel tietoPaneeli;

    private final ViestiApuri viestiapuri;

    public Apuri(HymioPeli h, Kayttoliittyma l) throws IOException {
        this.hymiopeli = h;
        this.highScoreTallentaja = new HighScoreTallentaja();
        this.liittyma = l;
        this.kieliPaneeli = new KieliPanel(this);
        this.hahmoPaneeli = new HahmoPanel(this);
        this.valikkoPaneeli = new ValikkoPanel(this);
        this.tietoPaneeli = new TietoPanel(this);
        this.viestiapuri = new ViestiApuri(this);
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

    public HighScoreTallentaja getHighScoreTallentaja() {
        return highScoreTallentaja;
    }

    public ViestiApuri getViestiapuri() {
        return viestiapuri;
    }

    /**
     * Käskee käyttöliittymää tekemään valmisteluja ja sitten aloittaa pelin.
     *
     * @see iilumme.hymiopeli.ui.Kayttoliittyma#getPiirtoalusta()
     * @see iilumme.hymiopeli.ui.TietoPanel#asetaNakyviin()
     * @see iilumme.hymiopeli.logiikka.HymioPeli#start()
     */
    public void aloita() {
        liittyma.getPiirtoalusta().setVisible(true);
        tietoPaneeli.asetaNakyviin();
        hymiopeli.start();
    }

}
