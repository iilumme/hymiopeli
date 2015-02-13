/**
 * Ns apuluokka, joka luo paneelit ja auttaa niiden keskenäisen yhteistyön hallinnassa.
 * Tarjoaa kaikki eri paneelit käytettäviksi.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;

public class PaneelienKasittelija {

    private final HymioPeli hymiopeli;

    private final KieliPanel kieliPaneeli;
    private final HahmoPanel hahmoPaneeli;
    private final ValikkoPanel valikkoPaneeli;

    private Kayttoliittyma liittyma;

    public PaneelienKasittelija(HymioPeli h, Kayttoliittyma liittyma) {
        this.hymiopeli = h;
        this.kieliPaneeli = new KieliPanel(this);
        this.hahmoPaneeli = new HahmoPanel(this);
        this.valikkoPaneeli = new ValikkoPanel(this);
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

    public HymioPeli getHymiopeli() {
        return hymiopeli;
    }

    public Kayttoliittyma getLiittyma() {
        return liittyma;
    }
    
    
    
    /**
     * Käskee käyttöliittymää tekemään valmisteluja ja sitten aloittaa pelin.
     */

    public void aloita() {       
        liittyma.siirraPiirtoalusta();
        liittyma.getPiirtoalusta().setVisible(true);
        hymiopeli.start();
    }

}
