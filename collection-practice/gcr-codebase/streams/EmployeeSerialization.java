import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {

    int id;
    String name;
    String dep;
    double salary;

    Employee(int id, String name,String dep, double salary) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.salary = salary;
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "arman", "it", 50000));
        employees.add(new Employee(2, "ayushi", "hr", 40000));

        // serialization
        try {
            ObjectOutputStream oo =
                    new ObjectOutputStream(new FileOutputStream("employee.ser"));

            oo.writeObject(employees);
            oo.close();

            System.out.println("employees saved");

        } catch (IOException e) {
            System.out.println("error saving");
        }

        // deserialization
        try {
            ObjectInputStream oi =
                    new ObjectInputStream(new FileInputStream("employee.ser"));

            List<Employee> list = (List<Employee>) oi.readObject();



            for (Employee emp : list) {
                System.out.println(emp.id + "  " + emp.name + "  " + emp.dep + "  " + emp.salary);
            }

            oi.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error while reading");
        }
    }
}