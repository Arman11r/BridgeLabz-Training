import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {

    public static void main(String[] args) {

        String text = "hello there how r you";

        String[] words = text.split(" ");

        Map<String, Integer> freq =
                Arrays.stream(words)
                        .collect(Collectors.toMap(
                                w -> w,
                                w -> 1,
                                (a, b) -> a + b   // merge duplicates
                        ));

        System.out.println(freq);
    }
}