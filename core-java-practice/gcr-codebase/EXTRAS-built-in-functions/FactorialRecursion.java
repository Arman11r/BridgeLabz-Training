import java.util.Scanner;

class FactorialRecursion {
// main method
    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // calling recursive method
        long result = factorial(number);

        // printing factorial
        System.out.println("Factorial of " + number + " is  " + result);

        sc.close();
    }

    // recursive method to find factorial
    static long factorial(int n) {


        // base condition
        if (n <= 1) {
            return 1;
        }

        // recursive call

        
        return n * factorial(n - 1);
    }
}