import java.util.*;

public class EventWelcoming {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList("Arman", "Bhaskar", "Rachit", "Pooja");

        attendees.forEach(name -> {
            System.out.println("Welcome to the event, " + name );
        });
    }
}