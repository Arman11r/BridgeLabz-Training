import java.io.FileReader;
import java.util.*;

public class CheckCsv 
{

    public static void main(String[] args) 
    {

        String file = " datasampletowork.csv";

        try {

            Scanner sc = new Scanner(new FileReader(file));
            String line;

            while (sc.hasNextLine()) {
                line = sc.nextLine();

                String[] parts = line.split(" , ");

                String email = parts[2];
                String phone = parts[3];

                if (!email.contains("@") || !email.contains(".")) {
                    System.out.println(" email wrong ->  " + line);
                }

                if (phone.length() != 10) {
                    System.out.print(" phone wrong ->  " + line);
                }
            }
        } catch (Exception e) {
            System.out.print(" file problem came. " );
        }
    }
}