import java.time.LocalDate;
import java.util.Scanner;

class DateComparison {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        // taking first date

        System.out.print("Enter first date (YYYY-MM-DD): ");
        String firstInput = sc.nextLine();
        LocalDate firstDate = LocalDate.parse(firstInput);


        // taking second date
        System.out.print("Enter second date (YYYY-MM-DD): ");


        String secondInput = sc.nextLine();
        LocalDate secondDate = LocalDate.parse(secondInput);

        // comparing both dates
        
        if (firstDate.isBefore(secondDate)) {

            System.out.println("First date is before the second date.");

        } else if (firstDate.isAfter(secondDate)) {

            System.out.println("First date is after the second date. .");

        } else {


            System.out.println("Both dates are equal.");
        }

        sc.close();
    }
}