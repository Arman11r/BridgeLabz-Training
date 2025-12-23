class Product {

    // product name
    String productName;

    // product price
    double price;

    // total products count
    static int totalProducts = 0;

    // constructor
    Product(String name, double price) {
        this.productName = name;
        this.price = price;
        totalProducts++; // increasing count
    }

    // showing product details
    void displayProductDetails() {
        System.out.println(productName + " price " + price);
    }

    // showing total products
    static void displayTotalProducts() {
        System.out.println("Total products: " + totalProducts);
    }

    public static void main(String[] args) {
// creating product objects
        Product p1 = new Product("Pen", 10);
        Product p2 = new Product("Book", 100);
        //  displaying product details
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}