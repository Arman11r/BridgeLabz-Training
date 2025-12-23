
public class Student {

    // university name same
    private static String universityName;

    // counting students
    private static int totalStudents = 0;

    // roll number fixed
    private final int rollNumber;

    // student name
    private String name;

    // grade
    private char grade;

    // constructor
    public Student(String name, int rollNumber, char grade) {

        // using this
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;

        // increasing count
        totalStudents++;
    }

    // setting university name
    public static void setUniversityName(String name) {
        universityName = name;
    }

    // displaying student count
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // displaying student details
    public void displayStudentDetails() {

        // checking instance
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    // updating grade
    public void updateGrade(char newGrade) {

        // checking instance again
        if (this instanceof Student) {
            grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    public static void main(String[] args) {

        // setting university
        Student.setUniversityName("Global University");

        // creating students
        Student s1 = new Student("Hemashree", 101, 'A');
        Student s2 = new Student("Sharmila", 102, 'B');

        // displaying count
        Student.displayTotalStudents();

        // displaying details
        s1.displayStudentDetails();
        s2.displayStudentDetails();

        // updating grade
        s2.updateGrade('A');
        s2.displayStudentDetails();
    }
}