public class FirstNegativeNumber {

    public static void main(String[] args) {
        //array
        int[] arr = {5, 10, 3, -4, 6};
        //function call here
        int index = findFirstNegative(arr);
        //output
        System.out.println("Index: " + index);
    }

    public static int findFirstNegative(int[] arr) {

        // Traverse array using for
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }

        // No negative found then print -1 classic approch here
        return -1;
    }
}