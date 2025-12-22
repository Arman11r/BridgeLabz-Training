
import java.util.*;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = sc.nextInt();
        }

        for (int index = 0; index < numbers.length; index++) {
            if (isPositive(numbers[index])) {
                System.out.println(numbers[index] + " is Positive and " + (isEven(numbers[index]) ? "Even" : "Odd"));
            } else {
                System.out.println(numbers[index] + " is Negative");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 0) {
            System.out.println("First and last elements are equal");
        } else if (comparisonResult == 1) {
            System.out.println("First element is greater than last");
        } else {
            System.out.println("First element is less than last");
        }
    }

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) return 1;
        else if (firstNumber == secondNumber) return 0;
        else return -1;
    }
}