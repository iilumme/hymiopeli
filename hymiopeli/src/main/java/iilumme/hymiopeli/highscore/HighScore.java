/**
 * Luokka tarjoaa käyttöön HighScore-olioita, joita hyödynnetään, kun pelaajien highscoreja tallennetaan.
 * Luokan oliot ovat verrattavissa toistensa kanssa.
 * 
 */
package iilumme.hymiopeli.highscore;

public class HighScore implements Comparable<HighScore> {

    private int pisteet;
    private String nimi;

    public HighScore(String nimi, int pisteet) {
        this.pisteet = pisteet;
        this.nimi = nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }
    /**
     * Verrataan kahta HighScorea toisiinsa.
     * @param o toinen HighScore
     * @return suuremman kahdesta
     */

    @Override
    public int compareTo(HighScore o) {
        return o.getPisteet() - this.pisteet;
    }

    @Override
    public String toString() {
        return this.nimi + "," + this.pisteet;
    }

}
