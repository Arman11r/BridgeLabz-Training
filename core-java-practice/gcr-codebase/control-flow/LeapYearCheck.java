import java.util.Scanner;

class LeapYearCheck {

    public static void main(String[] args) {

        // scanner for input created here
        Scanner sc = new Scanner(System.in);
        //variable
        int year;

        // asking year from user
        System.out.print("Enter year: ");
        year = sc.nextInt();

        // leap year only valid after 1582 for limited code

        if (year >= 1582) {

            if (year % 400 == 0) {
                System.out.println("Year is a Leap Year");

            }
             else if (year % 100 == 0) {
                System.out.println("Year is not a Leap Year");
            } 
            else if (year % 4 == 0) {
                System.out.println("Year is a Leap Year");
            } 
            else {
                System.out.println("Year is not a Leap Year");
            }

        } 
        else {

            System.out.println("Year is not in gregorian calendar");
        }

    }
}