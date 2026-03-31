import java.util.*;

class NaturalNumberSumForCheck {

    public static void main(String[] args) {

        // Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Declaring required variables
        int number;
        int forLoopSum = 0;

        // Asking user to enter number
        System.out.print("Enter a natural number: ");
        number = sc.nextInt();

        // Checking number is natural or not
        if (number >= 0) {

            // Using for loop to calculate sum
            for (int i = 1; i <= number; i++) {
                forLoopSum = forLoopSum + i;
            }

            // Calculating sum using formula
            int formulaSum = number * (number + 1) / 2;

            // Printing both sum for verification
            System.out.println("Sum using for loop is: " + forLoopSum);
            System.out.println("Sum using formula is: " + formulaSum);

        } else {

            // If number is invalid
            System.out.println("The number is not a natural number");
        }
    }
}