import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class FileReadWrite {

    public static void main(String[] args) {

        String sourceFile = "in.txt";
        String destinationFile = "out.txt";

        // using try with resources
        try (FileInputStream fis = new FileInputStream(sourceFile) ;
             FileOutputStream fos = new FileOutputStream(destinationFile) ){

            int data;

            // read byte by byte and write
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("file copied ");

        } catch (IOException e) {
            // file not found or read write issue
            System.out.println("error accessing the file");
        }
    }
}