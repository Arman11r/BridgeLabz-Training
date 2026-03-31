import java.util.*;
import java.util.regex.*;

public class ExtractCapitalized {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking sentence input
        System.out.println("Enter sentence here ahead :");
        String sentence = sc.nextLine();

        // regex for capitalized words
        String regex = "\\b[A-Z] [a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(sentence);

        // flag to manage commas
        boolean first = true;

        // finding and printing words uing comma 
        while (matcher.find()) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(matcher.group());
            first = false;
        }

        sc.close();
    }
}