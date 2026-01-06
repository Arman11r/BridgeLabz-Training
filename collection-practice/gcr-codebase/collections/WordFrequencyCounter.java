import java.util.HashMap;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String text = "Helloooowww how is you!! Hello, helloo.";

        // convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z ]", "");

        String[] words = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();


        for (int i = 0; i < words.length; i++){

            String word = words[i];

            if (map.containsKey(word)){

                map.put(word, map.get(word) + 1) ;

            } else 
                {
                map.put(word, 1) ;

            }
        }

        System.out.println (map) ;
    }
}