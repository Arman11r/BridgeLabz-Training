import java.util.*;

class PrimeNumberCheck {

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int number;
        boolean isPrime = true;


        number = sc.nextInt();

        // prime only for > 1

        if (number <= 1) {

            isPrime = false;

        } else {

            // checking divisibility here


            for (int i = 2; i < number; i++) {

                if (number % i == 0) {

                    isPrime = false;
                    break;
                }
            }
        }

        // printing result

        if (isPrime) {
            
            System.out.println("Prime Number");
        } 
        else {
            
            System.out.println("Not a Prime Number");
        }
    }
}