import java.util.Scanner;

class NaturalNumberSumWhileCheck {

    public static void main(String[] args) {

        // Create scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Variable to store user number
        int number;

        // Variable to store sum using while loop
        int whileSum = 0;

        // Counter variable for loop
        int counter = 1;

        // Asking user to enter a number
        System.out.print("Enter a natural number: ");
        number = sc.nextInt();

        // Check the number is natural or not
        if (number >= 0) {

            // Loop will run till counter reach number
            while (counter <= number) {
                whileSum = whileSum + counter;
                counter++;
            }

            // Calculating sum using formula also
            int formulaSum = number * (number + 1) / 2;

            // Printing both result to compare
            System.out.println("Sum using while loop is: " + whileSum);
            System.out.println("Sum using formula is: " + formulaSum);

        } else {

            // If number is not natural
            System.out.println("The number is not a natural number");
        }
    }
}