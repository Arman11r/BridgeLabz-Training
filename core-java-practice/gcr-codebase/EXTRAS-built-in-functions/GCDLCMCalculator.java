import java.util.Scanner;

class GCDLCMCalculator {
// main method
    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");


        int firstNumber = sc.nextInt();


        System.out.print("Enter second number: ");

        int secondNumber = sc.nextInt();

        // calling gcd method
        int gcdValue = findGCD(firstNumber, secondNumber);

        // lcm formula using gcd
        int lcmValue = (firstNumber * secondNumber) / gcdValue;

        // printing results
        System.out.println("GCD: " + gcdValue);

        System.out.println("LCM: " + lcmValue);

        sc.close();
    }

    // recursive method to find gcd

    static int findGCD(int a, int b ) {

        // base case when remainder becomes zero
        if (b == 0) {
            return a;
        }

        // calling function again with remainder
        return findGCD(b, a% b);
    }
}