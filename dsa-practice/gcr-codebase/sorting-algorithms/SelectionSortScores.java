class SelectionSortScores {

    public static void main(String[] args) {

        // exam scores
        int[] scores = {65, 90, 75, 50, 85};

        // selection sort logic
        for (int i = 0; i < scores.length - 1; i++) 
            {

            int minIndex = i;

            // finding minimum
            for (int j = i + 1; j < scores.length; j++) 
                {
                if (scores[j] < scores[minIndex]) {

                    minIndex = j;
                }
            }

            // swapping values
            int temp = scores[minIndex];

            scores[minIndex] = scores[i];

            scores[i] = temp;
        }

        // printing sorted scores
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]   + " ");
        }
    }
}