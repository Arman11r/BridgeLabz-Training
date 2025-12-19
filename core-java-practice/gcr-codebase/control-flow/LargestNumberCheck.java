import java.util.Scanner;

class LargestNumberCheck {

    public static void main(String[] args) {

        // scanner used for input
        Scanner sc = new Scanner(System.in);

        // declaring three numbers
        int number1, number2, number3;

        // user giving values
        System.out.print("Enter first number: ");
        number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        number3 = sc.nextInt();

        // logic for checking largest
        boolean isFirstLargest = (number1 > number2 && number1 > number3);
        boolean isSecondLargest = (number2 > number1 && number2 > number3);
        boolean isThirdLargest = (number3 > number1 && number3 > number2);

        // printing answers heree in a line
        System.out.println("Is the first number the largest? " + isFirstLargest + ", " +"Is the second number the largest? " + isSecondLargest + ", " +"Is the third number the largest? " + isThirdLargest);
    }
}