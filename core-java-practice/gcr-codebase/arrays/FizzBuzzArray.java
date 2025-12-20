// Write a program FizzBuzz, take a number as user input and if it is a positive integer loop from 0 to the number and save the number, but for multiples of 3 save "Fizz" instead of the number, for multiples of 5 save "Buzz", and for multiples of both save "FizzBuzz". Finally, print the array results for each index position in the format Position 1 = 1, …, Position 3 = Fizz,...
// Hint => 
// Create a String Array to save the results and 
// Finally, loop again to show the results of the array based on the index position
import java.util.Scanner;   

class FizzBuzzArray {
    public static void main(String[] args) {
        //scaner
        Scanner sc = new Scanner(System.in);
        //entering number 
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Validate input if its a positive or not here
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            sc.close();//for return

            return;
        }

        // Create a String array to hold the results
        
        String[] results = new String[number + 1]; // sstring array

        // Loop from 1 to the number and apply FizzBuzz logic there
        //logic
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {

                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {

                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";

            } else {
                results[i] = String.valueOf(i);
            }
        }

        // Print the results
        for (int i = 1; i < results.length; i++) {
            //syso
            System.out.println("Position " + i + " = " + results[i]);
        }
        //sc closed here
        sc.close();
    }
}
