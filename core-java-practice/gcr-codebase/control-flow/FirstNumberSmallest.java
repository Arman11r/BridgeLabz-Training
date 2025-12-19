import java.util.Scanner;

class FirstNumberSmallest {

    public static void main(String[] args) {

        // scanner object create
        Scanner sc = new Scanner(System.in);


        // three numbers input

        int number1, number2, number3;

        // taking inputs from user

        System.out.print("Enter first number: ");
        number1 = sc.nextInt();


        System.out.print("Enter second number: ");
        number2 = sc.nextInt();


        System.out.print("Enter third number: ");
        number3 = sc.nextInt();

        // checking first number smallest or not

        boolean isFirstSmallest = (number1 < number2 && number1 < number3);

        // showing result heree

        System.out.println("Is the first number the smalest ? " + isFirstSmallest);
    }
}