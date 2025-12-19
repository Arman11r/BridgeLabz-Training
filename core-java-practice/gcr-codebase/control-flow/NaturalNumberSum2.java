import java.util.*;

class NaturalNumberSum2 {

    public static void main(String[] args) {

        // scanner object

        Scanner sc = new Scanner(System.in);

        // user input number
        int number;




        // sum variable
        int sum;

        // asking number from user
        System.out.print("Enter a number: ");
        number = sc.nextInt();

        // checking number is natural or not

        if (number >= 0) {


            // formula use for sum
            sum = number * (number + 1) / 2;

            // printing sum
            System.out.println("The sum of " + number + " natural numbers is " + sum);

        } else {

            // not a natural number
            System.out.println("The  number  " + number + " is not  a natural numbers " );
        }
    }
}