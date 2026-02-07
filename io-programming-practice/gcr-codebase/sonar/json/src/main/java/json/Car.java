package json;
public class Car {

    private int carId;
    private String brand;
    private String model;
    private double price;

    // constructor
    public Car(int carId, String brand, String model, double price) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}