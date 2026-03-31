import java.io.*;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        // try-with-resources
        try (BufferedReader br=new BufferedReader(new FileReader("file.txt"))) {

            // read first line
            String row=br.readLine ();

            System.out.println(row);

        }
        catch (IOException e) {
            System.out.println("Error reading row of file");
        }
    }
}