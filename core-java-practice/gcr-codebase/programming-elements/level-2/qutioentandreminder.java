// Write a program to take 2 numbers and print their quotient and reminder
// Hint => Use division operator (/) for quotient and moduli operator (%) for reminder
// I/P => number1, number2
// O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___
import java.util.Scanner;
public class qutioentandreminder {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // User prompt
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        // User prompt
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        // Calculate quotient and remainder
        int quotient = num1 / num2;
        int remainder = num1 % num2;
        // Output the result
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + num1 + " and " + num2);
    }
}