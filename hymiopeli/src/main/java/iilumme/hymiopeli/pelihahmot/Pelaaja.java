package iilumme.hymiopeli.pelihahmot;

/**
 * Abstrakti luokka Pelaaja tarkentaa pelattavien hahmojen metodeja.
 */
public abstract class Pelaaja extends Hahmo {

    private boolean muutettu;

    /**
     * Pelaaja-oliot aloittavat aina samasta pisteestä (50,300).
     */
    public Pelaaja() {
        super(50, 300);
        muutettu = false;
    }

    @Override
    public void siirra(int dx, int dy) {
        if (!muutettu) {
            if (x + dx > -1 && x + dx < 556 && y + dy > -1 && y + dy < 421) {
                x += dx;
                y += dy;
            } else if (x + dx < 0) {
                x = 0;
            } else if (y + dy < 0) {
                y = 0;
            } else if (x + dx > 555) {
                x = 550;
            } else if (y + dy > 420) {
                y = 420;
            }
        } else {
            x += dx;
            y += dy;
        }
    }

    public boolean onkoMuutettu() {
        return muutettu;
    }

    public void setMuutettu(boolean muutettu) {
        this.muutettu = muutettu;
    }

    /**
     * Muuttaa hahmon värimaailman. Metodi on muutetuille hahmoille tarkoitettu.
     */
    public abstract void muutaVari();

}
