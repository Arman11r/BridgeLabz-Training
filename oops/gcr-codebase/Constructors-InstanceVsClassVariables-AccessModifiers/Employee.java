class Employee {

    // public employee id
    public int employeeID;

    // protected department
    protected String department;

    // private salary
    private double salary;

    // updating salary
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
// subclass Manager
class Manager extends Employee {

    // accessing parent class data
    void display() {
        System.out.println(employeeID + " " + department);
    }
}