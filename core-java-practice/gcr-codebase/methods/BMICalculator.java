import java.util.Scanner;

public class BMICalculator {
    // main method
    public static void main(String[] args) {
        // creating scanner object
        Scanner sc = new Scanner(System.in);
            // 2D array to hold weight, height and bmi
        double[][] measurements = new double[10][3];

        String[] bmiStatus = new String[10];
        // taking input
        for (int personIndex = 0; personIndex < 10; personIndex++) {
            double weightKg = sc.nextDouble();

            double heightCm = sc.nextDouble();
            measurements[personIndex][0] = weightKg;

            measurements[personIndex][1] = heightCm;
        }
        // calculating BMI and status
        calculateBMI(measurements);
        calculateStatus(measurements, bmiStatus);
            // displaying result
        for (int personIndex = 0; personIndex < 10; personIndex++) {

            System.out.println("Person " + (personIndex + 1));
            System.out.println("Weight: " + measurements[personIndex][0] + " kg");

            System.out.println("Height: " + measurements[personIndex][1] + " cm");

            System.out.println("BMI: " + measurements[personIndex][2]);
            System.out.println("Status: " + bmiStatus[personIndex]);
            System.out.println();
        }
    }
    // method to calculate BMI
    public static void calculateBMI(double[][] bmiValues) {
        for (int personIndex = 0; personIndex < bmiValues.length; personIndex++) {
            double weightKg = bmiValues[personIndex][0];

            double heightInMeters = bmiValues[personIndex][1] / 100.0;
            double bmi = weightKg / (heightInMeters * heightInMeters);


            bmiValues[personIndex][2] = bmi;
        }
    }
    // method to calculate status
    public static void calculateStatus(double[][] bmiValues, String[] bmiStatus) {
        for (int personIndex = 0; personIndex < bmiValues.length; personIndex++) {
            // getting bmi
            double bmi = bmiValues[personIndex][2];
            if (bmi <= 18.4) {
                bmiStatus[personIndex] = "Underweight";
            } else if (bmi <= 24.9) {

                // normal weight
                bmiStatus[personIndex] = "Normal";
            } else if (bmi <= 39.9) {
                bmiStatus[personIndex] = "Overweight";
            } else {
                bmiStatus[personIndex] = "Obese";
            }

        }
    }
}