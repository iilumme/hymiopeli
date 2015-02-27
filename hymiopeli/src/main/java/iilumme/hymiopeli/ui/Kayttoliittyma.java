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

/**
 * Graaffinen käyttöliittymä Hymiöpelille.
 */
public class Kayttoliittyma implements Runnable {

    private static final int LEVEYS = 600;
    private static final int KORKEUS = 600;

    private static final String HYMIOPELILOGO = "Images/logo.png";

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private final HymioPeli hymiopeli;
    private Apuri apuri;

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

        luoKomponentit(frame.getContentPane());
        setKeyListener();

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {

        //Layout
        BorderLayout cLayout = new BorderLayout();
        c.setLayout(cLayout);
        c.setBackground(new Color(249, 108, 57));

        //Otsikko
        JLabel logo = new JLabel(new ImageIcon(ClassLoader.getSystemResource(HYMIOPELILOGO)));

        //Iso-paneeli & Iso-layout    
        JPanel iso = new JPanel();
        iso.setLayout(new BoxLayout(iso, BoxLayout.Y_AXIS));
        iso.setBackground(new Color(249, 108, 57));

        //Apuri & Paneelit
        try {
            apuri = new Apuri(hymiopeli, this);
        } catch (IOException e) {
            System.out.println("Tiedostoja ei löytynyt. Konsultoi iilumme@cs.helsinki.fi ;)");
            System.exit(0);
        }

        //Piirtoalusta
        this.piirtoalusta = new Piirtoalusta(hymiopeli);
        piirtoalusta.setVisible(false);

        //HymioPeli
        hymiopeli.setApuri(apuri);
        hymiopeli.setPiirtoalusta(piirtoalusta);

        //Add 
        c.add(logo, BorderLayout.NORTH);

        iso.add(apuri.getKieliPaneeli());
        iso.add(apuri.getValikkoPaneeli());
        iso.add(apuri.getHahmoPaneeli());
        iso.add(piirtoalusta);

        c.add(iso, BorderLayout.CENTER);
        c.add(apuri.getTietoPaneeli(), BorderLayout.SOUTH);
    }

    private void setKeyListener() {
        frame.setFocusable(true);
        NappaimistonKuuntelija nK = new NappaimistonKuuntelija(hymiopeli, piirtoalusta);
        frame.addKeyListener(nK);
        hymiopeli.setNappaimistonKuuntelija(nK);
    }

}
