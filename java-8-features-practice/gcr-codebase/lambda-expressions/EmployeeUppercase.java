import java.util.*;
import java.util.stream.Collectors;

public class EmployeeUppercase {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("arman", "bhaskar", "kaushik", "kiran");
        List<String> upperNames =
                names.stream().map(String::toUpperCase).collect(Collectors.toList());
        for (String n : upperNames) {
            System.out.println(n);
        }
    }
}