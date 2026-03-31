import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalary {

    static class Employee {
        String department;
        double salary;

        Employee(String department, double salary) {
            this.department = department;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("IT", 50000));
        employees.add(new Employee("IT", 60000));
        employees.add(new Employee("HR", 40000));

        Map<String, Double> avg =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avg);
    }
}