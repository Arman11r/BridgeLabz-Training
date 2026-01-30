import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean weekendAvailable;

    Doctor(String n, String s, boolean w) {
        name = n;
        specialty = s;
        weekendAvailable = w;
    }

    @Override
    public String toString() {
        return name + " - " + specialty;
    }
}

public class DoctorStream {

    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Arman", "Cardiology", true),
                new Doctor("Ankit", "Dermatology", false),
                new Doctor("Bhaskar", "Neurology", true),
                new Doctor("Pooja", "Orthopedic", true)
        );

        System.out.println("Weekend available doctors:");

        doctors.stream()
                .filter(d -> d.weekendAvailable)
                .sorted((d1, d2) -> d1.specialty.compareTo(d2.specialty))
                .forEach(System.out::println);
    }
}