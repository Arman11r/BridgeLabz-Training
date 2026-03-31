import java.util.*;

class FizzBuzzFor {

    public static void main(String[] args) {

        // scanner object
        Scanner sc = new Scanner(System.in);

        // number limit
        int number;

        // asking number 
        System.out.print("Enter a positive number: ");
      number = sc.nextInt();

        // checking positives

        if (number > 0) {

            // loop for fizzbuzz

         for (int i = 1; i <= number; i++) {


                if (i % 3 == 0 && i % 5 == 0) {

                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {

                    System.out.println("Fizz");
                } else if (i % 5 == 0) {

                 System.out.println("Buzz");
                } else {

                    System.out.println(i);
                }
            }


        } else {
            System.out.println("number not positiive ");
        }
    }
}