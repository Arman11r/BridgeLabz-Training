import java.util.Scanner;

class GreatestFactorWhile {

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        //declare variable  here
        int number;

        int greatestFactor = 1 ;

        int counter ;

        number = sc.nextInt();
        counter = number -1;

        // while loop for counter here
        while (counter >= 1) {

            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
         counter--;
        }
        // printing result with syso here
        System.out.println("Greatest factor is. : " + greatestFactor);
    }
}