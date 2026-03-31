import java.util.Scanner;

class ArmStrongNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number;

        int originalNumber;

        int digit;

        int sum =0;


        number = sc.nextInt();
        originalNumber = number;

        // loop till number not zeros

        while (originalNumber != 0) {

            digit = originalNumber % 10;
            sum = sum + (digit * digit * digit);
            originalNumber = originalNumber / 10;
            
        }

        // checking armstrong
        if (sum == number) {
            System.out.println("Armstrong Number ");
        } 
        else  {
            System.out.println("Not an Armstrong  Number ");
        }
    }
}