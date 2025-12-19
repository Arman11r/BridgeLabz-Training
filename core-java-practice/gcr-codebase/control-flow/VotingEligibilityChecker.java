import java.util.Scanner;

class VotingEligibilityChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declare -variable
        int age;

        // Take inputhere
        System.out.print("Enter age: ");
        age = sc.nextInt();

        // Check voting eligibility here below
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
    }
}