import java.util.Scanner;
 public class heightconversion {
    public static void main(String[] args) {
        // user input height in centimeters
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightInCm = sc.nextDouble();
        // Convert cm to inches
        double inches = heightInCm / 2.54;
        // Calculate feet
        int feet = (int) (inches / 12);
        // Calculate remaining inches
        inches = inches % 12;
        //output
        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + feet + " and inches is " + inches);
    }
}
