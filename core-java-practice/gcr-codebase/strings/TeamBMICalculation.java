import java.util.Scanner;

class TeamBMICalculation {
    

    // method for bmi and status
    static String[][] calculateBMI(double[][] data) {
/// creating result array
        String[][] result = new String[10][4];
// calculating bmi and status
        for (int i = 0; i < 10; i++) {
                // weight and height
            double weight = data[i][0];

            double heightCm = data[i][1];
            double heightM = heightCm / 100;

            // calculating bmi
            double bmi = weight / (heightM * heightM);

            String status;
            // determining status

            if (bmi <= 18.4) {
                status = "Underweight ";
            } else if (bmi <= 24.9) {
                status = "Normal weight";
            } else if (bmi <= 39.9) {
                status = "Over weight ";
            } else {

                status = "Obese ";
            }// storing in result array
                // height, weight, bmi, status
            result[i][0] = String.valueOf(heightCm);

            result[i][1] = String.valueOf(weight);


            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }
        // returning result
        return result;
    }

    // method to display table
    static void display(String[][] table) {

        System.out.println("Height\tWeight\tBMI\tStatus");
        // printing table
        for (int i = 0; i < table.length; i++) {
            System.out.println(
                    table[i][0] + "\t" +
                    table[i][1] + "\t" +
                    table[i][2] + "\t" +
                    table[i][3]
            );
        }
    }
        // main method
    public static void main(String[] args) {

        // scanner for input
        Scanner sc = new Scanner(System.in);


            // 2D array for weight and height
        double[][] input = new double[10][2];


        // taking input
        for (int i = 0; i < 10; i++) {

            input[i][0] = sc.nextDouble(); // weight

            input[i][1] = sc.nextDouble(); // height
        }
        // calculating bmi and status
        String[][] result = calculateBMI(input);

        display(result);
    }
}