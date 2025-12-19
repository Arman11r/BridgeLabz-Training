import java.util.Scanner;

class RocketCountdownFor2  {

    public static void main(String[] args) {

        // scanner objects here for input 
        Scanner sc = new Scanner(System.in);

        // starting number for countdown here
        int counter;

        // taking input from the uswr
        System.out.print("Enter countdown start number: ");
        counter = sc.nextInt();

        // for loop countdown here below
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }
}