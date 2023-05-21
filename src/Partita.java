import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.Random;
public class Partita {
    public int puntiTotali;
    public Utente utente;
    public String parolaMigliore;
    public int parolaNum;
    public char[][] matrice;

    Vector<String> paroleArray= new Vector<>();

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

    public char[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(char[][] matrice) {
        this.matrice = matrice;
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

    public void creaMatrice(String[] words){

        char[][] matrix = new char[10][10];
        Random random = new Random();
        String[] wordsInject = new String[10];

        // Populate wordsInject array with 10 words of length 10 or less
        for (int i = 0; i < wordsInject.length; i++) {
            String randomWord;
            do {
                int randomIndex = random.nextInt(words.length);
                randomWord = words[randomIndex];
            } while (randomWord.length() > 10);
            wordsInject[i] = randomWord.toUpperCase();
            System.out.println("parola added - " + wordsInject[i]);
        }

        // Insert Italian words horizontally
        for (int i = 0; i < wordsInject.length; i++) {
            String word = wordsInject[i];
            int wordLength = word.length();
            int row = random.nextInt(10);
            int col = random.nextInt(10 - wordLength + 1);

            for (int j = 0; j < wordLength; j++) {
                matrix[row][col + j] = word.charAt(j);
            }
        }

        // Insert Italian words diagonally
        for (int i = 0; i < wordsInject.length; i++) {
            String word = wordsInject[i];
            int wordLength = word.length();
            int row = random.nextInt(10 - wordLength + 1);
            int col = random.nextInt(10 - wordLength + 1);

            for (int j = 0; j < wordLength; j++) {
                matrix[row + j][col + j] = word.charAt(j);
            }
        }

        // Insert Italian words vertically
        for (int i = 0; i < wordsInject.length; i++) {
            String word = wordsInject[i];
            int wordLength = word.length();
            int row = random.nextInt(10 - wordLength + 1);
            int col = random.nextInt(10);

            for (int j = 0; j < wordLength; j++) {
                matrix[row + j][col] = word.charAt(j);
            }
        }


        // Fill remaining empty slots with random letters
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[i][j] == '\u0000') {
                    matrix[i][j] = (char) (random.nextInt(26) + 'A');
                }
            }
        }

        this.matrice = matrix;
    }

    public void stampaMatrice(){
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < this.matrice[i].length; j++) {
                System.out.print("┌───┐\t"); // Top border
            }
            System.out.println();

            for (int j = 0; j < this.matrice[i].length; j++) {
                System.out.printf("│ %c │\t", this.matrice[i][j]); // Cell content
            }
            System.out.println();

            for (int j = 0; j < this.matrice[i].length; j++) {
                System.out.print("└───┘\t"); // Bottom border
            }
            System.out.println();
        }
    }

    public boolean trovaParolaMatrice(String word) {
        char[][] matrix = this.matrice;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int wordLength = word.length();

        // Check horizontally (left to right)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - wordLength; j++) {
                boolean found = true;
                for (int k = 0; k < wordLength; k++) {
                    if (matrix[i][j + k] != word.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        // Check horizontally (right to left)
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= wordLength - 1; j--) {
                boolean found = true;
                for (int k = 0; k < wordLength; k++) {
                    if (matrix[i][j - k] != word.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        // Check vertically (top to bottom)
        for (int i = 0; i <= rows - wordLength; i++) {
            for (int j = 0; j < cols; j++) {
                boolean found = true;
                for (int k = 0; k < wordLength; k++) {
                    if (matrix[i + k][j] != word.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        // Check vertically (bottom to top)
        for (int i = rows - 1; i >= wordLength - 1; i--) {
            for (int j = 0; j < cols; j++) {
                boolean found = true;
                for (int k = 0; k < wordLength; k++) {
                    if (matrix[i - k][j] != word.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        // Check diagonally (top-left to bottom-right)
        for (int i = 0; i <= rows - wordLength; i++) {
            for (int j = 0; j <= cols - wordLength; j++) {
                boolean found = true;
                for (int k = 0; k < wordLength; k++) {
                    if (matrix[i + k][j + k] != word.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        // Check diagonally (bottom-left to top-right)
        for (int i = wordLength - 1; i < rows; i++) {
            for (int j = 0; j <= cols - wordLength; j++) {
                boolean found = true;
                for (int k = 0; k < wordLength; k++) {
                    if (matrix[i - k][j + k] != word.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWord(char[][] matrix, String word, int row, int col, int rowStep, int colStep) {
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length ||
                    matrix[row][col] != word.charAt(i)) {
                return false;
            }
            row += rowStep;
            col += colStep;
        }
        return true;
    }
}
