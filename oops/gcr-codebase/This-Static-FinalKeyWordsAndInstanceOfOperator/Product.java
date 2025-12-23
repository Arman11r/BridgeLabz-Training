
public class Product {

    // discount for all products
    private static double discount = 0;

    // product id should not change
    private final String productID;

    // product name
    private String productName;

    // price of product
    private double price;

    // quantity count
    private int quantity;

    // constructor
    public Product(String productID, String productName, double price, int quantity) {

        // assigning values
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // updating discount
    public static void updateDiscount(double newDiscount) {

        // checking valid discount
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
        }
    }

    // calculating discounted price
    public double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    // displaying product details
    public void displayProductDetails() {

        // checking instance
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + getDiscountedPrice());
        }
    }

    public static void main(String[] args) {

        // updating discount
        Product.updateDiscount(10);

        // creating products
        Product p1 = new Product("P001", "Laptop", 1200, 5);
        Product p2 = new Product("P002", "Smartphone", 800, 10);

        // displaying products
        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}