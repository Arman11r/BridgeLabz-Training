import java.util.*;

class OddEvenNumbers {

  public static void main(String[] args) {

        // scanner use for input
        Scanner sc = new Scanner(System.in);

     // number enter by user
        int number;

        // asking number
        System.out.print("Enter a number: ");
        number = sc.nextInt();

        // checking natural number
        if (number >= 1) {

            // loop from 1 to number
          for (int i = 1; i <= number; i++) {

                // checking odd evens
                if (i % 2 == 0) {
                    System.out.println(i + " is Even");
                } else {
                 System.out.println(i + " is Odd");
                }
            }

        } else {
            System.out.println("number is not natural");
        }
    }
}