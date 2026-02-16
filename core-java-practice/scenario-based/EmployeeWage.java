import java.util.*;
import java.util.stream.*;

interface EmpWageInterface {
    void addCompany(String name, int wagePerHour, int workingDays, int maxHours);
    void computeWages();
    int getTotalWage(String name);
}

class CompanyEmpWage {
    String name;
    int wagePerHour;
    int workingDays;
    int maxHours;
    int totalWage;
    List<Integer> dailyWages = new ArrayList<>();

    CompanyEmpWage(String name, int wagePerHour, int workingDays, int maxHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
    }

    void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
}

class EmpWageBuilder implements EmpWageInterface {
    List<CompanyEmpWage> companies = new ArrayList<>();

    public void addCompany(String name, int wagePerHour, int workingDays, int maxHours) {
        companies.add(new CompanyEmpWage(name, wagePerHour, workingDays, maxHours));
    }

    public void computeWages() {
        companies.forEach(company -> {
            int[] totalHours = {0};
            int[] totalDays = {0};
            Random random = new Random();

            while (totalHours[0] < company.maxHours && totalDays[0] < company.workingDays) {
                int empCheck = random.nextInt(3);
                int empHours = empCheck == 1 ? 4 : empCheck == 2 ? 8 : 0;
                totalHours[0] += empHours;
                totalDays[0]++;
                company.dailyWages.add(empHours * company.wagePerHour);
            }

            int totalWage = company.dailyWages.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            company.setTotalWage(totalWage);
        });
    }

    public int getTotalWage(String name) {
        return companies.stream()
                .filter(c -> c.name.equalsIgnoreCase(name))
                .map(c -> c.totalWage)
                .findFirst()
                .orElse(0);
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        EmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 110);

        builder.computeWages();

        System.out.println("TCS Total Wage: " + builder.getTotalWage("TCS"));
        System.out.println("Infosys Total Wage: " + builder.getTotalWage("Infosys"));
    }
}