import java.util.Scanner;

class EmployeeBonusArray {

    public static void main(String[] args) {

        // scanner for input here
        Scanner sc =new Scanner(System.in);
        // arrays for salary, years of service, bonus and new salary
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        // totals for bonus, old salary and new salar
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        // taking input ofr the qsn
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary here: ");
            salary[i] = sc.nextDouble();
            System.out.print("Enter years of service done:");
            years[i] = sc.nextDouble();
            // invalid value checker
            if (salary[i] <= 0 || years[i] < 0) {
                System.out.println("invalid input please enter again");
                i--;
                continue;
            }
        }
        // calculating bonus here uisng this logic 
        for (int i = 0; i < 10; i++) {
            if (years[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus = totalBonus + bonus[i];
            totalOldSalary = totalOldSalary + salary[i];
            totalNewSalary = totalNewSalary + newSalary[i];
        }
        // printing totals here on output
        System.out.println("Total old salary : " + totalOldSalary);
        System.out.println("Total bonus payout. : " + totalBonus);
        System.out.println("Total new salary : " + totalNewSalary);
    }
}