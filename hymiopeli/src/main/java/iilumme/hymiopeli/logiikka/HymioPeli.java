package iilumme.hymiopeli.logiikka;

import iilumme.hymiopeli.highscore.HighScoreTallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class HymioPeli extends javax.swing.Timer implements ActionListener {
    
    private HighScoreTallentaja highscoreLista;
    private int leveys;
    private int korkeus;
    private boolean jatkuukoPeli;

    public HymioPeli(int leveys, int korkeus) throws Exception{
        super(1000, null);
        
        this.highscoreLista = new HighScoreTallentaja();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuukoPeli = true;
        
        addActionListener(this);
        setInitialDelay(1000);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
