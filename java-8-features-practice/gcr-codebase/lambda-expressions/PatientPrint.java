import java.util.*;

public class PatientPrint {

    public static void main(String[] args) {

        List<Integer> patientIds = new ArrayList<>();

        patientIds.add(1);
        patientIds.add(2);
        patientIds.add(3);
        patientIds.add(4);

        System.out.println("Patient id:");

        patientIds.forEach(System.out::println);
    }
}