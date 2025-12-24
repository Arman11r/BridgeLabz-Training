import java.util.ArrayList;
import java.util.List;

// patient class
class Patient {

    // patient name
    String name;

    Patient(String name) {

        this.name = name;

    }
}

// doctor class

class Doctor {

    // doctor name
    String name;

    // patients list
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    // consulting patient
    void consult(Patient p) {
        patients.add(p);

        System.out.println("doctor " + name + " consult patient " + p.name);
    }
}

public class Hospital {
    public static void main(String[] args) {

        Doctor d1 = new Doctor("Dr Kumar");

        Patient p1 = new Patient("Ravi");

        Patient p2 = new Patient("Arman");

        d1.consult(p1);
        
        d1.consult(p2);
    }
}