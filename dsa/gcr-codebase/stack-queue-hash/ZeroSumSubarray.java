import java.util.HashMap;

class ZeroSumSubarray {

    // method to find zero sum subarrays
    public static void findSubarrays(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>(); //hashmap 
        int sum = 0;

        // base sum zero count
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            sum = sum + value;

            // if sum already exist
            if (map.containsKey(sum)) {

                System.out.println("zero sum subarray found");
            }

            // update frequency
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }

    // main method
    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 1, 2, -6, 3};

        findSubarrays(arr);
    }
}