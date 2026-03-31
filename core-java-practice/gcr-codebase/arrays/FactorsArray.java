import java.util.Scanner;

class FactorsArray {

    public static void main(String[] args) {
        //scanner here
        Scanner sc = new Scanner(System.in);
    //input number here
        System.out.print("Enter a number to find its factors: ");
        int number = sc.nextInt();
        // size of factors array
        int maxSize = 10;
        // array to store factors
        int[] factors = new int[maxSize];
        // index to track number of factors found
        int index = 0;

        // finding factors of the number below
        for (int i = 1; i <= number; i++) {

            if (number % i == 0) {

                if (index == maxSize) {

                    maxSize = maxSize * 2;
                    int[] temp = new int[maxSize];

                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                factors[index++] = i;
            }
        }

        // printing factors

        for (int i = 0; i < index; i++) {


            System.out.print(factors[i] + " ");

        }
    }


}