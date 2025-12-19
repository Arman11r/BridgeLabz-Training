import java.util.Scanner;

class LargestNumberChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare variables here
        int number1, number2, number3;

        // Take inputs. here
        System.out.print("Enter first number: ");
        number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        number3 = sc.nextInt();

        // Logical checks here
        boolean isFirstLargest = (number1 > number2 && number1 > number3);
        boolean isSecondLargest = (number2 > number1 && number2 > number3);
        boolean isThirdLargest = (number3 > number1 && number3 > number2);

        // Output results in one line
        System.out.println("Is the first number the largest? " + isFirstLargest + ", " +
                           "Is the second number the largest? " + isSecondLargest + ", " +
                           "Is the third number the largest? " + isThirdLargest);
    }
}