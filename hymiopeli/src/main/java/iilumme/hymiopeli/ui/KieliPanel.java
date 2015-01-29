
package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.ui.listeners.NapinKuuntelija;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class KieliPanel extends JPanel{

    private Container c;
    
    public KieliPanel(Container c) {
        super(new GridLayout(1, 3));
        this.c = c;
        luoKomponentit();
        setBackground(new Color(178, 97, 240));
    }

    private void luoKomponentit() {
        
        JButton suomi = new JButton("FI");
        JButton englanti = new JButton("EN");
        JButton espanja = new JButton("ES");
        
        suomi.addActionListener(new NapinKuuntelija(suomi, this));
        englanti.addActionListener(new NapinKuuntelija(englanti, this));
        espanja.addActionListener(new NapinKuuntelija(espanja, this));
        
        add(suomi);
        add(englanti);
        add(espanja);
        
    }
    
    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }
        
}
