import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenue {

    static class Order {
        String customer;
        double amount;

        Order(String customer, double amount) {
            this.customer = customer;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        orders.add(new Order("Arman", 200));
        orders.add(new Order("Bhaskar", 150));
        orders.add(new Order("Rachit", 300));

        Map<String, Double> revenue =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                o -> o.customer,
                                Collectors.summingDouble(o -> o.amount)
                        ));

        System.out.println(revenue);
    }
}