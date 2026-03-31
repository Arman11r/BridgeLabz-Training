import java.util.Scanner;

class addtwonumbers {
    public static void main(String[] args) {

        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user for the first number
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        // Ask the user for the second number
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Add the two numbers
        int sum = num1 + num2;

        // Display the result
        System.out.println("Sum of the two numbers is: " + sum);

        // Close the scanner to free resources
        sc.close();
    }
}
