import java.util.*;

public class Namesort {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Arman", "Rachit", "Sneha", "Bhaskar");

        names.stream()
                .map(n -> n.toUpperCase())
                .sorted()
                .forEach(System.out::println);
    }
}