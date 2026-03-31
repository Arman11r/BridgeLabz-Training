import java.util.ArrayList;
import java.util.List;

// insurance interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// abstract vehicle
abstract class Vehicle {

    private String vehicleNumber;
    protected double rentalRate;

    Vehicle(String vehicleNumber, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);

    String getVehicleNumber() {
        return vehicleNumber;
    }
}

// car class
class Car extends Vehicle implements Insurable {

    Car(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "car insurance";
    }
}

// bike class
class Bike extends Vehicle implements Insurable {

    Bike(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 200;
    }

    public String getInsuranceDetails() {
        return "bike insurance";
    }
}

// truck class
class Truck extends Vehicle implements Insurable {

    Truck(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return rentalRate * days * 1.5;
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "truck insurance";
    }
}

public class VehicleM{
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("UP01", 1500));
        vehicles.add(new Bike("HR02", 500));
        vehicles.add(new Truck("DL03", 3000));

        for(Vehicle v : vehicles) {
            System.out.println("vehicle: " + v.getVehicleNumber());
            
            System.out.println("rent: " + v.calculateRentalCost(3));
            System.out.println("insurance: " +
                    ((Insurable)v).calculateInsurance());
            System.out.println("----------------");
        }
    }
}