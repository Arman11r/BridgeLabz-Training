import java.util.Scanner;

class RocketCountdownWhile2 {

    public static void main(String[] args) {

        // scanner for input values

        Scanner sc = new Scanner(System.in);

        // counter valuess

        int counter;

        // asking start number from the userr

        System.out.print("Enter countdown for start numbers :  ");
        counter = sc.nextInt();

        // loop for countdowns

        while (counter >= 1) {
            System.out.println(counter );
            counter--;
        }
    }
}