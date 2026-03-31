import java.util.Scanner;

public class LicensePlateValidate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking license plate input
        System.out.print("Enter license plate number: ");
        String plate = sc.nextLine();

        // regex for license plate format
        String regex = "^[A-Z]{2}[0-9]{4}$";

        // checking license plate
        if (plate.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid ");
        }

        sc.close();
    }
}