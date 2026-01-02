import java.util.*;

// base course type
abstract class CourseType {
    String courseName;

    CourseType(String name ) {
        courseName = name;
    }
}

// different courses
class ExamCourse extends CourseType {
    ExamCourse(String name ) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name ){
        super(name);
    }
}

// generic course handler
class Course<T extends CourseType> {
    List<T> courses = new ArrayList<>() ;

    void addCourse(T c )  {
        courses.add(c);
    }

    List<T> getCourses() {
        return courses;
    }
}

public class University {

    static void showCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println("course :" + c.courseName);
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> exam = new Course<>();
        exam.addCourse(new ExamCourse("Maths "));

        Course<AssignmentCourse> assign = new Course<>();
        assign.addCourse(new AssignmentCourse("AI. "));

        showCourses(exam.getCourses () );
        showCourses(assign.getCourses () );
    }
}