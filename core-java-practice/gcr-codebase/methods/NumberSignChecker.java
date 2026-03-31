

import java.util.Scanner;

public class NumberSignChecker { // Class to check the sign of a number

    // Method to check the sign of the number
    public static int checkSign(int number) {
        if (number > 0) return 1;

        else if (number < 0) return -1;
        else return 0;
          
        // returning sign result
    }
    // Main method

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // prompt for input
        System.out.print("Enter an integer: ");
        int inputNumber = sc.nextInt();
        
// check the sign
        int signResult = checkSign(inputNumber);
        // print based on sign
        if (signResult == 1) {


            // print positive
            System.out.println("The number is Positive:.");
        } else if (signResult == -1) {

            // print negative
            System.out.println("The number is Negative:.");
        } else {
            // print zero
            System.out.println("The number is Zero.:");
        }
    }
}