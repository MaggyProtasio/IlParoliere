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

    public void Trovaparola(String p){

        try {
            File myObj = new File("dictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
               // if(p.equals(data)){}
                System.out.println(data);

            }
                myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
