class Employee {

    // storing employee data
    private String name;
    private int id;
    private double salary;

    // constructor for setting values
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // showing employee details
    void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " +id);
        System.out.println("Employee Salary: " + salary);
    }
    // main method
    public static void main(String[] args) {

        // object creation
        Employee emp = new Employee("Rohan", 1, 500000);

        // calling display
        emp.displayEmployee();
    }
}