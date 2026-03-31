import java.util.Scanner;

class ReplaceWord {

    // main method
    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);


        // taking sentence input
        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();

        // taking word which user want to replace

        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();

        // taking new word

        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();


        // calling method to replace word
        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        // printing final sentence
        System.out.println("Modified Sentence: " + modifiedSentence);


        sc.close();
    }

    // method to replace word in sentence

    static String replaceWord(String sentence, String oldWord, String newWord) {

        // using built in replace method

        String result = sentence.replace(oldWord, newWord);

        return result;
    }
}