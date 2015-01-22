
package iilumme.hymiopeli.highscore;


public class HighScore implements Comparable<HighScore>{
    
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

    @Override
    public int compareTo(HighScore o) {
        return o.getPisteet() - this.pisteet;
    }

    @Override
    public String toString() {
        return this.nimi + "," +  this.pisteet;
    }
    
    
    
}
