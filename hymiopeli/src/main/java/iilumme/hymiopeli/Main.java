package iilumme.hymiopeli;

import iilumme.hymiopeli.ui.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 * Käynnistää graaffisen käyttöliittymän, joka käynnistää kaiken muun.
 *
 * @author iina
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma());
    }
}
