import java.util.Scanner;
class DivisibleByFiveChecker {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // Declare variable to store the number
        int number;
        // Take input from the user for no.
        System.out.print("Enter a number: ");
        number = sc.nextInt();
        // Check the divisibility by 5
        boolean isDivisibleByFive = (number % 5 == 0);
        // Display the final result
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisibleByFive);
    }
}
