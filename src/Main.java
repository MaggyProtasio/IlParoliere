import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Oggetti e variabili
        Dizionario diz = new Dizionario();
        Scanner in = new Scanner(System.in);
        String nickname;
        String parolaInserita = "";

        //creazione utente
        System.out.println("Benvenuto nel paroliere!");
        System.out.println("Inserisci il nickname");
        nickname = in.nextLine();

        Utente giocatore = new Utente(nickname);
        Partita partita = new Partita(giocatore);

        //creazione partita
        System.out.println("Inzia giocare!");
        int i = 0;
        do {
            System.out.println("Parola " + (i+1) + " \nInserisci una parola");
            parolaInserita = in.nextLine();
            //trova parola
            if(diz.trovaParola(parolaInserita)){
                    if(partita.doppione(parolaInserita) == false){
                        System.out.println("Parola trovata nel dizionario!");
                        partita.aggiungiPunti(parolaInserita);
                        System.out.println("Punti della parola: "+partita.puntiParola(parolaInserita));
                        //contatore
                        partita.contaParola();
                    }else{
                        System.out.println("Hai già inserito questa parola >:(");
                    }
            }else{
                System.out.println("Questa parola non esiste nel dizionario >:(");
            }
            i++;
        }while(i < 5);
        System.out.println("Punti della parita: "+partita.getPuntiTotali());
        System.out.println("Parole trovate: "+partita.getParolaNum());
        //stampa la prima parola inserita migliore
        partita.controllaParolaMigliore();
        System.out.println("Parola migliore: "+partita.getParolaMigliore());
    }
}