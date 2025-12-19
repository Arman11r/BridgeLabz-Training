import java.util.*;

class EmployeeBonusCalculator {

    public static void main(String[] args) {

        // scanner used for inputs

        Scanner sc = new Scanner(System.in);

        // salary of employee
        double salary;

        // total service years
        int yearsOfService;

        // bonus initially zero
        double bonusAmount = 0.0;

        // taking salary input
        System.out.print("Enter employee salary: ");

        salary = sc.nextDouble();


        // taking service years input
        System.out.print("Enter years of service: ");

        yearsOfService = sc.nextInt();

        // bonus given only if service more than 5 year
        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05;
        }

        // printing bonus amount

        System.out.println("The bonus amount is: " + bonusAmount);
    }
}