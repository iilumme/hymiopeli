package iilumme.hymiopeli.highscore;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HighScoreTallentaja {

    private String tiedostonNimi;
    private FileWriter kirjoitin;
    private Scanner scanner;
    
    private ArrayList<HighScore> toplista;

    public HighScoreTallentaja() throws Exception {
        this.tiedostonNimi = "/Users/iina/hymiopeli/hymiopeli/src/main/java/iilumme/hymiopeli/highscore/highscorelista.txt";
        this.kirjoitin = new FileWriter(tiedostonNimi, true);
        this.scanner = new Scanner(tiedostonNimi);       
        
        this.toplista = new ArrayList<>();      
        //haeScoret();
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

        for (int i = 0; i < scoret.length; i++) {
            String[] score = scoret[i].split(",");

            this.toplista.add(new HighScore(score[0], Integer.parseInt(score[1])));
        }

    }

    public void lisaaHighscore(String nimi, int pisteet) {

        toplista.add(new HighScore(nimi, pisteet));
        paivitaLista();

    }

    private void paivitaLista() {

        Collections.sort(toplista);

        try {

            for (HighScore score : toplista) {
                kirjoitin.write(score + "\n");
            }
            kirjoitin.flush();
            kirjoitin.close();
        } catch (Exception e) {
            //hmmm
        }

    }

}
