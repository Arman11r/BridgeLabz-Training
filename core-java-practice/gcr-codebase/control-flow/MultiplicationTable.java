import java.util.Scanner;

class MultiplicationTable {

    public static void main(String[] args) {

        // scanner created for future use

        Scanner sc = new Scanner(System.in);

        // number for table variable

     int number;

        // asking user input

        System.out.print("Enter number : ");
        number = sc.nextInt();

        // loop for table

      for (int i = 6; i <= 9; i++) {

            System.out.println(number + " * " + i + "  = " + (number * i) );
        }
    }
}