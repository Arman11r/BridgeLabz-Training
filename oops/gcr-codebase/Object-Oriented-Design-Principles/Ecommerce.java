import java.util.ArrayList;
import java.util.List;

// product class
class Product {

    // product name and price
    String name;
    double price;

    Product(String name, double price) {

        this.name = name;

        this.price = price;

    }
}

// order class
class Order {

    // order products
    List<Product> products = new ArrayList<>();

    // adding product
    void addProduct(Product p) {
        products.add(p);
    }

    // calculating total

    double calculateTotal() {
        double total = 0;
        for(Product p : products) {
            
            total = total + p.price;
        }
        return total;
    }
}

// customer class
class Customer {

    // customer name
    String name;

    Customer(String name) {
        this.name = name;
    }

    // placing order
    void placeOrder(Order o) {
        System.out.println(name + " placed order");
        System.out.println("total bill: " + o.calculateTotal());
    }
}

public class Ecommerce {
    public static void main(String[] args) {

        Customer c1 = new Customer("Arman");

        Product p1 = new Product("Laptop", 150000);
        Product p2 = new Product("Attack Shark Mouse X3 superlight", 3169);

        Order order = new Order();
        order.addProduct(p1);
        order.addProduct(p2);

        c1.placeOrder(order);
    }
}