public class PeakElement {

    public static void main(String[] args) {
//define arr
        int[] arr = {1, 3, 20, 4, 1};

//function call here
        int peak = findPeak(arr);
//output
            System.out.println("Peak Element Index: " + peak);
    }

    public static int findPeak(int[] arr) {
        //binary search approach here classicly done similar to earlier questions
        int left = 0, right = arr.length - 1;



        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) 
                {

                left = mid + 1;

            } else {
                right = mid;
            }
        }

        
        return left;
    }
}