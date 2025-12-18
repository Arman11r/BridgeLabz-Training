// Write a program the find the distance in yards and miles for the distance provided by user in feets
// Hint => 1 mile = 1760 yards and 1 yard is 3 feet
// I/P => distanceInFeet
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
import java.util.Scanner;
public class distanceconvert {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double disInFeet = sc.nextDouble();

        // Convert feet to yards and miles
        double disInYards = disInFeet / 3;
        double disInMiles = disInYards / 1760;

        // Output the results = Your Height in cm is ___ while in feet is ___ and inches is ___
        System.out.println("The distance in feet is " + disInFeet + ", in yards is " + disInYards + ", and in miles is " + disInMiles);
    }
}