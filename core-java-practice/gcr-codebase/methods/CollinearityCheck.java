import java.util.*;

public class CollinearityCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                // taking input for three points
        int xCoordinate1 = sc.nextInt();

        int yCoordinate1 = sc.nextInt();


        int xCoordinate2 = sc.nextInt();

        int yCoordinate2 = sc.nextInt();

        int xCoordinate3 = sc.nextInt();

        int yCoordinate3 = sc.nextInt();
            // checking collinearity using slope method
        if (areCollinearBySlope(xCoordinate1, yCoordinate1, xCoordinate2, yCoordinate2, xCoordinate3, yCoordinate3)) {

            System.out.println("The points are collinear using slope method.");
        } else {


            System.out.println("The points are not collinear using slope method.");
        }

        if (areCollinearByArea(xCoordinate1, yCoordinate1, xCoordinate2, yCoordinate2, xCoordinate3, yCoordinate3)) {
            System.out.println("The points are collinear using area method.");
        } else {

            System.out.println("The points are not collinear using area method.");
        }
    }

    public static boolean areCollinearBySlope(int xCoordinate1, int yCoordinate1, int xCoordinate2, int yCoordinate2, int xCoordinate3, int yCoordinate3) {
            // (y2 - y1)/(x2 - x1) == (y3 - y1)/(x3 - x1)
        return (yCoordinate2 - yCoordinate1) * (xCoordinate3 - xCoordinate1) == (yCoordinate3 - yCoordinate1) * (xCoordinate2 - xCoordinate1);
    }
    

    public static boolean areCollinearByArea(int xCoordinate1, int yCoordinate1, int xCoordinate2, int yCoordinate2, int xCoordinate3, int yCoordinate3) {
        // Area method: Area of triangle formed by points should be zero
        double area = 0.5 * (xCoordinate1 * (yCoordinate2 - yCoordinate3) + xCoordinate2 * (yCoordinate3 - yCoordinate1) + xCoordinate3 * (yCoordinate1 - yCoordinate2));
        return area == 0;
    }
}