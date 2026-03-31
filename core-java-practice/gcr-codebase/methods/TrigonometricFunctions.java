
import java.util.*;

public class TrigonometricFunctions {
    // method to calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angleDegrees) {
        // convert degrees to radians
        double radians = Math.toRadians(angleDegrees);
        // calculate sine, cosine, and tangent
        double[] trigonometricValues = new double[3];
        // storing values in array
        trigonometricValues[0] = Math.sin(radians);
        trigonometricValues[1] = Math.cos(radians);
        // calculating tangent
        trigonometricValues[2] = Math.tan(radians);
        // returning array
        return trigonometricValues;
    }
// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input angle in degrees
        double angleDegrees = sc.nextDouble();
        // calculate trigonometric functions
        double[] trigonometricValues = calculateTrigonometricFunctions(angleDegrees);
        // print results
        System.out.println( trigonometricValues[0] + " " + trigonometricValues[1] + " " + trigonometricValues[2]);
    }
}
