import java.util.Scanner;

class PrimeChecker {
// main method
    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // checking prime

        if (isPrime(number)) 
            {
            System.out.println(number + " is Prime.");
        } else {
            System.out.println(number + " is not Prime.");
        }

        sc.close();
    }

    // method to check prime number
    static boolean isPrime(int number) {

        // numbers less than or equal to 1 are not prime
          //gb
        if (number <= 1) {
            return false;
        }

        // checking divisibility from 2 onwards

        for (int i = 2; i < number; i++) {

            // if number divides fully then not prime

            if (number % i == 0) {
                return false;
            }
        }

        // if no divisor found then prime

        return true;
    }
}