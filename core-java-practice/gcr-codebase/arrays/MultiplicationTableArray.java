import java.util.Scanner;

class MultiplicationTableArray {

    public static void main(String[] args) {
        //scanner created
        Scanner sc = new Scanner(System.in);
        //taken array size and var
        int number;
        int[] table = new int[10];
        //input number for table
        System.out.print("Enter a number to print its multiplication table: ");
        number = sc.nextInt();

        // storing table values here for thew number selected
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // printing table from for loop here
        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
        sc.close(); //close scanners
    }
}