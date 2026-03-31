import java.util.Scanner;

class StudentGrade {

    public static void main(String[] args) {

        // scanner object crreatd here
        Scanner sc = new Scanner(System.in);
        //VARIABLE
        double physics, chemistry, maths;
        double totalMarks;
        double percentage;
        char grade;
        String remarks;

        // taking marks
        physics  = sc.nextDouble();
        chemistry =  sc.nextDouble();
        maths  = sc.nextDouble();

        // calculating total and percentage
        totalMarks = physics + chemistry + maths;
        percentage = totalMarks / 3;

        // deciding grade using if statemts
        if (percentage >= 80) {
            grade = 'A';
            remarks = "Level 4";
        } 
        else if (percentage >= 70) {
            grade = 'B';
            remarks = "Level 3";
        } else if (percentage >= 60) {
            grade = 'C';
            remarks = "Level 2";
        } 
        else if (percentage >= 50) {
            grade = 'D';
            remarks = "Level 1";
        } else if (percentage >= 40) {
            grade = 'E';
            remarks = "Too below";
        } 
        else {

            grade = 'R' ;
            remarks = "Remedial ";
        }

        // printing output below one by one

        System.out.println("Average Marks: " +  percentage);


        System.out.println("Grade: " + grade );
        
        System.out.println("Remarks: " + remarks);
    }
}