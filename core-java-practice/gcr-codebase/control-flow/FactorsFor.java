import java.util.Scanner;

class FactorsFor {

    public static void main(String[] args) {

        // scanner used

        Scanner sc = new Scanner(System.in);

        // number input

        int number;

        // asking number

        System.out.print("Enter numberss : ");
        number = sc.nextInt();

        // checking positive

        if (number > 0) {

            // loop for factors

         for (int i = 1; i < number; i++) {

                if (number % i == 0) {

                    System.out.println(i);
                }

            }

        } else {

            System.out.println("not postve number ");
        }
    }
}