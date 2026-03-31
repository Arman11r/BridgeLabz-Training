import java.util.*;

public class InvertMap {

    public static void main(String[] args) {

        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (String key :originalMap.keySet( )){
            int value =originalMap.get(key) ;

            if (!invertedMap.containsKey(value) ){
                invertedMap.put(value, new ArrayList<> () );
            }

            invertedMap.get(value).add (key);
        }

        System.out.println(invertedMap) ;
    }
}