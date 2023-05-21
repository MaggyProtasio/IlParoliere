import javax.sound.sampled.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException,LineUnavailableException {

        //creazione dizionario e variabili
        Dizionario diz = new Dizionario();
        Scanner in = new Scanner(System.in);
        String nickname;
        String parolaInserita = "";
        Random rand = new Random();
        
        //creazione utente
        System.out.println("Benvenuto nel paroliere!");
        System.out.println("Inserisci il nickname");
        nickname = in.nextLine();
        Utente giocatore = new Utente(nickname);

        //creazione partita e matrice
        System.out.println("Press Enter to start");
        in.nextLine();
        Partita partita = new Partita(giocatore);
        diz.inizializzaWords();         //mette tutti parole comuni nell'array per usarlo dopo
        partita.creaMatrice(diz.getWords());
        //partita.stampaMatrice();
        //partita.stampaMatriceSemplice();
        //inizia gioco con GUI
        StartPage s = new StartPage();

        //per audio background ----------------------------------------------
        File file = new File("src/audio/hehe.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip =  AudioSystem.getClip();
        clip.open(audiostream);

        clip.start(); //per far inizare l'audio

        int i = 0;
        do {
            System.out.println("******** Parola " + (i + 1) + " ******** \nInserisci una parola");
            parolaInserita = in.nextLine();

            //controlla se parola esiste nella matrice
            String parolaInseritaUpper = parolaInserita.toUpperCase();
            boolean trovata = partita.trovaParolaMatrice(parolaInseritaUpper);
            if (trovata) {
                System.out.println("Parola " + parolaInserita + " esiste nella matrice!");

                //controlla se parola esiste nel dizionario
                if (diz.trovaParoladiz(parolaInserita)) {
                    if (partita.doppione(parolaInserita) == false) {
                        System.out.println("Parola trovata nel dizionario!");
                        partita.aggiungiPunti(parolaInserita);
                        System.out.println("Punti della parola: " + partita.puntiParola(parolaInserita));
                        //contatore
                        partita.contaParola();
                    } else {
                        System.out.println("Hai già inserito questa parola >:(");
                    }
                } else {
                    System.out.println("Questa parola non esiste nel dizionario >:(");
                }
            } else {
                System.out.println("Parola " + parolaInserita + " non esiste nella matrice :(");
            }
            i++;        //incrementa tentativi
        } while (i < 5);        //numero dei tentativi per finire il gioco
        System.out.println("Punti della parita: " + partita.getPuntiTotali());
        System.out.println("Parole trovate: " + partita.getParolaNum());
        //stampa la prima parola inserita migliore
        partita.controllaParolaMigliore();
        System.out.println("Parola migliore: " + partita.getParolaMigliore());
    }
}