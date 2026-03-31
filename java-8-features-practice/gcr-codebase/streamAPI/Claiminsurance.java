import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;

    Claim(String t, double a) {
        type = t;
        amount = a;
    }
}

public class Claiminsurance{

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
                new Claim("Health", 5000),
                new Claim("Health", 7000),
                new Claim("Car", 9000),
                new Claim("Bike", 4000),
                new Claim("Home", 10000)
        );

        Map<String, Double> avg =
                claims.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.type,
                                Collectors.averagingDouble(c -> c.amount)
                        ));

        System.out.println(avg);
    }
}