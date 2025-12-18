// Write a program to find the side of the square whose parameter you read from user 
// Hint => Perimeter of Square is 4 times side
// I/P => perimeter
// O/P => The length of the side is ___ whose perimeter is ____

import java.util.Scanner;
public class sideofsquare {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = sc.nextDouble();
        // Calculate the side length
        double side = perimeter / 4;
        // Output the result
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}
