import java.util.Scanner;

class NumberTypeChecker {

    public static void main(String[] args) {
        //scanner
        Scanner sc = new Scanner(System.in);

        // Declare variable here
        int number;

        // Take inputs here
        System.out.print("Enter a number: ");
        number = sc.nextInt();

        // Check conditions here below
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }
}