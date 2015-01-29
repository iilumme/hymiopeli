package iilumme.hymiopeli.ui;

import iilumme.hymiopeli.util.KieliUtil;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ValikkoPanel extends JPanel {

    public ValikkoPanel() {
        super(new GridLayout(1, 3));
        luoKomponentit();
        setBackground(new Color(178, 97, 240));
    }

    private void luoKomponentit() {

        JButton uusiPeli = new JButton(KieliUtil.getString("uusipeli"));
        JButton highscore = new JButton(KieliUtil.getString("highscore"));
        JButton poistu = new JButton(KieliUtil.getString("poistu"));

        add(uusiPeli);
        add(highscore);
        add(poistu);
    }

    public void asetaPois() {
        setEnabled(false);
        setVisible(false);
    }

}
