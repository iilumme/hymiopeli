package iilumme.hymiopeli.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HahmoPanel extends JPanel {

    public HahmoPanel() {
        super(new GridLayout(1, 3));
        luoKomponentit();
        setBackground(new Color(178, 97, 240));
    }

    private void luoKomponentit() {

        JLabel hymio = new JLabel("hymiö tulossa");
        JLabel tikru = new JLabel(new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/tiger.jpg"));
        JLabel ironman = new JLabel(new ImageIcon("/Users/iina/hymiopeli/hymiopeli/Images/ironman.png"));

        add(hymio);
        add(tikru);
        add(ironman);
    }

    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }

}
