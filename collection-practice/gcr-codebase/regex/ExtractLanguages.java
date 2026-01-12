import java.util.*;
import java.util.regex.*;

public class ExtractLanguages {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter text here to extract lang from:");


        String text = sc.nextLine();

        // languagess regex
        String regex = "\\b(Java|Python|JavaScript|Go|C|C\\#|C\\+\\+|Ruby)\\b" ;


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(text);

        boolean first = true;

        while (matcher.find()) {

            if (!first) {

                System.out.print(",  ");
            }
            System.out.print(matcher.group());

            first = false;

        }

        sc.close();
    }
}