import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files

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

    public boolean trovaParola(String p){
        boolean b = false;
        p = "abati";
        try {
            String filePath = "src/dictionary.txt"; // filename and Main.java are in the same folder
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                if(p.equals(line)){
                    System.out.println(line+"-----");
                    b = true;
                    break;
                }
                line = reader.readLine();
            }
            System.out.println("FINE");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
