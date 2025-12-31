import java.util.HashMap;

class PairWithSum {

    // method to check pair
    public static boolean hasPair(int[] arr, int target) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int value = arr[i];
            int required = target - value;

            // check if pair exist
            if (map.containsKey(required)) {
                return true;
            }

            // store current value
            map.put(value, true);
        }
//esle
        return false;
    }

    // main method
    public static void main(String[] args) {
//difining vaslues for function
        int[] arr = {8, 7, 2, 5, 3, 1};

        int target = 10;


        System.out.println(hasPair(arr, target));
    }
}


