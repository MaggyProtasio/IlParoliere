import java.io.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println(System.getProperty("user.dir"));
        boolean b = false;
        String p = "abaco";
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



    }
}