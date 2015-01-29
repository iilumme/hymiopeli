package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

    public Kayttoliittyma() {
        this.piirtoalusta = new Piirtoalusta(new HymioPeli(LEVEYS, KORKEUS));
    }

    @Override
    public void run() {
        frame = new JFrame("Hymiöpeli");
        frame.setPreferredSize(new Dimension(LEVEYS, KORKEUS));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {
        
        //Layout
        BorderLayout cLayout = new BorderLayout();
        c.setLayout(cLayout);
        c.setBackground(new Color(178, 97, 240));

        //Otsikko
        JLabel logo = new JLabel(new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/logo.png"));
        
        //Iso-paneeli & Iso-layout    
        JPanel iso = new JPanel();
        iso.setLayout(new BoxLayout(iso, BoxLayout.Y_AXIS));
        iso.setBackground(new Color(178, 97, 240));
        
        //Paneelit
        KieliPanel kielet = new KieliPanel(frame);               
        ValikkoPanel valikkoPaneeli = new ValikkoPanel();
        HahmoPanel hahmoPaneeli = new HahmoPanel();
        
        //Add 
        c.add(logo, BorderLayout.NORTH);
        iso.add(kielet);
        iso.add(hahmoPaneeli);
        iso.add(valikkoPaneeli);
        c.add(iso, BorderLayout.CENTER);        

    }

}
