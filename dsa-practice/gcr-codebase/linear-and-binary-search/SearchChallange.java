import java.util.Arrays;

public class SearchChallange {

    public static void main(String[] args) {
//defiining array and target
        int[] arr = {3, 4, -1, 1};
        int target = 4;
            //function calls here and also print here
        System.out.println("First Missing Positive: " + firstMissingPositive(arr));
        System.out.println("Target Index: " + binarySearch(arr, target));
    }

    // Linear Search logic
    public static int firstMissingPositive(int[] arr) {
//using boolean array to track present numbers
        boolean[] present = new boolean[arr.length + 1];
//marking present numbers using for loop advanced
        for (int num : arr) {
            if (num > 0 && num <= arr.length) {
                present[num] = true;
            }
        }
//checking for first missing positive
        for (int i = 1; i <= arr.length; i++) {
            if (!present[i]) return i;
        }

        return arr.length + 1;
    }

    // Binary Search logic as used in earler questions same logic classical
    public static int binarySearch(int[] arr, int target) {

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;

            else if (arr[mid] < target) left = mid + 1 ;

            else right = mid - 1;
        }



        return -1;
    }
}