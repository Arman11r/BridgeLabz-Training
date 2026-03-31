

import java.util.Scanner;
class MultiplicationTableSixToNine {
    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner sc  = new Scanner(System.in);
        // Declare variables
        int number;
        int[] multiplicationResult = new int[4];

        // Take input from the user
        System.out.print("Enter a number between 6 and 9: ");
        number = sc.nextInt();

        // Validate input
        if (number < 6 || number > 9) {
            System.out.println("Invalid input.Please enters a number between 6 and 9.");
            return;
        }

        // Calculate multiplication table
        for (int i = 1; i <= 10; i++) {
            multiplicationResult[i - 1] = number * i;
        }

        // Display result
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " *" + (i + 1) + "  = " + multiplicationResult[i]);
        }


        sc.close();
    }

    
}
