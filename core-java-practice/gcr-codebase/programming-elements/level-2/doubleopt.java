// Similarly, write the DoubleOpt program by taking double values and doing the same operations.
import java.util.Scanner;
public class doubleopt {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // User prompts
        System.out.print("Enter the value for a: ");
        double a = sc.nextDouble();
        System.out.print("Enter the value for b: ");
        double b = sc.nextDouble();
        System.out.print("Enter the value for c: ");
        double c = sc.nextDouble();
        // Compute double operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;
        // Output the results
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}