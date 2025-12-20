import java.util.Scanner;

class ReverseNumberArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int temp = number;

                // counting digits
        int count = 0;

        while (temp != 0) {
            temp = temp / 10;
            count++;
        }
        // creating array of size count
        int[] digits = new int[count];
        int index = 0;



        // storing digits
        while (number != 0) {
            digits[index++] = number % 10;
            number = number / 10;
        }

        // printing reverse
        for (int i = 0; i < digits.length; i++) {

            System.out.print(digits[i]);
        }
    }
}