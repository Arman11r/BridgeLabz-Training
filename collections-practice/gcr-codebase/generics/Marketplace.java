// base product class
abstract class Product 
{
    String name;
    double price;

    Product(String name,double price ) {
        this.name = name;
        this.price = price;
    }
}

// product types
class Book extends Product {
    Book(String name,double price ) {
        super(name, price);
    }
}

class Clothing extends Product {
    Clothing(String name,double price ) {
        super(name, price);
    }
}

class Gadget extends Product {
    Gadget(String name,double price ) {
        super(name, price);
    }
}

public class Marketplace {

    // generic method for discount
    static <T extends Product> void applyDiscount(T p, double percent) {
        p.price = p.price - (p.price * percent / 100);
    }

    public static void main(String[] args ) {

        Book b = new Book("Java Book" , 500);
        Clothing c = new Clothing("T-Shirt", 1000);

        applyDiscount(b, 10);
        applyDiscount(c, 20);

        System.out.println(b.name + " price" + b.price);
        System.out.println(c.name + " price " + c.price);
    }
}