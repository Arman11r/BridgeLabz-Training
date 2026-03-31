// base employee class
class Employee {

    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("name: " + name);

        System.out.println("id : " + id);

        System.out.println("salary. : " + salary);
    }
}

// manager class
class Manager extends Employee {

    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    void  displayDetails() {
        super.displayDetails();
        System.out.println("team size: " + teamSize);
    }
}

// developer class
class Developer extends Employee 
{


    String programmingLanguage;


    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }


    void displayDetails() {
        super.displayDetails();
        System.out.println("language: " + programmingLanguage);

    }
}

// intern class
class Intern extends Employee {

    int duration;

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("intern duration: " + duration + " months");
    }
}

public class EmployeeEnh {
    public static void main(String[] args) {

        Employee e1 = new Manager("rajesh", 101, 70000, 5);
        Employee e2 = new Developer("anita", 102, 60000, "java");
        Employee e3 = new Intern("vijay", 103, 15000, 6);

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}