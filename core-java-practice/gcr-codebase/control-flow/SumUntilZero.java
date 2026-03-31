import java.util.Scanner;

class SumUntilZero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare variables
        double total = 0.0;
        double userInput;

        // Loop until user enters 0
        while (true) {

            System.out.print("Enter a number: ");
            userInput = sc.nextDouble();
            //if statement
            if (userInput == 0) {
                break;
            }
            //finding total for output here
            total += userInput;
        }

        // Output result
        System.out.println("Total sum is: " + total);
    }
}