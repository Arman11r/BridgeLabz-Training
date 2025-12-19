import java.util.Scanner;

class MultiplesBelow100While {

    public static void main(String[] args) {
        //scanner created here
        Scanner sc = new Scanner(System.in);
        // declare variable here

        int number;
        int counter = 100;

        number = sc.nextInt();

        // while loop for counter here
        while (counter >= 1) {

            if (counter % number == 0) {
                System.out.println(counter);
            }
         counter--; // decrementing counter for while loop.

         
        }
    }
}