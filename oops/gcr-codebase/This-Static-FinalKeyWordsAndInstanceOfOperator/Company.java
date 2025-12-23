
public class Company {

    // company name common
    private static String companyName;

    // counting employees
    private static int totalEmployees = 0;

    // employee name
    private String name;

    // id should not change
    private final int id;

    // job role
    private String designation;

    // constructor
    public Company(String name, int id, String designation) {

        // using this keyword
        this.name = name;
        this.id = id;
        this.designation = designation;

        // increasing employee count
        totalEmployees++;
    }

    // setting company name
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // showing employee count
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // displaying employee details
    public void displayEmployeeDetails() {

        // checking object type
        if (this instanceof Company) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {

        // setting company name
        Company.setCompanyName("Tech Solutions Inc.");

        // creating employees
        Company emp1 = new Company("Thamarai", 101, "Software Engineer");
        Company emp2 = new Company("Rohan", 102, "Project Manager");

        // showing total
        Company.displayTotalEmployees();

        // displaying details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}