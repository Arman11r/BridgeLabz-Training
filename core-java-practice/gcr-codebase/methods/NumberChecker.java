import java.util.Scanner;

class NumberChecker {

    public static void main(String[] args) {

        // scanner for taking number input
        Scanner sc = new Scanner(System.in);

        // number given by user
        int inputNumber = sc.nextInt();

        // finding how many digits are there
        int digitCount = countDigits(inputNumber);

        // storing digits into array
        int[] digits = getDigitsArray(inputNumber, digitCount);


        // printing digit count
        System.out.println("Count of digits: " + digitCount);

        // checking duck number
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

        // checking armstrong number
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(digits, inputNumber));

        // finding largest and second largest digit
        int[] largestTwo = findLargestTwo(digits);
        System.out.println("Largest: " + largestTwo[0] +
                ", Second Largest: " + largestTwo[1]);

        // finding smallest and second smallest digit
        int[] smallestTwo = findSmallestTwo(digits);
        System.out.println("Smallest: " + smallestTwo[0] +
                ", Second Smallest: " + smallestTwo[1]);
    }

    // method to count digits in a number
    public static int countDigits(int number) {

        // counter variable
        int count = 0;

        // loop runs till number becomes zero
        while (number != 0) {
            count++;
            number = number / 10;
        }

        return count;
    }

    // method to convert number into digit array
    public static int[] getDigitsArray(int number, int digitCount) {

        int[] digits = new int[digitCount];

        // storing digits from last position
        for (int index = digitCount - 1; index >= 0; index--) {


            digits[index] = number % 10;

            // reducing number
              number = number / 10;
        }

        return digits;
    }

    // method to check duck number
    public static boolean isDuckNumber(int[] digits) {

        // duck number has zero but not at first place
        for (int index = 1; index < digits.length; index++) {
            if (digits[index] == 0) {
                return true;
            }
        }

        return false;
    }

    // method to check armstrong number
    public static boolean isArmstrongNumber(int[] digits, int number) {

        int power = digits.length;
        int sum = 0;

        // calculating sum of digit^power
        for (int i = 0; i < digits.length; i++) {

            int digit = digits[i];
            int temp = 1;

            // calculating power manually
            for (int j = 1; j <= power; j++) {
                temp = temp * digit;
            }

            sum = sum + temp;
        }

        return sum == number;
    }

    // method to find largest and second largest digit
    public static int[] findLargestTwo(int[] digits) {

        int largest = digits[0];
        int secondLargest = digits[0];

        // finding largest
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > largest) {
                largest = digits[i];
            }
        }

        // finding second largest
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != largest) {
                if (secondLargest == largest || digits[i] > secondLargest) {
                    secondLargest = digits[i];
                }
            }
        }

        return new int[]{largest, secondLargest};
    }

    // method to find smallest and second smallest digit
    public static int[] findSmallestTwo(int[] digits) {

        int smallest = digits[0];
        int secondSmallest = digits[0];

        // finding smallest
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] < smallest) {
                smallest = digits[i];
            }
        }

        // finding second smallest
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != smallest) {
                if (secondSmallest == smallest || digits[i] < secondSmallest) {
                    secondSmallest = digits[i];
                }
            }
        }

        return new int[]{smallest, secondSmallest};
    }
}