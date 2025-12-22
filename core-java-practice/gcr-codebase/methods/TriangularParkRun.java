

import java.util.Scanner;

public class TriangularParkRun {
    // method to calculate number of rounds
    public static double calculateRounds(double sideA, double sideB, double sideC) {
        //perameter formula
        double perimeter = sideA + sideB + sideC;
        // distance to run in meters here
        double distanceToRunMeters = 5000;
        //return value
        return distanceToRunMeters / perimeter;
    }
// main method
    public static void main(String[] args) {
        //scanner
        Scanner sc = new Scanner(System.in);
                //input sides
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        //calculate rounds
        double rounds = calculateRounds(side1, side2, side3);
        //print result
        System.out.print(rounds );
    }
}