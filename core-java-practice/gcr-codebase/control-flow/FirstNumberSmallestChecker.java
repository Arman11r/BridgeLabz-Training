import java.util.Scanner;

class FirstNumberSmallestChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declared variables
        int number1, number2, number3;

        // Taking inputs from the user
        System.out.print("Enter first number: ");
        number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        number3 = sc.nextInt();

        // Check if first is smallest
        boolean isFirstSmallest = (number1 < number2 && number1 < number3);

        // Displayed result
        System.out.println("Is the first number the smallest? " + isFirstSmallest);
    }
}