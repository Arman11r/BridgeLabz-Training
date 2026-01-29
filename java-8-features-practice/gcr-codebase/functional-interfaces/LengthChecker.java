import java.util.function.Function;

public class LengthChecker {

    public static void main(String[] args) {

        Function<String, Integer> lengthFinder = s -> s.length();

        String message = "Hello world";

        int len = lengthFinder.apply(message);

        System.out.println("Length: " + len);
    }
}