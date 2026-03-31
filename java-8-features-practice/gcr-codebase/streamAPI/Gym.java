import java.time.*;
import java.util.*;

class Member {
    String name;
    LocalDate expiry;

    Member(String n, LocalDate e) {
        name = n;
        expiry = e;
    }
    @Override
    public String toString() {
        return name + " -> " + expiry;
    }
}

public class Gym {

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("Arman", LocalDate.now().plusDays(10)),
                new Member("Bhaskar", LocalDate.now().plusDays(100)),
                new Member("Rachit", LocalDate.now().plusDays(20))
        );

        System.out.println("Expiring soon:\n");

        members.stream()
                .filter(m -> m.expiry.isBefore(LocalDate.now().plusDays(30)))
                .forEach(System.out::println);
    }
}