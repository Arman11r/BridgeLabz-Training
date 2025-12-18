// Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.
// Hint => NA
// I/P => unitPrice, quantity
// O/P => The total purchase price is INR ___ if the quantity ___ and unit price is INR ___
import java.util.Scanner;
public class pricecalculator {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // User prompts
        System.out.print("Enter the unit price: ");
        double unitPrice = sc.nextDouble();
        // User prompt
        System.out.print("Enter the quantity: ");
        int q = sc.nextInt();
        // Calculate total price
        double totalPrice = unitPrice * q;
        // Output the result
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + q + " and unit price is INR " + unitPrice);
    }
}