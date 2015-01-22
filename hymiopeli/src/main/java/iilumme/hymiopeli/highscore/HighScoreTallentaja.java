package iilumme.hymiopeli.highscore;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScoreTallentaja {

    private File tiedosto;
    private Scanner scanner;

    private ArrayList<HighScore> toplista;

    public HighScoreTallentaja() throws Exception {
        this.tiedosto = new File("/Users/iina/hymiopeli/hymiopeli/src/main/java/iilumme/hymiopeli/highscore/highscorelista.txt");
        this.scanner = new Scanner(tiedosto);

        this.toplista = new ArrayList<>();
        haeScoret();
    }

    public String haeLista() {

        String lista = new String();

        if (scanner.hasNextLine()) {
            lista += scanner.nextLine();
            lista += ':';
        }

        return lista;
    }

    private void haeScoret() {

        String[] scoret = haeLista().split(":");

        if (scoret.length > 1) {

            for (int i = 0; i < scoret.length; i++) {
                String[] score = scoret[i].split(",");

                this.toplista.add(new HighScore(score[0], Integer.parseInt(score[1])));
            }
        }

    }

    public void lisaaHighscore(String nimi, int pisteet) {

        toplista.add(new HighScore(nimi, pisteet));
        Collections.sort(toplista);

    }
    
    public HighScore getEka() {
        
        if (toplista.isEmpty()) {
            return null;
        }
        return toplista.get(0);
    }

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
