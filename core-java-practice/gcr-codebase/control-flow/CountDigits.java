import java.util.Scanner;

class CountDigits {

    public static void main(String[] args) {
        //scanner created here
        Scanner sc = new Scanner(System.in);
        //VARIABLES
        int number;
        int count = 0;
        //input taken here
        number = sc.nextInt();

        // loop for counting digits
        while (number != 0) {
            number = number / 10;
            count++;
        }
        // output here given
        System.out.println("Number of digits: " + count);
    }
}