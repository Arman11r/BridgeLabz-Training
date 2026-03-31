// Create a program to find the mean height of players present in a football team.
// Hint => 
// The formula to calculate the mean is: mean = sum of all elements / number of elements
// Create a double array named heights of size 11 and get input values from the user.
// Find the sum of all the elements present in the array.
// Divide the sum by 11 to find the mean height and print the mean height of the football team


import java.util.Scanner;public class MeanHeight {
    public static void main(String[] args) {
        // Scanner object created for user input
        Scanner sc = new Scanner(System.in);
        // Create an array to store heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;


        // Get input values from the user for array here
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Find the sum of all elemenent in the given array
        for (double height : heights) {
            
            sum += height;

        }

        // Calculate and print the mean height from the formula here
        double mean = sum / heights.length;
        System.out.println("Mean height of the football team is: " + mean);

         // Close the scanner
        sc.close();
    }

}