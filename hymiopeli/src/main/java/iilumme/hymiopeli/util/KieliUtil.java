package iilumme.hymiopeli.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class KieliUtil {

    private static final ResourceBundle bundleFi = ResourceBundle.getBundle("hymiopeli", new Locale("fi", "FI"));
    private static final ResourceBundle bundleEn = ResourceBundle.getBundle("hymiopeli", new Locale("en", "UK"));
    private static final ResourceBundle bundleEsp = ResourceBundle.getBundle("hymiopeli", new Locale("es", "ES"));
    private static ResourceBundle activeBundle = bundleFi;

    public static String getString(String teksti) {
        return activeBundle.getString(teksti);
    }

    public static void setLanguage(String kieli) {

        switch (kieli) {
            case "FI":
                activeBundle = bundleFi;
                break;
            case "EN":
                activeBundle = bundleEn;
                break;
            case "ES":
                activeBundle = bundleEsp;
                break;
        }

    }

}
