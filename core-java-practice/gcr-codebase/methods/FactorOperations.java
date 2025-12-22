
import java.util.*;

public class FactorOperations {
    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();
        // finding factors

        int[] factorArray = findFactors(inputNumber);
        System.out.println("Factors: " + Arrays.toString(factorArray));
        // performing operations
        int sumOfFactors = sumOfFactors(factorArray);
        int productOfFactors = productOfFactors(factorArray);

        int sumOfSquares = sumOfSquares(factorArray);
        // printing results
        System.out.println("Sum of factors: " + sumOfFactors);
        
        System.out.println("Product of factors: " + productOfFactors);
        System.out.println("Sum of squares of factors: " + sumOfSquares);
    }
    // method to find factors of a number
    public static int[] findFactors(int number) {
        int factorCount = 0;
        for (int divisor = 1; divisor <= number; divisor++) {
            if (number % divisor == 0) factorCount++;
        }
        // create array to hold factors
        int[] factors = new int[factorCount];
        int factorIndex = 0;
        for (int divisor = 1; divisor <= number; divisor++) {
            if (number % divisor == 0) {
                factors[factorIndex++] = divisor;
            }
        }   // end of for loop to find factors
        return factors;
    }
    //  methods to perform operations on factors

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) sum += factor;
        return sum;
    }
    // method to calculate product of factors
    public static int productOfFactors(int[] factors) {
        int product = 1;


        for (int factor : factors) product *= factor;
        return product;
    }



    // method to calculate sum of squares of factors
    public static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int factor : factors) sum += Math.pow(factor, 2);
        return sum;
    }
}

//end of codee
