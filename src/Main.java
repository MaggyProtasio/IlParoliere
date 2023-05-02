import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartPage window = new StartPage();
                    window.frameStartPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

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
                System.out.println("Parola trovata nel dizionario!");
                partita.aggiungiPunti(parolaInserita);
                System.out.println("Punti della parola: "+partita.puntiParola(parolaInserita));
                //contatore
                partita.contaParola();
            }else{
                System.out.println("Questa parola non esiste nel dizionario >:(");
            }
            i++;
        }while(i < 5);
        System.out.println("Punti della parita: "+partita.getPuntiTotali());
        System.out.println("Parole trovate: "+partita.getParolaNum());
        if(partita.controllaParolaMigliore()){
            System.out.println("Parola migliore: "+partita.getParolaMigliore());
        }else{
            //da sistemare per fare array di alice??
            System.out.println("Hai diverse parole migliori");
        }
    }
}