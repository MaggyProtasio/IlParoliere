import java.io.*;
import java.util.ArrayList;

public class Dizionario {
    private String parola;

    public Dizionario(String parola) {
        this.parola = parola;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void Trovaparola(String p){
        FileReader f;
        try {
            f=new FileReader("660000_parole_italiane.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader b;
        b=new BufferedReader(f);

        String parolaDizionario;

        try {
            while(true) {
                parolaDizionario = b.readLine();
                if (parolaDizionario == null) {
                    break;
                } else {
                    if (true) {
                        System.out.println(parolaDizionario);
                    }
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
