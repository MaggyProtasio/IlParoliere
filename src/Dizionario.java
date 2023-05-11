import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files

public class Dizionario {
    private String parola;
    String[] words = new String[661563]; // parole in file NON MODIFICARE

    public Dizionario() {

    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public boolean trovaParola(String p){
        boolean b = false;
        try {
            String filePath = "src/dictionary.txt"; // filename and Main.java are in the same folder
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                if(p.equals(line)){
                    System.out.println(line+" - trovato :D");
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

    public boolean stampaParole(String p){
        boolean b = false;
        try {
            String filePath = "src/dictionary.txt"; // filename and Main.java are in the same folder
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                if(p.equals(line)){
                    System.out.println(line+" - trovato :D");
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

    public String[] leggiParole() {
            String filePath = "src/dictionary.txt"; // filename and Main.java are in the same folder
            File file = new File(filePath);
            try {
                Scanner scanner = new Scanner(file);
                int i = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] lineWords = line.split(" "); // Split della riga
                    for (String word : lineWords) {
                        words[i] = word; // metti parola in array wors
                        i++;
                    }
                }
                scanner.close();
                // Now you can use the 'words' array to process the words as needed
               // System.out.println("parole totali: " + i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return words;
        }
    }
