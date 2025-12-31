import java.io.*;

public class ReadFileUsingInputStreamReader {

    public static void main(String[] args) {


        try 
        {
            // Byte stream
            FileInputStream fis = new FileInputStream("sample.txt");//not real file exist


            // Convert to character stream
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            // BufferedReader for efficiency
            BufferedReader br = new BufferedReader(isr);

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null)
                 {

                System.out.println(line);

            }

            // Close resources
            br.close();

            isr.close() ;
            fis.close();

        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }
}