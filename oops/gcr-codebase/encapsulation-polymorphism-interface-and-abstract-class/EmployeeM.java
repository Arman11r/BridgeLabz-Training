import java.util.ArrayList;
import java.util.List;

// department interface
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// abstract employee class
abstract class Employee {

    // private fields for safety
    private int employeeId;
    private String name;
    private double baseSalary;

    // department info
    protected String department;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // abstract salary logic
    abstract double calculateSalary();

    // showing employee info
    void displayDetails() {
        System.out.println("id: " + employeeId);
        System.out.println("name: " + name);
        System.out.println("salary: " + calculateSalary());
        System.out.println("department: " + department);
        System.out.println("----------------");
    }

    // getters
    public double getBaseSalary() {
        return baseSalary;
    }
}

// full time employee
class FullTimeEmployee extends Employee implements Department {

    FullTimeEmployee(int id, String name, double salary) {
        
        super(id, name, salary);
    }

    // fixed salary
    double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// part time employee
class PartTimeEmployee extends Employee implements Department {

    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name, 0);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    // salary by hours
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeM {
    public static void main(String[] args) {

        // polymorphism list
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "ravi", 50000);
        Employee e2 = new PartTimeEmployee(102, "anita", 80, 300);

        ((Department)e1).assignDepartment("HR");


        ((Department)e2).assignDepartment("IT");


        employees.add(e1);
        employees.add(e2);

        // processing employees
        for(Employee e : employees) {
            e.displayDetails();
        }
    }
}