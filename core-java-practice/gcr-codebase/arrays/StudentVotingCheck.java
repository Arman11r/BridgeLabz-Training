import java.util.Scanner;

class StudentVotingCheck {

    public static void main(String[] args) {

        // scanner for input here
        Scanner sc =new Scanner(System.in);

        // array for storing age of 10 student
        int[] ages = new int[10] ;

        // taking age input for the voting checking
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student" + (i +1)  + " :  ");
            ages[i] = sc.nextInt();

        }

        // checking voting condition throught for loop here
        for (int i = 0; i < ages.length; i++) {

            if (ages[i] < 0) {
                System.out.println("invalid age");

            } else if (ages[i] >= 18) {

                System.out.println("The student with the age " + ages[i] + " can vote");
            } else {

                System.out.println("The student with the age " + ages[i] + " cannot vote");
            }
            
        }
    }
}