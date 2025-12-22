
import java.util.*;

public class SimpleInterestCalculator {
    // method to calculate simple interest
    public static double calculateSI(double principal, double rate, double time) {
                // simple interest formula
        return (principal * rate * time) / 100;
    }
        // main method
    public static void main(String[] args) {
        // create scanner object

        Scanner sc = new Scanner(System.in);

        // read inputs belww
        double principalAmount = sc.nextDouble();
        double interestRate = sc.nextDouble();
        double timePeriod = sc.nextDouble();

        // calculate simple interest
        double simpleInterest = calculateSI(principalAmount, interestRate, timePeriod);
        //print
        System.out.println("The Simple Interest is :  " + simpleInterest + " for Principal : " + principalAmount + ", Rate of Interest : " + interestRate + " and Time " + timePeriod);
    }

}