import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //per iserimento dati
        Scanner in = new Scanner(System.in);
        String nickname;

        System.out.println("Benvenuto nel paroliere!");
        System.out.println("Inserisci il nickname");
        nickname = in.nextLine();
        Utente giocatore = new Utente(nickname);
        Partita partita = new Partita(giocatore);

        System.out.println("Inzia giocare!");
        //inzio la partita
        String parolaInserita = "";
        for(int i = 1; i <= 5; i++){

            System.out.println("Parola " + i + " \nInserisci una parola");
            parolaInserita = in.nextLine();


        }



    }
}