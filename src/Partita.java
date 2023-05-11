import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class Partita {
    public int puntiTotali;
    public Utente utente;
    public String parolaMigliore;
    public int parolaNum;

    static char[][] tabellone = new char[7][7];
    /*char[] lettere = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};*/

    Vector<String> paroleArray= new Vector<>();
    Vector<String> paroleArray2= new Vector<>();

    //costruttore
    public Partita(Utente u){
        this.utente = utente;
        this.puntiTotali = 0;
        this.parolaMigliore = null;
    }

    // getter e setter
    public int getPuntiTotali() {
        return puntiTotali;
    }
    public void setPuntiTotali(int puntiTotali) {
        this.puntiTotali = puntiTotali;
    }
    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public String getParolaMigliore() {
        return parolaMigliore;
    }
    public void setParolaMigliore(String parolaMigliore) {
        this.parolaMigliore = parolaMigliore;
    }
    public int getParolaNum() {
        return parolaNum;
    }
    public void setParolaNum(int parolaNum) {
        this.parolaNum = parolaNum;
    }

    //metodi
    public void aggiungiPunti(String parola){
        int lunghezzaParola = parola.length();
        int k = 100;            //costante
        int punti = lunghezzaParola * k;
        puntiTotali = puntiTotali + punti;
    }
    public boolean controllaParolaMigliore() {
        String best = "";
        boolean unique = true;
        Iterator<String> i = paroleArray.iterator();
        while (i.hasNext()) {
            String parola = i.next();
            if (parola.length() > best.length()) {
                best = parola;
                unique = true;
            } else if (parola.length() == best.length() && !parola.equals(best)) {
                unique = false;
            }
        }
        setParolaMigliore(best);
        return unique;
    }

    public int puntiParola(String parola){
        int lunghezzaParola = parola.length();
        int k = 100;            //costante
        int punti = lunghezzaParola * k;
        paroleArray.add(parola);
        return punti;
    }

    public void contaParola(){
        parolaNum++;
    }

    public boolean doppione(String parolaInserita){
        boolean d = false; //doppione
        int size = paroleArray.size(); //grandezza array
        for(int x=0; x<size; x++){ //ciclo vettore grande
            if(parolaInserita.equals(paroleArray.get(x))){
                d = true;
            }
        }
        return d;
    }

    //metodo per creare un vettore inizializato con lettere casuali
    public void matriceRandomInizio(){
        Random rand = new Random();
        // riempimento casuale della matrice con lettere dell'alfabeto
        for (int i = 0; i < tabellone.length; i++) {
            for (int j = 0; j < tabellone[i].length; j++) {
                // genero valore casuale tra 'a' e 'z' e lo metto in maiuscolo
                tabellone[i][j] = Character.toUpperCase((char) (rand.nextInt(26) + 'a'));
            }
        }
    }

    // controlla se è possibile inserire una parola nella matrice in una determinata posizione e direzione
    public static boolean canInsertWord(String word, int row, int col, int dir) {
        int dx = 0;
        int dy = 0;
        if (dir == 0) {
            dy = 1;
        } else if (dir == 1) {
            dx = 1;
            dy = 1;
        } else if (dir == 2) {
            dx = 1;
        } else if (dir == 3) {
            dx = 1;
            dy = -1;
        } else if (dir == 4) {
            dy = -1;
        } else if (dir == 5) {
            dx = -1;
            dy = -1;
        } else if (dir == 6) {
            dx = -1;
        } else if (dir == 7) {
            dx = -1;
            dy = 1;
        }
        int x = col;
        int y = row;
        for (int i = 0; i < word.length(); i++) {
            // controlla se la posizione è all'interno della matrice
            if (x < 0 || x >= tabellone[0].length || y < 0 || y >= tabellone.length) {
                return false;
            }

            // controlla se la posizione è già occupata da un'altra lettera
            if (tabellone[y][x] != '\u0000' && tabellone[y][x] != word.charAt(i)) {
                System.out.println("La posizione (" + y + ", " + x + ") è già occupata da " + tabellone[y][x] + " e non da " + word.charAt(i));
                return false;
            }
            x += dx;
            y += dy;
        }
        return true;
    }
    
    // inserisce una parola nella matrice in una determinata posizione e direzione
    public static void inserisciParola(String word, int row, int col, int dir) {
        int dx = 0;
        int dy = 0;
        if (dir == 0) {
            dy = 1;
        } else if (dir == 1) {
            dx = 1;
            dy = 1;
        } else if (dir == 2) {
            dx = 1;
        } else if (dir == 3) {
            dx = 1;
            dy = -1;
        } else if (dir == 4) {
            dy = -1;
        } else if (dir == 5) {
            dx = -1;
            dy = -1;
        } else if (dir == 6) {
            dx = -1;
        } else if (dir == 7) {
            dx = -1;
            dy = 1;
        }
        int x = col;
        int y = row;
        for (int i = 0; i < word.length(); i++) {
            tabellone[y][x] = word.charAt(i);
            x += dx;
            y += dy;
        }
    }

    //metodo per inserire parole dentro la matrice da un array che ha nomi presi dal file
    public void inserisciParoleMatrice(String words[]){
        Random rand = new Random();
        int maxTentativi = 10; // Numero massimo di tentativi per ogni parola
        for (String word : words) {
            boolean inserted = false;
            int tentativi = 0;
            while (!inserted && tentativi < maxTentativi) {
                int row = rand.nextInt(tabellone.length);
                int col = rand.nextInt(tabellone[row].length);
                int dir = rand.nextInt(8);
                if (canInsertWord(word, row, col, dir)) {
                    inserisciParola(word, row, col, dir);
                    inserted = true;
                }
                tentativi++;
            }
            if (!inserted) {
                System.out.println("Non è stato possibile inserire la parola " + word);
            }
        }
    }

}
