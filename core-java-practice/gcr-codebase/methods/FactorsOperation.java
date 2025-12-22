class FactorsOperation {
    // Method to find all factors of a number
    static int[] findFactors(int number) {
// counting factors
        int count = 0;
// finding count of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        // creating array to hold factors
        int[] factors = new int[count];
        int index = 0;
        // storing factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
// returning factors array
        return factors;
    }
    // method to find smallest factor
    static int greatestFactor(int[] factors) {
        return factors[factors.length - 2];
    }
 // method to find sum of factors
    static int sumFactors(int[] factors) {
        //  calculating sum
        int sum = 0;
// iterating through factors
        for (int f : factors) sum += f;

        return sum;
    }
// method to find product of factors
    static long productFactors(int[] factors) {

        long product = 1;

        for (int f : factors) product *= f;

        return product;
    }
// method to find product of cubes of factors
    static double cubeProduct(int[] factors) {

        double product = 1;

        for (int f : factors) {
            product *= Math.pow(f, 3);
        }

        return product;
    }
}