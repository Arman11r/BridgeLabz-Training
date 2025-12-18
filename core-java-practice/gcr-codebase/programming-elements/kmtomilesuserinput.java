import java.util.Scanner;
public class kmtomilesuserinput {
    public static void main(String[] args) {
        //using 1 miles = 1.6 km formula
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double k = sc.nextDouble();
        double m = k / 1.60934; // Conversion formula
        System.out.println("The distance " + k + " km in miles is: " + m);

    }
}
