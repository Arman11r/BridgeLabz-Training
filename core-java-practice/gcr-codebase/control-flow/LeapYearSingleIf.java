import java.util.Scanner;

class LeapYearSingleIf {

    public static void main(String[] args) {


        //scanner created sc
        Scanner sc = new Scanner (System.in);
        //variabel
        int year;
        //input
        System.out.print("Enter year: ");
        year = sc.nextInt();

        // single if logic aas per the question
        if (year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {

            System.out.println("Year is a Leap Year");
        } 
        else {
            
            System.out.println("Year is not a Leap Year");
        }
    }
}