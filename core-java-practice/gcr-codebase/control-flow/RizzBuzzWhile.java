import java.util.*;

class FizzBuzzWhile {

    public static void main(String[] args)  {

        // scanner for input
        Scanner sc = new Scanner(System.in);

        // number limit

        int number;
        
        int i = 1;

        // asking user

        System.out.print("Enter positive numbers :: ");
        number = sc.nextInt();

        // checking positive

        if (number > 0) {

            // while loop start
         while (i <= number) {

                if (i % 3 == 0 && i % 5 == 0) {

                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {

                 System.out.println("Fizz");
                } else if (i % 5 == 0) {

                    System.out.println("Buzz");
                } else {

                    System.out.println(i);
                }
                i++;
            }


        } else {
            System.out.println(" invalid inputs ");
        }
    }
}