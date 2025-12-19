import java.util.*;

class NumberTypeCheck {

    public static void main(String[] args) {

        // scanner object
        Scanner sc = new Scanner(System.in);  

        // number from user

        int number;

        // asking user input

        System.out.print("Enter a number: ");
        number = sc.nextInt();

        // checking number type

        if (number > 0) {

            System.out.println("Positiive ");
        } else if (number < 0) {

            System.out.println("Negative ");
        } else {

            System.out.println(" Zero ");

            
        }
    }
}