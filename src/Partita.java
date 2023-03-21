public class Partita {
    public int puntiTotali;
    public Utente utente;
    public String parolaMigliore;
    public int parolaNum;

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
    public boolean controllaParolaMigliore(String parola){
        if(parola.length() > parolaMigliore.length()){
            parolaMigliore = parola;
            return true;
        }else{
            return false;
        }
    }

    public int puntiParola(String parola){
        int lunghezzaParola = parola.length();
        int k = 100;            //costante
        int punti = lunghezzaParola * k;
        return punti;
    }

    public void contaParola(){
        parolaNum++;
    }



}
