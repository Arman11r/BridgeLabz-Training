import java.util.*;

class GreatestFactorFor {

    public static void main(String[] args) {
        

        // scanner for input created
        Scanner sc  = new Scanner( System.in);

        int number;
        int greatestFactor = 1 ;

        // taking number here

        number = sc.nextInt();

        // loop from number-1 till 1
        for (int i = number - 1; i >= 1; i--) {

            if (number % i == 0) {
                greatestFactor = i;

                break;

            }
        }

        // printing result with syso here
        System.out.println("Greatest factor is. : " + greatestFactor);
    }
}