import java.util.Scanner;

class NaturalNumberSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare variables
        int number;
        int sum;

        // Take input
        System.out.print("Enter a number: ");
        number = sc.nextInt();

        // Check if natural number
        if (number >= 0) {

            // Formula calculation for sum of natural numbers
            sum = number * (number + 1) / 2;

            System.out.println("The sum of " + number + " natural numbers is " + sum);

        } else {

            // Not a natural number case
            System.out.println("The number " + number + " is not a natural number");
        }
    }
}