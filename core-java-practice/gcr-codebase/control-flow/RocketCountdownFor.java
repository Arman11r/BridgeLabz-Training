import java.util.Scanner;

class RocketCountdownFor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Declare counter variable here
        System.out.print("Enter countdown start number: ");                     
        // Take input
        int counter = sc.nextInt();

        // For loop countdown
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }
}