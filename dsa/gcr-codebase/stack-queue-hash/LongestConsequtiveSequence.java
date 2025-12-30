import java.util.HashMap;

class LongestConsecutiveSequence {

    // method to find longest sequence
    public static int findLongest(int[] arr) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        // store all elements
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        int maxLength = 0;

        // loop array
        for (int i = 0; i < arr.length; i++) {

            // check if start of sequence
            if (!map.containsKey(arr[i]  - 1)) {

                int current = arr[i];
                int count = 1;

                // count consecutive numbers
                while (map.containsKey(current + 1)) {
                    current++;
                    count++;
                }

                // update max length
                maxLength = Math.max(maxLength, count);
            }
        }
// return max length
        return maxLength;
    }

    // main method
    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println(findLongest(arr));
    }
}