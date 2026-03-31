import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    // main method
    public static void main(String[] args) {

        // scanner for user feedback
        Scanner sc = new Scanner(System.in);

        // starting range for guessing
        int low = 1;
        int high = 100;

        String feedback = "";

        // loop until computer guess correctly
        while (!feedback.equalsIgnoreCase("correct")) {

            // computer generates a guess
            int guess = generateGuess(low, high);

            System.out.println("Computer guesses: " + guess);
            System.out.print("Is it 'high', 'low', or 'correct'? ");

            // user gives hint
            feedback = sc.nextLine();

            // if guess is higher than number
            if (feedback.equalsIgnoreCase("high")) {

                // reducing upper limit
                high = guess - 1;

            } 
            // if guess is lower than number
            else if (feedback.equalsIgnoreCase("low")) {

                // increasing lower limit
                low = guess + 1;
            }
        }

        // final message when guessed
        System.out.println("Hurray! The computer guessed your number.");
        // closing scanner object
        sc.close();
    }

    // method to generate random guess between range
    static int generateGuess(int low, int high) {

        Random rand = new Random();

        // generating number within range
        int number = rand.nextInt(high - low + 1) + low;

        return number ; // returning generated number
    }
}
