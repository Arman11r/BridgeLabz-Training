import java.util.Scanner;

class perimeterofrectangle {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        // Asked the user to enter the length of the rectangle here
        System.out.print("Enter length of the rectangle: ");
        double l = sc.nextDouble();

        // Asked the user to enter the breadth of the rectangle here
        System.out.print("Enter breadth of the rectangle: ");
        double m = sc.nextDouble();

	//formula applied
        double perimeter = 2 * (l + m);

        // Displayed  the calculated perimeter
        System.out.println("Perimeter of the rectangle is: " + perimeter);
    }
}
