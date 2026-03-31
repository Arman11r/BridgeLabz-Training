import java.util.Scanner;

class BMIcalculator {

    public static void main(String[] args) {
        //scanner
        Scanner sc = new Scanner(System.in);
        //variables 
        double weight;
        double heightCm;
        double heightMeter;
        double bmi;
        //inputs
        weight = sc.nextDouble();
        heightCm = sc.nextDouble();

        // converting cm to meter
        heightMeter = heightCm / 100;

        bmi = weight / (heightMeter * heightMeter);

        System.out.println("BMI is: " + bmi);

        // checking bmi status for the question

        if (bmi <= 18.4) {
            System.out.println("Underweight");
        } 
        
        else if (bmi <= 24.9) {
            System.out.println("Normal");
        }
         else if (bmi <= 39.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}