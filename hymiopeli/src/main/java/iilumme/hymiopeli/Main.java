
package iilumme.hymiopeli;

import iilumme.hymiopeli.highscore.HighScore;
import iilumme.hymiopeli.highscore.HighScoreTallentaja;
import iilumme.hymiopeli.ui.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws Exception {
        
        SwingUtilities.invokeLater(new Kayttoliittyma());
        
//        HighScoreTallentaja uuss = new HighScoreTallentaja();
//
//        uuss.lisaaHighscore("iina", 21);
//        uuss.lisaaHighscore("hoho", 5);
//        uuss.lisaaHighscore("abc", 1000);
        

    }

}
