import java.util.Scanner;// class to find maximum of three numbers

class MaxOfThree {
// main method
    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        // taking three numbers from user
        int firstNumber = getInput(sc, "Enter first number: ");
        int secondNumber = getInput(sc, "Enter second number: ");
        int thirdNumber = getInput(sc, "Enter third number: ");

        // finding maximum number
        int maximum = findMax(firstNumber, secondNumber, thirdNumber);

        // printing result
        System.out.println("Maximum number is: " + maximum);

        sc.close();
    }

    // method to take input with message
    static int getInput(Scanner sc, String message) {
            
        System.out.print(message);
        return sc.nextInt();
    }

    // method to find maximum among three numbers
    static int findMax(int a, int b, int c) {

        int max = a;

        // comparing with second number
        if (b > max) {
            max = b;
        }

        // comparing with third number
        if (c > max) {
            max = c;
        }
        // returning maximum
        return max;
    }
}