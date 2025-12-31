import java.util.ArrayList;
import java.util.List;

// faculty class
class Faculty {

    // faculty name
    String name;

    Faculty(String name) {
        
        this.name = name;
    }
}

// department class (composition)
class Department {

    // department name
    String deptName;

    Department(String deptName) {
        this.deptName = deptName;
    }
}

// university class
class University {

    // university name
    String name;

    // departments list
    List<Department> departments = new ArrayList<>();

    // faculties list
    List<Faculty> faculties = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    // adding department
    void addDepartment(Department d) {
        departments.add(d);
    }

    // adding faculty
    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    // closing university
    void closeUniversity() {
        departments.clear(); // departments removed
        System.out.println("university closed, department gone");
    }
}

public class UniversityDemo {

    public static void main(String[] args) {

        University uni = new University("Gla University");

        Department d1 = new Department("CSE");
        Department d2 = new Department("MCA");



        Faculty f1 = new Faculty("Shatrugan Sinha");

        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.addFaculty(f1);


        uni.closeUniversity();

        // faculty still exist
        System.out.println("faculty still working : " + f1.name);
    } 
}