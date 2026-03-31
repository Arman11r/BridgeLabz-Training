import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileUsingFileReader 
{

    public static void main(String[] args) {

        try {
            // Create FileReader
            FileReader fr = new FileReader("sample.txt"); //demo file not in folder

            // Wrap with BufferedReader

            BufferedReader br = new BufferedReader(fr);

            String lines;

            // Read file line by line
            while ((lines = br.readLine()) != null) {
                System.out.println(lines);
            }

            // Close resources to prevent memory leak here
            br.close();
            fr.close ();

        } catch (Exception e) {
            System.out.println("Error reading file");

        }
    }
}