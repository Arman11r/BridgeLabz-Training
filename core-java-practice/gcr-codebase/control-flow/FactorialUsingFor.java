import java.util.Scanner;

class FactorialUsingFor {

    public static void main(String[] args) {

        // scanner object create
        Scanner sc = new Scanner(System.in);

        // storing user input
        int number;

        // factorial value taken as 1
        long factorial = 1;


        // taking input from user

        System.out.print("Enter a positive integer: ");
        number = sc.nextInt();

        // checking input is valid or not
        if (number >= 0) {


            // for loop do the multiplication work
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i;
            }

            // printing factorial result
            
            System.out.println("The factorial of " + number + " is " + factorial);

        } else {

            // wrong input case
            System.out.println("please enter natural number only");
        }
    }
}