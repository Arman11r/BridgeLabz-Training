import java.util.Scanner;

class LargestSecondLargestDynamic {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        // Read an integer from the user
        int number = sc.nextInt();
        int maxDigit = 10;

        int[] digits = new int[maxDigit];
        int index = 0;

        // storing digits with resize
        while (number != 0) {

            if (index == maxDigit) {

                maxDigit = maxDigit + 10;

                // Create a new array with the updated size
                int[] temp = new int[maxDigit];

                for (int i = 0; i < digits.length; i++) {


                    temp[i] = digits[i];
                }

                digits = temp;

            }
            // Store the current digit
            digits[index++] = number % 10;
            number = number / 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
                // finding largest
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest : " + largest);
        System.out.println("Second Largest : " + secondLargest);
    }
}