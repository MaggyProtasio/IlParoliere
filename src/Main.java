import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Oggetti e variabili
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
        Partita partita = new Partita(giocatore);

        //provaAAAAAAAAAA
        partita.matriceRandomInizio();
        diz.inizializzaWords();

        diz.stampaWords();
        System.out.println("inizia stampa: /n");
        //diz.getWords();
        //partita.inserisciParoleMatrice(diz.getWords());
        //partita.stampaTabellone();

        //creazione partita
       /* System.out.println("Inzia giocare! Vuoi testare la matrice [1] o parole nel dizionario [2]?");
        int scelta = in.nextInt();
        in.nextLine();
        if(scelta == 1){
            //parte della matrice
            //prova 1
            partita.creaMatrice();
            partita.stampaMatrice();
            System.out.println("\nInserisci una parola");
            parolaInserita = in.nextLine();

            //controllo se parola esiste nella matrice (e anche se è una parola)
            boolean trovata = partita.trovaParolaMatrice(parolaInserita);
            if (trovata) {
                System.out.println("La parola " + parolaInserita + " esiste, brava!");
            } else {
                System.out.println("La parola " + parolaInserita + " non esiste nella matrice :(");
            }

            //prova 2
            System.out.println("\nInserisci una parola");
            parolaInserita = in.nextLine();
            //controllo se parola esiste nella matrice
            trovata = partita.trovaParolaMatrice(parolaInserita);
            if (trovata) {
                System.out.println("La parola " + parolaInserita + " esiste, brava!");
            } else {
                System.out.println("La parola " + parolaInserita + " non esiste nella matrice :(");
            }

            //prova 3
            System.out.println("\nInserisci una parola");
            parolaInserita = in.nextLine();
            //controllo se parola esiste nella matrice
            trovata = partita.trovaParolaMatrice(parolaInserita);
            if (trovata) {
                System.out.println("La parola " + parolaInserita + " esiste, brava!");
            } else {
                System.out.println("La parola " + parolaInserita + " non esiste nella matrice :(");
            }
        }else {*/

        int i = 0;
        do {
            System.out.println("Parola " + (i + 1) + " \nInserisci una parola");
            parolaInserita = in.nextLine();
            //trova parola
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
            i++;
        } while (i < 5);
        System.out.println("Punti della parita: " + partita.getPuntiTotali());
        System.out.println("Parole trovate: " + partita.getParolaNum());
        //stampa la prima parola inserita migliore
        partita.controllaParolaMigliore();
        System.out.println("Parola migliore: " + partita.getParolaMigliore());
    }

    }
