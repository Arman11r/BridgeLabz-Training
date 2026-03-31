import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String n, double p, double r, double d) {
        name = n;
        price = p;
        rating = r;
        discount = d;
    }
}

public class ProductSorter {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("phone", 20000, 4.5, 10));
        list.add(new Product("laptop", 60000, 4.8, 5));
        list.add(new Product("bike", 5000, 4.2, 20));

        Scanner sc = new Scanner(System.in);

        System.out.println(" 1.price  2.rating  3.discount");
        int ch = sc.nextInt();

        if (ch == 1) list.sort((a, b) -> Double.compare(a.price, b.price));
        
        else if (ch == 2) list.sort((a,b) -> Double.compare(b.rating, a.rating));
        
        else list.sort((a, b) -> Double.compare(b.discount, a.discount));
        

        for (Product p : list) {
            System.out.println(p.name + " | " + p.price + " | " + p.rating + " | " + p.discount + "%");
        }

        sc.close();
    }
}