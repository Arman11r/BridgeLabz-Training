import java.util.*;

class DivisibleByFive {

    public static void main(String[] args) {

        // scanner use for taking input
        Scanner sc = new Scanner(System.in);


        // number enter by user
        int number;

        // asking user number
        System.out.print("Enter a number: ");
        number = sc.nextInt();


        // checking number divisible by 5 or not
        boolean isDivisibleByFive = (number % 5 == 0);

        // printing answer
        System.out.println("Is the number " + number + " divisible by 5. ? " + isDivisibleByFive);
    }
}