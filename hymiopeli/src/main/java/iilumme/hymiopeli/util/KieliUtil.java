package iilumme.hymiopeli.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Apuluokka, jonka avulla haetaan oikean kielinen teksti.
 */
public class KieliUtil {

    private static final ResourceBundle BUNDLEFI = ResourceBundle.getBundle("hymiopeli", new Locale("fi", "FI"));
    private static final ResourceBundle BUNDLEEN = ResourceBundle.getBundle("hymiopeli", new Locale("en", "UK"));
    private static final ResourceBundle BUNDLEESP = ResourceBundle.getBundle("hymiopeli", new Locale("es", "ES"));
    private static ResourceBundle activeBundle = BUNDLEFI;

    /**
     * Hakee tekstin.
     *
     * @param teksti avain tekstille, joka halutaan
     * @return haluttu teksti
     */
    public static String getString(String teksti) {
        return activeBundle.getString(teksti);
    }

    /**
     * Asettaa kielen.
     *
     * @param kieli käyttäjän valitsema kieli.
     */
    public static void setLanguage(String kieli) {

        switch (kieli) {
            case "FI":
                activeBundle = BUNDLEFI;
                break;
            case "EN":
                activeBundle = BUNDLEEN;
                break;
            case "ES":
                activeBundle = BUNDLEESP;
                break;
        }

    }

}
