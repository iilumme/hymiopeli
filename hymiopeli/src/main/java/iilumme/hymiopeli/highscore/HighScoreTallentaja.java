/**
 * Luokka ylläpitää tietoa parhaista pelituloksista. Tallentaa HighScore-olioita
 * ja lukee tiedostosta.
 */
package iilumme.hymiopeli.highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScoreTallentaja {

    private File tiedosto;
    private Scanner scanner;

    private ArrayList<HighScore> toplista;

    public HighScoreTallentaja() throws IOException {

        this.tiedosto = new File("highscorelista.txt");

        if (!this.tiedosto.exists()) {
            this.tiedosto.createNewFile();
        }

        this.scanner = new Scanner(tiedosto);

        this.toplista = new ArrayList<>();
        haeLista();
    }

    /**
     * Haetaan tiedostosta Highscorelista ja laitetaan highscoret listaan.
     *
     */
    public void haeLista() {

        while (scanner.hasNextLine()) {

            String[] score = scanner.nextLine().split(",");

            this.toplista.add(new HighScore(score[0], Integer.parseInt(score[1])));

        }
        scanner.close();

    }

    /**
     * Lisätään HighScore listaan.
     *
     * @param nimi Pelaajan nimi
     * @param pisteet Pelaajan saamat pisteet
     */
    public void lisaaHighscore(String nimi, int pisteet) {

        toplista.add(new HighScore(nimi, pisteet));

    }

    /**
     * Haetaan HighScorelistan ensimmäinen pelaaja&pisteet
     *
     * @return HighScore-olio
     */
    public HighScore getEka() {

        if (toplista.isEmpty()) {
            return null;
        }
        return toplista.get(0);
    }

    /**
     * Haetaan Highscoret Arraylistinä
     *
     * @return StringBuilder
     */
    public ArrayList<HighScore> getHighscoret() {

        Collections.sort(toplista);
        return this.toplista;

    }

    /**
     * Päivitetään tiedostoon lista.
     */
    public void paivitaLista() {

        try {
            FileWriter kirjoitin = new FileWriter(tiedosto, false);
            try {
                for (HighScore score : toplista) {
                    kirjoitin.write(score.toString() + "\n");
                }
                kirjoitin.flush();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
