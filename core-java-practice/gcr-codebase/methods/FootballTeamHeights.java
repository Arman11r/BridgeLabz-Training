
import java.util.*;

public class FootballTeamHeights {
    // method to generate random heights for players
    public static void main(String[] args) {
        // Generate random heights for 11 players
        int[] playerHeightsCm = generateHeights(11);
        System.out.println("Player Heights (in cm): " + Arrays.toString(playerHeightsCm));

        // calculate statistics
        int totalHeightCm = getSum(playerHeightsCm);

        double meanHeightCm = getMean(playerHeightsCm);

        int shortestHeightCm = getShortest(playerHeightsCm);
        int tallestHeightCm = getTallest(playerHeightsCm);
        // print statistics
        System.out.println("Total Height: " + totalHeightCm + " cm");


        System.out.println("Mean Height: " + meanHeightCm + " cm");

        System.out.println("Shortest Player: " + shortestHeightCm + " cm");

        System.out.println("Tallest Player: " + tallestHeightCm + " cm");


    }

    public static int[] generateHeights(int playerCount) {
        // Generate random heights between 150 cm and 250 cm
        Random random = new Random();

        int[] heights = new int[playerCount];
        for (int playerIndex = 0; playerIndex < playerCount; playerIndex++) {
            // heights between 150 and 250 cm
            heights[playerIndex] = random.nextInt(101) + 150;
        }
        //  Return the generated heights
        return heights;
    }

        // method to calculate sum of heights
    public static int getSum(int[] heights) {
        int sum = 0;
        // iterate through heights to calculate sum
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // method to calculate mean height
    public static double getMean(int[] heights) {
        return getSum(heights) / (double) heights.length;
    }

    // method to get shortest height
    public static int getShortest(int[] heights) {
        int minimumHeight = Integer.MAX_VALUE;
        for (int height : heights) {
            if (height < minimumHeight) {
                minimumHeight = height;
            }
        }
        return minimumHeight;
    }
    // method to get tallest height

    public static int getTallest(int[] heights) {
        int maximumHeight = Integer.MIN_VALUE;
        for (int height : heights) {
                // check for maximum height
            if (height > maximumHeight) {
                
                maximumHeight = height;
            }// end of if
        }
        return maximumHeight;
    }
}