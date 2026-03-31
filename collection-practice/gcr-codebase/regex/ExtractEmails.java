import java.util.*;
import java.util.regex.*;

public class ExtractEmails {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input text
        System.out.println("Enter text here :");
        String text = sc.nextLine();

        // regex for email
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-ZZ0-9.-]+\\.[a-zA-Z]{2,}";

         Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(text);

        // finding and printing emails
         while (matcher.find()) {
            System.out.println(matcher.group()); //matcher.group() gives the matched email
        }



        sc.close();
    }
}