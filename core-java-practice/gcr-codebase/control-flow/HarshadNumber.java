import java.util.Scanner;

class HarshadNumber {

    public static void main(String[] args) {
        //scanner created here
        Scanner sc = new Scanner(System.in);
        // declare variable here
        int number;

        int originalNumber;

        int sum = 0;

        number = sc.nextInt();


        originalNumber = number;

        // sum of digits
        while (originalNumber != 0) {
            //in while loop
            sum = sum + (originalNumber % 10);

            originalNumber = originalNumber / 10;

        }

        // checking divisibility anf printinh output
        if (number % sum == 0) {

            System.out.println("Harshad Number");
        } 
        else {
            System.out.println("Not a Harshad Number");
        }
    }
}