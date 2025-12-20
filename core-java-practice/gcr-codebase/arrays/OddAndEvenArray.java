import java.util.Scanner;   
public class OddAndEvenArray {
    public static void main(String[] args) {
        // Scanner object created for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a  number for range: ");
        int number = sc.nextInt();

        // Check for Number validation

        if (number <= 0) {
            
            System.out.println("Error: Please enter a number greater than zero.");

                sc.close();//close scanner for return 
            return;
        }


        // Create arrays for odd and even numbers

        int[] evenNumbers = new int[number / 2 + 1];

        int[] oddNumbers = new int[number / 2 + 1];

        int evenIndex =0;
        int oddIndex = 0;

        // Iterate from 1 to the number and save odd/even numbers

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        // Print even numbers array
        System.out.print("Even Numbers : ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        // Print odd numbers array
        System.out.print("Odd  Numbers : ");
        for (int i = 0; i < oddIndex; i++) {

            System.out.print(oddNumbers[i] + " ");


        }

        System.out.println();

        // Close the scanner

        sc.close();
    }
}