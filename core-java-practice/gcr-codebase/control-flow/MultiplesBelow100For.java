import java.util.Scanner;

class MultiplesBelow100For {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // declare variable here
        int number;

        number = sc.nextInt();


        // checking valid range
        if (number > 0 && number < 100) {

            // loop backward for mulipls jhere
            for (int i = 100; i >= 1; i--) {

                if (i % number == 0) {
                    System.out.println(i);
                }
            }

        } else {
            //wrong
            System.out.println("number not in  range ");
        }
    }
}