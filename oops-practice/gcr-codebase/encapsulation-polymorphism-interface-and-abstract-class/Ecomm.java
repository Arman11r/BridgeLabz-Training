import java.util.ArrayList;
import java.util.List;

// taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// abstract product
abstract class Product {

    private int productId;
    private String name;


    private double price;

    Product(int productId, String name, double price) {


        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    double getPrice() {
        return price;

    }

    String getName() 
    {
        return name;
    }
}

// electronics product
class Electronics extends Product implements Taxable {

    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "18% gst";
    }
}

// clothing product
class Clothing extends Product implements Taxable {

    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.20;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "5% tax";
    }
}

// groceries product
class Groceries extends Product {

    Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class Ecomm {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "laptop", 60000));
        products.add(new Clothing(2, "shirt", 2000));
        products.add(new Groceries(3, "rice", 1200));

        // final price calculation
        for(Product p : products) {

            double tax = 0;

            if(p instanceof Taxable) {
                tax = ((Taxable)p).calculateTax();
            }

            double finalPrice =
                    p.getPrice() + tax - p.calculateDiscount();

            System.out.println(p.getName() + " final price: " + finalPrice);
        }
    }
}