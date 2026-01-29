interface VehicleDashboard {

    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available.");
    }
}


class PetrolCar implements VehicleDashboard {

    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }
}


class ElectricCar implements VehicleDashboard {

    public void displaySpeed() {
        System.out.println("Speed: 55 km/h");
    }

    public void displayBattery() {
        System.out.println("Battery: 85%");
    }
}


public class Vehicle {

    public static void main(String[] args) {

        VehicleDashboard v1 = new PetrolCar();
        v1.displaySpeed();
        v1.displayBattery();

        VehicleDashboard v2 = new ElectricCar();
        v2.displaySpeed();
        v2.displayBattery();
    }
}