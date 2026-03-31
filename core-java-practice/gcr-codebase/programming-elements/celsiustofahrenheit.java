import java.util.Scanner;

class celsiustofahrenheit {
    public static void main(String[] args) {

        // Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter temperature in Celsius
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        // Formula to convert Celsius to Fahrenheit
        // Fahrenheit = (Celsius × 9/5) + 32
        double fahrenheit = (celsius * 9 / 5) + 32;

        // Display the converted temperature
        System.out.println("Temperature in the Fahrenheit: " + fahrenheit);

        // Close the scanner to release resources
        sc.close();
    }
}
