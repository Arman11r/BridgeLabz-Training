import java.util.*;



class RandomStats {

    public static void main(String[] args) {

        // generating array of random 4 digit numbers
        int[] randomNumbers = generateFourDigitNumbers(5);

        // finding average, min and max
        double[] result = findAverageMinMax(randomNumbers);

        // printing generated numbers
        System.out.println("Generated 4-digit numbers. : "
                + Arrays.toString(randomNumbers));

        // printing results
        System.out.println("Average: " + result[0]);


        System.out.println("Minimum:" + result[1]);
        System.out.println("Maximum:" + result[2]);
    }

    // this method generate random 4 digit numbers
    public static int[] generateFourDigitNumbers(int size) {

        int[] numbers = new int[size];

        // loop for generating random numbers
        for (int i = 0; i < size; i++) {

            // random gives 0 to 0.999 so making 4 digit
            numbers[i] = 1000 + (int)(Math.random() * 9000);
        }

        return numbers;
    }

    // this method find average, min and max
    public static double[] findAverageMinMax(int[] numbers) {

        double[] stats = new double[3];

        int sum = 0;
        // initializing min and max
        int minimum = numbers[0];
        int maximum = numbers[0];

        // looping through array
        for (int i = 0; i < numbers.length; i++) {

            int currentNumber = numbers[i];
            sum = sum + currentNumber;

            // checking for minimum
            if (currentNumber < minimum) {
                minimum = currentNumber;
            }

            // checking for maximum
            if (currentNumber > maximum) {
                maximum = currentNumber;
            }
        }

        // calculating average
        double average = (double) sum / numbers.length;

        // storing results
        stats[0] = average;
        
        stats[1] = minimum;
        stats[2] = maximum;
        // returning stats array
        return stats;
    }
}