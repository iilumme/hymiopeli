
package iilumme.hymiopeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    private Piirtoalusta piirtoalusta;

    public Kayttoliittyma() {
        this.piirtoalusta = new Piirtoalusta();
    }
    

    @Override
    public void run() {
        frame = new JFrame("Hymiöpeli");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        lisaaKuuntelijat();
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {
        
        BoxLayout layout = new BoxLayout(c, BoxLayout.Y_AXIS);
        c.setLayout(layout);       
        
        //otsikko
        JLabel logo = new JLabel(new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/logo.png"));
        
        
        //buttons
        JButton uusiPeli = new JButton("Uusi peli");
        JButton hymio = new JButton("icon");
        JButton tiikeri = new JButton("icon");
        JButton ironman = new JButton("icon");
        JButton highscore = new JButton("Highscore");
        JButton poistu = new JButton("Poistu");
                
        //ulkonäkö
        uusiPeli.setSize(new Dimension(100, 30));
        hymio.setPreferredSize(new Dimension(30, 30));
        tiikeri.setPreferredSize(new Dimension(30, 30));
        ironman.setPreferredSize(new Dimension(30, 30));
        highscore.setPreferredSize(new Dimension(100, 30));
        poistu.setPreferredSize(new Dimension(100, 30));
            
        //paneeli
        JPanel kuvioPaneeli = new JPanel();
        kuvioPaneeli.setLayout(new GridLayout(1, 3));
        
        kuvioPaneeli.add(hymio);
        kuvioPaneeli.add(tiikeri);
        kuvioPaneeli.add(ironman);
        
        //contentPane-lisäys
        c.add(logo);
        c.add(uusiPeli);
        c.add(kuvioPaneeli);
        c.add(highscore);
        
    }

    private void lisaaKuuntelijat() {
        
    }
    
}
