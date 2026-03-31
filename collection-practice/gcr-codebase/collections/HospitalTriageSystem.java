import java.util.PriorityQueue;

// Patient class
class Patient implements Comparable<Patient> {

    String name;
    int severity;

    // constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // higher severity comes first
    @Override
    public int compareTo(Patient other) {
        return other.severity - this.severity;
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>();

        // adding patients
        queue.add(new Patient("Arman", 1));
        queue.add(new Patient("Bhaskar", 5));
        queue.add(new Patient("Kartik", 2));

        System.out.println("Treatment Order:  ");

        // treating patients
        while (!queue.isEmpty()) {
            Patient p = queue.remove();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}