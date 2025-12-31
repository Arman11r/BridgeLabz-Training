class BubbleSort {

    public static void main(String[] args) {

        // student marks array
        int[] marks = {78, 45, 90, 66, 82};

        // bubble sort logic
        for (int i = 0; i < marks.length - 1; i++) {

            // comparing adjacent values
            for (int j = 0; j < marks.length - 1 - i; j++) {

                if (marks[j] > marks[j + 1]) {

                    // swapping marks
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }

        // printing sorted marks
        for (int i=0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
    }
}