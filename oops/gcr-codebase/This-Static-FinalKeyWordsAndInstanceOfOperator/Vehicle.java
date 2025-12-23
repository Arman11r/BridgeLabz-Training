
public class Vehicle {

    // registration fee common
    private static double registrationFee = 100;

    // registration number fixed
    private final String registrationNumber;

    // owner name
    private String ownerName;

    // vehicle type
    private String vehicleType;

    // constructor
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {

        // assigning using this
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // updating fee
    public static void updateRegistrationFee(double newFee) {

        // checking valid fee
        if (newFee >= 0) {
            registrationFee = newFee;
        }
    }

    // displaying details
    public void displayRegistrationDetails() {

        // checking instance
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {

        // updating fee
        Vehicle.updateRegistrationFee(150);

        // creating vehicles
        Vehicle v1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle v2 = new Vehicle("Price danish", "SUV", "XYZ789");

        // displaying details
        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();
    }
}