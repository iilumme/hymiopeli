/**
 * Graaffinen käyttöliittymä Hymiöpelille.
 */
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import iilumme.hymiopeli.ui.listeners.NappaimistonKuuntelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private static final int LEVEYS = 600;
    private static final int KORKEUS = 600;

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private final HymioPeli hymiopeli;
    private PaneelienKasittelija pK;

    public Kayttoliittyma() {
        this.hymiopeli = new HymioPeli(LEVEYS, LEVEYS);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Piirtoalusta getPiirtoalusta() {
        return piirtoalusta;
    }

    @Override
    public void run() {
        frame = new JFrame("Hymiöpeli");
        frame.setPreferredSize(new Dimension(LEVEYS, KORKEUS));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (IOException e) {
            System.out.println("No voi voi, ei nyt onnistunut tänään :)" + e.getMessage());
        }
        setPiirtoalusta();
        setKeyListener();

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) throws IOException {

        //Layout
        BorderLayout cLayout = new BorderLayout();
        c.setLayout(cLayout);
        c.setBackground(new Color(249, 108, 57));

        //Otsikko
        JLabel logo = new JLabel(new ImageIcon(ClassLoader.getSystemResource("Images/logo.png")));

        //Iso-paneeli & Iso-layout    
        JPanel iso = new JPanel();
        iso.setLayout(new BoxLayout(iso, BoxLayout.Y_AXIS));
        iso.setBackground(new Color(249, 108, 57));

        //Paneelit
        pK = new PaneelienKasittelija(hymiopeli, this);
        hymiopeli.setPaneelienKasittelija(pK);

        //Add 
        c.add(logo, BorderLayout.NORTH);
        iso.add(pK.getKieliPaneeli());
        iso.add(pK.getValikkoPaneeli());
        iso.add(pK.getHahmoPaneeli());
        c.add(iso, BorderLayout.CENTER);
        c.add(pK.getTietoPaneeli(), BorderLayout.SOUTH);

    }

    private void setKeyListener() {
        frame.setFocusable(true);
        NappaimistonKuuntelija nK = new NappaimistonKuuntelija(hymiopeli, piirtoalusta);
        frame.addKeyListener(nK);
        hymiopeli.setNappaimistonKuuntelija(nK);
    }

    private void setPiirtoalusta() {
        this.piirtoalusta = new Piirtoalusta(hymiopeli);
        hymiopeli.setPiirtoalusta(piirtoalusta);
        frame.getContentPane().add(piirtoalusta, BorderLayout.SOUTH);
        piirtoalusta.setVisible(false);
    }

    /**
     * Asetetaan Piirtoalusta ja TietoPaneeli oikeaan paikkaan.
     */
    public void siirraPiirtoalusta() {
        frame.getContentPane().add(piirtoalusta, BorderLayout.CENTER);
        frame.getContentPane().add(pK.getTietoPaneeli(), BorderLayout.SOUTH);
    }

}
