import java.util.Scanner;

class RocketCountdownWhile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare counter variable here is
        int counter;

        // Take input beloww
        System.out.print("Enter countdown start number: ");
        counter = sc.nextInt();

        // Countdown loop here
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}