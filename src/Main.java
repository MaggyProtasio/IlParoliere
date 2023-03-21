import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //per iserimento dati
        Scanner in = new Scanner(System.in);
        String nickname;

        System.out.println("Benvenuto nel paroliere!");
        System.out.println("Inserisci il nickname");
        nickname=in.nextLine();

        //creo giocatore + scelta nickname (inserito da utente in precedenza)
        Utente giocatore = new Utente(nickname);

        System.out.println(giocatore.getNickname());


    }
}