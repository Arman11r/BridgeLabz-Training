import java.util.Scanner;

class MultiplicationTableSixToNine {

    public static void main(String[] args) {

        // scanner to take number

        Scanner sc = new Scanner(System.in);

        // number whose table is print

        int number;


        // asking user for number
        System.out.print("Enter a number: ");
        number = sc.nextInt();


        // loop print table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }
}