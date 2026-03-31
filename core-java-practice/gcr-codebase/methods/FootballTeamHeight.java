class FootballTeamHeight {// class to calculate football team players height stats

    // this method create random height for players
    static int[] generateHeights() {

        int[] heights = new int[11];

        // loop for all 11 players
        for (int i = 0; i < heights.length; i++) {

            // height between 150 to 250 cm
            heights[i] = 150 + (int)(Math.random() * 101);
        }

        return heights;
    }

    // method to calculate total height
    static int findSum(int[] heights) {

        int sum = 0;

        // adding all heights
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];

        }
        // returning sum
        return sum;
    }

    // mean height formula
    static double findMean(int[] heights) {

        int total = findSum(heights);
        return (double) total / heights.length;

    }


    // shortest player height
    static int findShortest(int[] heights) {

        int min = heights[0];



        // comparing one by one
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }

        return min;
    }


    // tallest player height
    static int findTallest(int[] heights) {

        int max = heights[0];

        for (int i = 1; i < heights.length; i++

        ) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {

        int[] heights = generateHeights();

        System.out.println("Players heights:");

        for (int h : heights) {
            System.out.print(h + " ");
        }
// printing results
        System.out.println("\nShortest height: " + findShortest(heights));
        System.out.println("Tallest height: " + findTallest(heights));
        System.out.println("Mean height: " + findMean(heights));
    }
}