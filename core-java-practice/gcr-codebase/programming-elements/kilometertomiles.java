import java.util.Scanner;

class kilometertomiles {
    public static void main(String[] args) {

        // Created Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter distance in kilometers
        System.out.print("  Enter distance in kilometers: ");
        double km = sc.nextDouble();

        // Converting kilometers to miles using the given formula

        double miles = km * 0.621371;

        // Displayed the converted distance
        System.out.println(" Distance in miles is:  " + miles);
    }
}
