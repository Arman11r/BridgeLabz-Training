import java.util.Scanner;

class areaofcircle {
    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the radius of the circle
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        // Formula to calculate area of a circle
        // Area = π × radius × radius
        double area = Math.PI * radius * radius;

        // Display the calculated area
        System.out.println("Area of the circle is: " + area);

       
    }
}
