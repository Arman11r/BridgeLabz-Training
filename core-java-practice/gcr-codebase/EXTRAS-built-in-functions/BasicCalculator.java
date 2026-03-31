import java.util.Scanner;

class BasicCalculator {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        // taking first number


        System.out.print("Enter first number: ");
        double firstNumber = sc.nextDouble();

        // taking second number
        System.out.print("Enter second number: ");
        double secondNumber = sc.nextDouble();

        // asking user which operation to do
        System.out.print("Choose operation (+, -, *, /): ");

        char operator = sc.next().charAt(0);

        // switch case for operation
        switch (operator) {

            case '+':
                System.out.println("Result: "


                        + add(firstNumber, secondNumber));
                break;

            case '-':
                System.out.println("Result: "
                        + subtract(firstNumber, secondNumber));
                break;

            case '*':
                System.out.println("Result: "
                        + multiply(firstNumber, secondNumber));
                break;

            case '/':
                System.out.println("Result : "
                        + divide(firstNumber, secondNumber));
                break;

            default:
                System.out.println("Invalid Operation. ");
        }

        sc.close();
    }

    // method for addition
    static double add(double x, double y) {

        return x + y;
    }

    // method for subtraction
    static double subtract(double x, double y) {

        return x - y;
    }

    // method for multiplication
    static double multiply(double x, double y) {

        return x * y;
    }

    // method for division
    static double divide(double x, double y) {

        // checking divide by zero case
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("cannot divide by zero");
            return 0;
        }
    }
}