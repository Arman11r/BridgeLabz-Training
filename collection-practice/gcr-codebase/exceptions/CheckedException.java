import java.io.*;

public class CheckedException{

    public static void main(String[] args) {

        String fileName = "temp.txt"; 
//exception handling
        try {
    
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            // file not found or other io issue here
            System.out.println("File not found");
        }
    }
}