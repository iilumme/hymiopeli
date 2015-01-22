
package iilumme.hymiopeli;

import iilumme.hymiopeli.gui.Kayttoliittyma;
import iilumme.hymiopeli.highscore.HighScoreTallentaja;
import iilumme.hymiopeli.logiikka.HymioPeli;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws Exception {
        
        SwingUtilities.invokeLater(new Kayttoliittyma());
        


        
    }

}
