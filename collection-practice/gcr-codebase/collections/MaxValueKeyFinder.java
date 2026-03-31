import java.util.HashMap;
import java.util.Map;

public class MaxValueKeyFinder {

    public static void main(String[] args) {

        // creating map to store key and value
        Map<String, Integer> map = new HashMap<>();

        // adding values in map
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // variable to store max key
        String maxKey = null;

        // taking very small value at start
        int maxValue = Integer.MIN_VALUE;

        // loop through all keys
        for (String key : map.keySet()) {

            // getting value for current key
            int value = map.get(key);

            // checking if value is greater
            if (value > maxValue) {
                maxValue = value;   // updating max value
                maxKey = key;       // updating max key
            }
        }

        // printing result
        System.out.println("Key with highest value: " + maxKey);
    }
}