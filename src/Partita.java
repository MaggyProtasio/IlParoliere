import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class Partita {
    public int puntiTotali;
    public Utente utente;
    public String parolaMigliore;
    public int parolaNum;

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

    /***************************************************************/
    //funzione che inizializza il tabellone di gioco
    public void InizializzaTabellone(){
        char[][] tabellone = new char[6][6];
        char[] lettere = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int index = (int) (Math.random() * lettere.length);
                tabellone[i][j] = lettere[index];
            }
        }
    }

}
