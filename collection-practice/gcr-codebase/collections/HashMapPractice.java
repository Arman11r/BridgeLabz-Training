import java.util.*;

public class HashMapPractice {

    // -----------------------------
    // 1. word frequency counter
    // -----------------------------
    public static Map<String, Integer> countWordFrequency(String text) {

        // hashmap to store word and count
        Map<String, Integer> frequencyMap = new HashMap<>();

        // convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z ]", "");

        // split words by space
        String[] words = text.split("\\s+");

        // count each word
        for (String word : words) {

            // skip empty words
            if (word.length() == 0) {
                continue;
            }

            // increase count
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        return frequencyMap;
    }

    // -----------------------------
    // 2. invert a map
    // -----------------------------
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {

        // new map for inverted result
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {

            K key = entry.getKey();
            V value = entry.getValue();

            // if value not present, create new list
            invertedMap.putIfAbsent(value, new ArrayList<>());

            // add key to list
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }

    // -----------------------------
    // 3. find key with highest value
    // -----------------------------
    public static String findMaxValueKey(Map<String, Integer> map) {

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    // -----------------------------
    // main method
    // -----------------------------
    public static void main(String[] args) {

        // -------- problem 1 --------
        String text = "Hello world, hello Java!";
        Map<String, Integer> wordCount = countWordFrequency(text);

        System.out.println("Word Frequency:");
        System.out.println(wordCount);

        // -------- problem 2 --------
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        System.out.println("\nInverted Map:");
        System.out.println(invertedMap);

        // -------- problem 3 --------
        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("A", 10);
        scoreMap.put("B", 20);
        scoreMap.put("C", 15);

        String highestKey = findMaxValueKey(scoreMap);

        System.out.println("\nKey with Highest Value:");
        System.out.println(highestKey);
    }
}