/**
 * Abstrakti luokka Pelaaja tarkentaa hahmojen, joilla pelataan, metodeja.
 */

package iilumme.hymiopeli.pelihahmot;

public abstract class Pelaaja extends Hahmo {

    /**
     * Pelaaja-oliot aloittavat aina samasta pisteestä (50,300).
     */
    public Pelaaja() {
        super(50, 300);
    }

    /**
     * Metodi siirtää oliota. Rajojen yli ei voida siirtää oliota.
     * 
     * @param dx liike x-akselilla. "Käyttäjän antama syöte"
     * @param dy liike y-akselilla. "Käyttäjän antama syöte"
     */
    @Override
    public void siirra(int dx, int dy) {
        if (x + dx > -1 && x + dx < 601 && y + dy > -1 && y + dy < 476) {
            x += dx;
            y += dy;
        } else if (x + dx < 0) {
            x = 0;
        } else if (y + dy < 0) {
            y = 0;
        } else if (x + dx > 600) {
            x = 600;
        } else if (y + dy > 475) {
            y = 475;
        }

    }

}
