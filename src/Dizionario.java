import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files

public class Dizionario {
    private String parola;
    String[] words = new String[661563]; // parole in file NON MODIFICARE

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public Dizionario() {

    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public boolean trovaParoladiz(String p){
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

    public boolean trovaParolaComuni(String p){
        boolean b = false;
        try {
            String filePath = "src/ParoleComuni.txt"; // filename and Main.java are in the same folder
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

    public void stampaWords(){

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
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

    public void inizializzaWords() {
            String filePath = "src/ParoleComuni.txt"; // filename and Main.java are in the same folder
            File file = new File(filePath);
            try {
                Scanner scanner = new Scanner(file);
                int i = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] lineWords = line.split(" "); // Split della riga
                    for (String word : lineWords) {
                        this.words[i] = word; // metti parola in array wors
                        i++;
                    }
                }
                scanner.close();
                // Now you can use the 'words' array to process the words as needed
               // System.out.println("parole totali: " + i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
