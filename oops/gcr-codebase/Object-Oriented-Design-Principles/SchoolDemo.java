import java.util.ArrayList;
import java.util.List;

// course class
class Course {

    // course name
    String courseName;

    // students list
    List<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    // adding student to course
    void addStudent(Student s) {
        students.add(s);
    }

    // showing all students
    void showStudents() {
        System.out.println("students in  " + courseName);
        for(Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

// student class
class Student {

    // student name
    String name;

    // courses list
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    // enrolling course
    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);
    }

    // showing enrolled courses
    void viewCourses() {
        System.out.println(name + " enrolled courses");
        for(Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

// school class (aggregation)
class School {

    // school name
    String schoolName;

    // students list
    List<Student> students = new ArrayList<>();

    School(String schoolName) {
        this.schoolName = schoolName;
    }

    // adding student to school
    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolDemo {
    public static void main(String[] args) {

        // creating school
        School school = new School("GLA");

        // creating students
        Student s1 = new Student("Arman");
        Student s2 = new Student("Kartik");

        // creating courses
        Course c1 = new Course("Java");
        Course c2 = new Course("Python");

        // adding students to school
        school.addStudent(s1);
        school.addStudent(s2);

        // enrolling courses
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        // display info
        s1.viewCourses();
        c1.showStudents();
    }
}