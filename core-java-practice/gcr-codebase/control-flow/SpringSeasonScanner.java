import java.util.Scanner;

class SpringSeasonScanner  {

    public static void main(String[] args) {

        // scanner object
        Scanner sc = new Scanner(System.in);

        // month and day input
        
        int month, day;

        // taking month

        System.out.print("Enter  month: ");
        month = sc.nextInt();

        // taking day

        System.out.print("Enter day : ");
        day = sc.nextInt();

        // checking spring season logic
        boolean isSpringSeason =

                (month == 3 && day >= 20 && day <= 31) ||
                (month == 4 && day >= 1 && day <= 30) ||
                (month == 5 && day >= 1 && day <= 31) ||
                (month == 6 && day >= 1 && day <= 20);

        // printing result

        if (isSpringSeason) {

            System.out.println("Its a Spring Seasonm");
        } else {

            System.out.println("Not a Spring  Season");
        }
    }
}