import java.util.Scanner;

class LongestWord {


    public static void main(String[] args) {

        // scanner for taking sentence input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();



        // splitting sentence into words
        String[] words = sentence.split(" ");

        // assuming first word is longest for now
        
        String longestWord = words[0];


        // checking each word one by one
        for (int i = 1; i < words.length; i++) {

            // if current word is bigger then update
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }


        // printing final result
        System.out.println("Longest Word: " + longestWord);

        sc.close();
    }
}