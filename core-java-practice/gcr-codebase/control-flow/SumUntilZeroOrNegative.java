import java.util.Scanner;

class SumUntilZeroOrNegative {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Variable to store total sum
        double totalSum = 0.0;

        // Variable to store user entered value
        double enteredNumber;

        // Infinite loop to keep asking input
        while (true) {

            // Ask user for a number
            System.out.print("Enter a number: ");
            enteredNumber = sc.nextDouble();

            // Stop the loop if number is zero or negative
            if (enteredNumber <= 0) {
                break;
            }

            // Add the number to total sum here
            totalSum += enteredNumber;
        }

        // Display the final sum here
        System.out.println("The total sum is: " + totalSum);
    }
}