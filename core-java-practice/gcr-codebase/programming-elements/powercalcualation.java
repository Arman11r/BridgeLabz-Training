import java.util.Scanner;

class powercalculation {
    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);

        // Asking  the user to enter the base value
        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        // Asking the user to enter the exponent value
        System.out.print("Enter exponent: ");
        double exponent = sc.nextDouble();

        // Calculate power using Math.pow() methods 
        // Math.pow(base, exponent) returns base raised to the exponent =>
        double result = Math.pow(base, exponent);

        // Display the result. 
        System.out.println("Result is: " + result);
    }
}
