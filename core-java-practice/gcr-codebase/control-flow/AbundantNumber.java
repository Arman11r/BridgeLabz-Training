import java.util.Scanner;

class AbundantNumber {

    public static void main(String[] args) {
        // scanner created here
        Scanner sc = new Scanner(System.in) ;

        int number;

        int sum =0;

        number = sc.nextInt();

        // finding divisors ..
        for (int i = 1; i < number; i++) {

            if (number % i == 0) {
                sum = sum +i;
            }
        }

        // checking abundant. heree
        if (sum > number){
            System.out.println("Abundant Number ");
        } else {
            System.out.println("Not an Abundant  Number");
        }
        sc.close();
    }
}