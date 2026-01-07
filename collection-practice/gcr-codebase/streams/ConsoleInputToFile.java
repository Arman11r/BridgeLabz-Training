import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputToFile {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // taking user input
            System.out.print("enter name. : ");
            String name =br.readLine();

            System.out.print("enter age. : ");
            String age =br.readLine();

            System.out.print("enter favourate language. : ");
            String language =br.readLine();

            // writing to file
            FileWriter fw = new FileWriter("data.txt");
            fw.write("name: " +name +"\n");
            fw.write("age: " +age +"\n");
            fw.write("language: " +language +"\n");

            fw.close();
            System.out.println("data saved to file");

        } catch (IOException e) {
            System.out.println("io error");
        }
    }
}