import java.util.Scanner;


public class CensorBoard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input sentence
        System.out.println("Enter sentence here ahead:");
        String sentence = sc.nextLine();

        // list of bad words
        String[] badWords = { "damn", "stupid","fuck", "idiot", "bastard" };

        // replacing bad words
        for (int i = 0; i < badWords.length; i++) {
            sentence = sentence.replaceAll("(?i)\\b" + badWords[i] + "\\b", "****"); //\\b for word boundaries, (?i) for case insensitive
        }

        // printing censored sentence
        System.out.println(sentence);

        sc.close();
    }
}