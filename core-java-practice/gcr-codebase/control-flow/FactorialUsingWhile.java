import java.util.Scanner;

class FactorialUsingWhile {

    public static void main(String[] args) {

        // scanner is use to take input from user
        Scanner sc = new Scanner(System.in);

        // number given by user
        int number;

        // factorial start from 1 always
        long factorial = 1;

        // counter variable for looping
        int counter = 1;


        // asking user to enter number
        
        System.out.print("Enter a positive integer: ");
        number = sc.nextInt();


        // factorial only possible for natural number
        if (number >= 0) {



            // loop multiply value one by one
            while (counter <= number) {
                factorial = factorial * counter;
                counter++;
            }

            // final factorial value print

            System.out.println("The factorial of " + number + " is " + factorial);

        } else {

            // factorial not work for negative number
            System.out.println("factorial not possible for negative number");
        }
    }
}