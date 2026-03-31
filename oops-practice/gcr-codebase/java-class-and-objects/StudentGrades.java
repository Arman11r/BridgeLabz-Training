

class StudentGrades {

    // student data
    private String name;
    private String rollNumber;
    private double[] marks;

    // constructor
    StudentGrades(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // calculating average marks
    private double calculateAverage() {

        double sum = 0;

        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }

        return sum / marks.length;
    }

    // finding grade
    private String calculateGrade() {

        double avg = calculateAverage();

        if (avg >= 80) {
            return "Grade A";
        } else if (avg >= 60) {
            return "Grade B";
        } else if (avg >= 50) {
            return "Grade C";
        } else if (avg >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    // displaying student details
    void displayStudent() {

        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark " + (i + 1) + ": " + marks[i]);
        }

        System.out.println(calculateGrade());
        System.out.println();
    }

    public static void main(String[] args) {
        // creating student objects
        StudentGrades s1 =
                new StudentGrades("Thamarai", "ECE001",
                        new double[]{80, 70, 75});

        StudentGrades s2 =
                new StudentGrades("Kannan", "CSC002",
                        new double[]{60, 65, 50});
        // displaying student details
        s1.displayStudent();
        s2.displayStudent();
    }
}