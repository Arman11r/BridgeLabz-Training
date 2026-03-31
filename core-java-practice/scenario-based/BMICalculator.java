import java.util.*;
public class BMICalculator {
    public static void main(String[] args) {
        // Scanner for user input created
        Scanner sc = new Scanner(System.in);

        // ask for weight in kgs
        System.out.print("Enter your weight in kilograms: ");
        double weight = sc.nextDouble();

        // ask for height in meters
        System.out.print("Enter your height in meters: ");
        double heightMeters = sc.nextDouble();

        // calculate using the formula: BMI = weight (kg) / (height (m) * height (m))
        double bmi = weight / (heightMeters * heightMeters);

        // Display here
        System.out.printf("Your BMI is:", bmi);
        //check catogery
        if (bmi < 18.5) {

            System.out.println("You are Underweight.");
        } else if (bmi < 24.9) {

            System.out.println("You have a Normal weight.");
        } else if (bmi < 29.9) {

            System.out.println("You are Overweight.");
        } 
        else {

            System.out.println("You are Obese.");
        }

        // Close the scanner here 
        sc.close();
    }
    
}
