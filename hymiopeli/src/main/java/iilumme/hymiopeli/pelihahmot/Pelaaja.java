/**
 * Abstrakti luokka Pelaaja tarkentaa pelattavien hahmojen metodeja.
 */
package iilumme.hymiopeli.pelihahmot;

public abstract class Pelaaja extends Hahmo {

    /**
     * Pelaaja-oliot aloittavat aina samasta pisteestä (50,300).
     */
    public Pelaaja() {
        super(50, 300);
    }

    @Override
    public void siirra(int dx, int dy) {
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
    }

    /**
     * Muuttaa hahmon värimaailman. Metodi on muutettuille hahmoille
     * tarkoitettu.
     */
    public abstract void muutaVari();

}
