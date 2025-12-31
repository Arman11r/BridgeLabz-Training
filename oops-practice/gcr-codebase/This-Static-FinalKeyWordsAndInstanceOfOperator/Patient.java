

public class Patient {

    // hospital name same
    private static String hospitalName;

    // counting patients
    private static int totalPatients = 0;

    // patient id fixed
    private final String patientID;

    // patient name
    private String name;

    // patient age
    private int age;

    // disease info
    private String ailment;

    // constructor
    public Patient(String name, int age, String ailment, String patientID) {

        // assigning values
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;

        // increasing count
        totalPatients++;
    }

    // setting hospital name
    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    // getting patient count
    public static int getTotalPatients() {
        return totalPatients;
    }

    // displaying patient details
    public void displayPatientDetails() {

        // checking instance
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {

        // setting hospital
        Patient.setHospitalName("City Hospital");

        // creating patients
        Patient p1 = new Patient("Lathika", 30, "Flu", "P001");
        Patient p2 = new Patient("Lidiya", 45, "Fracture", "P002");

        // showing count
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

        // displaying details
        p1.displayPatientDetails();
        p2.displayPatientDetails();
    }
}