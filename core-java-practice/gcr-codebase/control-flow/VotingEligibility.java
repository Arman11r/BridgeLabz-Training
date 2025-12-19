import java.util.Scanner;

class VotingEligibility {

    public static void main(String[] args) {

        // scanner for input

        Scanner sc = new Scanner(System.in);

        // age of person

        int age;

        // asking age

        System.out.print("Enter age: ");
        age = sc.nextInt();

        // checking voting condition

        if (age >= 18) {

            System.out.println("The person's age is " + age + " and can vote .");
        } else {

            System.out.println("The persons age is :  " + age + " and caannot vote .");
        }
    }
}