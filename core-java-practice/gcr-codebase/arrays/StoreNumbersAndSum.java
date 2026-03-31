import java.util.Scanner;

class StoreNumbersAndSum {

    public static void main(String[] args) {
        //scaner
        Scanner sc =new Scanner(System.in);
        //varialbes and array
        double[] values = new double [10];
        double total = 0.0;
        int index = 0;

        // infinite loop
        while (true) {
            //taking input here
            double input = sc.nextDouble();

            if (input <= 0) {
                break;
            }

            if (index == 10) {
                break;
            }

            values[index] = input;

            index++;
        }

        // summing values here for calculating total
        for (int i = 0; i < index; i++ ) {
            total = total + values[i];
            System.out.println(values[i]);
        }
        // printing total here
        System.out.println("Total is :  " + total);
        sc.close();// closing scannerr


    }
    
}