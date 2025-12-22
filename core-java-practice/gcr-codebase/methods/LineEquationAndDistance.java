import java.util.Scanner;

class LineEquationAndDistance {
    //mains
    
    public static void main(String[] args) {

        // scanner used for taking input
        Scanner sc = new Scanner(System.in);

        // taking x and y values for first point
        double x1 = sc.nextDouble();


        double y1 = sc.nextDouble();


        // taking x and y values for second point
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();


        // finding distance between two points
        double distance = calculateDistance(x1, y1, x2, y2);



        // printing distance
        System.out.println("Euclidean Distance: " + distance);

        // finding slope and intercept
        double[] lineData = calculateLine(x1, y1, x2, y2);

        // printing line equation
        System.out.println("Equation of line: y = " 
                + lineData[0] + "x + " + lineData[1]);
    }

    // method to calculate distance using formula
    public static double calculateDistance(double x1, double y1,
                                           double x2, double y2) {

        double xDifference = x2 - x1;
        double yDifference = y2 - y1;
        // squaring differences
        double xSquare = xDifference * xDifference;
        double ySquare = yDifference * yDifference;
                                            // summing squares
        double sum = xSquare + ySquare;

        double distance = Math.sqrt(sum);

        return distance;
    }

    // method to calculate slope and intercept
    public static double[] calculateLine(double x1, double y1,

                                         double x2, double y2) {

        double slope = (y2 - y1) / (x2 - x1);


        // using y = mx + c to find intercept
        double intercept = y1 - (slope * x1);

        return new double[]{slope, intercept};
    }
}