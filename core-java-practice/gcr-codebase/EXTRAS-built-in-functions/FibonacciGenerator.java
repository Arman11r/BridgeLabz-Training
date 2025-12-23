import java.util.Scanner;

class FibonacciGenerator {
// main method
    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter number of terms: ");

        int terms = sc.nextInt();

        // calling method to print fibonacci
        generateFibonacci(terms);

        sc.close();
    }

    // method to generate fibonacci series
    static void generateFibonacci(int n) {


        int first = 0;


        int second = 1;

        System.out.print("Fibonacci Sequence: ");

        // loop runs n times
        for (int i = 1; i <= n; i++) {

            // printing current number


            System.out.print(first + " ");

            // finding next number


            int next = first + second;

            // shifting values
            first = second;
            second = next;
        }

        System.out.println();
        
    }
}