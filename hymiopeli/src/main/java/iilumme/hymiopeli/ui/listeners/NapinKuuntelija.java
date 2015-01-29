package iilumme.hymiopeli.ui.listeners;

import iilumme.hymiopeli.ui.KieliPanel;
import iilumme.hymiopeli.util.KieliUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class NapinKuuntelija implements ActionListener {

    private JButton nappi;
    private KieliPanel panel;

    public NapinKuuntelija(JButton nappi, KieliPanel panel) {
        this.nappi = nappi;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        KieliUtil.setLanguage(nappi.getText());
        panel.asetaPois();
        
    }

}
