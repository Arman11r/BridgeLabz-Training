import java.util.*;

class EmployeeBonus {

    public static void main(String[] args) {

        // scanner object
        Scanner sc = new Scanner(System.in);

      // salary of employee
        double salary;
        // service years
        int yearsOfService;

        // bonus value
        double bonus = 0.0;

        // asking salary
        System.out.print("Enter salary: ");
        
        salary = sc.nextDouble();

        // asking service year here
        System.out.print("Enter years  of service:  ");
        
        yearsOfService = sc.nextInt();

        // bonus conditions heree
        if (yearsOfService > 5) {
          bonus = salary * 0.05;
        }

        // printing bonuses
        System.out.println("Bonus amount is: " + bonus);
    }
}