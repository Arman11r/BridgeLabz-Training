import java.util.Scanner;

class averageofthreenumbers {
    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Asking the user to enter first number
        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();

        // Asking the user to enter second number
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();

        // Asking the user to enter third number
        System.out.print("Enter third number: ");
        double n3 = sc.nextDouble();

        // Calculating  the average of three numbers taken
        double average = (n1 + n2 + n3) / 3;

        // Displaying the calculated average here
        System.out.println("Average of the three numbers is:  " + average);
    }
}
