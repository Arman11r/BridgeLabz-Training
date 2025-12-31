class Vehicle {

    // owner name
    String ownerName;

    // vehicle type
    String vehicleType;

    // registration fee for all
    static double registrationFee = 500;

    // constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // displaying vehicle details
    void displayVehicleDetails() {
        System.out.println(ownerName + " owns " + vehicleType);
    }

    // updating fee
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
}