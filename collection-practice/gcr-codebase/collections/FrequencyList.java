import java.util.*;

public class FrequencyList {

    public static void main(String[] args) {

        List<String> car = new ArrayList<>();
        car.add("porche");
        car.add("bmw");
        car.add("farari");
        car.add("morris garages");

        Map<String, Integer> freqMaping = new HashMap<>();

        // counting frequency
        for (String cars : car) {

            if (freqMaping.containsKey(cars)) {
                freqMaping.put(cars, freqMaping.get(cars) + 1);
            } else {
                freqMaping.put(cars, 1);
            }
        }

        System.out.println("frequency map :"+freqMaping);
    }
}