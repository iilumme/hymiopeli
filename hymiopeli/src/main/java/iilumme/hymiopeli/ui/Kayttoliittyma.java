package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.logiikka.HymioPeli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

        //otsikko
        JLabel logo = new JLabel(new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/logo.png"));
//        
//        //buttons
//        JButton suomi = new JButton("FI");
//        JButton englanti = new JButton("EN");
//        JButton espanja = new JButton("ES");
//        
//        //kielinäkymä
//        GroupLayout layoutti = new GroupLayout(c);
//        c.setLayout(layoutti);
//        
//        layoutti.setAutoCreateGaps(true);
//        layoutti.setAutoCreateContainerGaps(true);        
//        
//        layoutti.setHorizontalGroup(layoutti.createParallelGroup().addComponent(logo));             
//        layoutti.setHorizontalGroup(layoutti.createSequentialGroup().addComponent(suomi).addComponent(englanti).addComponent(espanja));
//               
//        c.add(suomi);

        BoxLayout layout = new BoxLayout(c, BoxLayout.Y_AXIS);
        c.setLayout(layout);

        //resourcebundels
        ResourceBundle bundleFi = ResourceBundle.getBundle("hymiopeli", new Locale("fi", "FI"));
        ResourceBundle bundleEn = ResourceBundle.getBundle("hymiopeli", new Locale("en", "US"));
        ResourceBundle bundleEsp = ResourceBundle.getBundle("hymiopeli", new Locale("es", "ES"));
        ResourceBundle activeBundle = bundleFi;

        //buttons
        JButton uusiPeli = new JButton(activeBundle.getString("uusipeli"));
        JButton hymio = new JButton("icon");

        //kuvat tulossa!
        JLabel tikru = new JLabel(new ImageIcon());
        JLabel ironman = new JLabel(new ImageIcon());

        JButton highscore = new JButton(activeBundle.getString("highscore"));
        JButton poistu = new JButton(activeBundle.getString("poistu"));

        //kuuntelijat
        frame.addMouseListener(new NapinKuuntelija());

        //paneeli
        JPanel kuvioPaneeli = new JPanel();
        GridLayout kuvioPaneeliLayout = new GridLayout(1, 3);
        kuvioPaneeli.setLayout(kuvioPaneeliLayout);

        //paneeliin lisäys
        kuvioPaneeli.add(hymio);
        kuvioPaneeli.add(tikru);
        kuvioPaneeli.add(ironman);

        //contentPane-lisäys
        c.add(logo);
        c.add(uusiPeli);
        c.add(kuvioPaneeli);
        c.add(highscore);
        c.add(poistu);

    }

}
