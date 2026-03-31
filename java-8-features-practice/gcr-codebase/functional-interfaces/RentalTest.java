interface RentalVehicle {
    void rent();
    void returnVehicle();
}

class Car implements RentalVehicle {

    public void rent() {
        System.out.println("Car rented out");
    }

    public void returnVehicle() {
        System.out.println("Car returned back");
    }
}

class Bike implements RentalVehicle {

    public void rent() {
        System.out.println("Bike rented out");
    }

    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}

public class RentalTest {

    public static void main(String[] args) {

        RentalVehicle v1 = new Car();
        RentalVehicle v2 = new Bike();

        v1.rent();
        v2.rent();
    }
}