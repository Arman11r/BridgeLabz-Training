import java.time.LocalDate;
import java.util.Scanner;

class DateArithmetic {
// main method
    public static void main(String[] args) {

        // scanner for taking date input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();

        // converting string date to LocalDate
        LocalDate date = LocalDate.parse(inputDate);

        // adding 7 days

        LocalDate updatedDate = date.plusDays(7);

        // adding 1 month
        updatedDate = updatedDate.plusMonths(1);


        // adding 2 years
        updatedDate = updatedDate.plusYears(2);




        // subtracting 3 weeks
        updatedDate = updatedDate.minusWeeks(3);

        // printing final date
        System.out.println("Final Date after arithmetic operations : "
                + updatedDate);

        sc.close();
    }
}