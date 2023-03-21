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
    public void controllaParolaMigliore(String parola) {
        String best = "";
        Iterator<String> i = paroleArray.iterator();
        while (i.hasNext()) {
            String parolatmp = i.next();
            System.out.println(parolatmp.length());
            System.out.println(parola.length());
            if (parolatmp.length() < parola.length()) {
                if(best.length() < parola.length()){

                }
                //per trovare la parola piu lunga
                best = parola;
                setParolaMigliore(best);
                System.out.println(best);
            }
        }
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

}
