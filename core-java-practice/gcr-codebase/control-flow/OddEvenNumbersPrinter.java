import java.util.Scanner;

class OddEvenNumbersPrinter {

    public static void main(String[] args) {

        // scanner for taking number
        Scanner sc = new Scanner(System.in);
        

        // number till where checking is done
        int number;

        // asking user for number

        System.out.print("Enter a natural number: ");

        number = sc.nextInt();

        // odd even make sense only for natural number
        if (number >= 1) {

            // loop run from 1 to number

            for (int i = 1; i <= number; i++) {


                // checking even or odd condition
                if (i % 2 == 0) {

                    System.out.println(i + " is Even");
                } else {

                    System.out.println(i + " is Odd");
                }
            }

        } else {

            // user enter wrong value
            System.out.println("enter valid natural number");
        }
    }
}