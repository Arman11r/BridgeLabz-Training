import java.util.*;
import java.util.stream.Collectors;

public class StudentGrouping {

    static class Student {
        String name;
        String grade;

        Student(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student("Arman", "A"));
        list.add(new Student("Bhaskar", "B"));
        list.add(new Student("Sneha", "A"));
        list.add(new Student("Rachit", "C"));

        // group grade -> names
        Map<String, List<String>> result =
                list.stream()
                        .collect(Collectors.groupingBy(
                                s -> s.grade,
                                Collectors.mapping(s -> s.name, Collectors.toList())
                        ));

        System.out.println(result);
    }
}