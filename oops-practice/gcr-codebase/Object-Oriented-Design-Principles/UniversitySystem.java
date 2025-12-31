import java.util.ArrayList;
import java.util.List;

// professor class
class Professor {

    // professor name
    String name;

    Professor(String name) {
        this.name = name;
    }
}

// course class
class Course {

    // course name

    String courseName;

    // professor teaching

    Professor professor;

    Course(String courseName) {
        this.courseName = courseName;
        
    }

    // assigning professor
    void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println(p.name + "teaching " + courseName);
    }
}

// student class
class Student {

    // student name
    String name;

    // enrolled courses
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    // enrolling course
    void enrollCourse(Course c) {
        courses.add(c);
        System.out.println(name + " enrolled  " + c.courseName);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {

        Student s1 = new Student("Arjun");
        Professor p1 = new Professor("Dr Rana ji");

        Course c1 = new Course("Data Structures and algo ");

        c1.assignProfessor(p1);
        s1.enrollCourse(c1);
    }
}