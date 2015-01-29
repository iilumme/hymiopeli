
package iilumme.hymiopeli;

import iilumme.hymiopeli.ui.Kayttoliittyma;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws Exception {
        
        SwingUtilities.invokeLater(new Kayttoliittyma());    

    }

}
