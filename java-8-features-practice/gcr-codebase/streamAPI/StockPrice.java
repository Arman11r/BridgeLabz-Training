import java.util.*;

public class StockPrice{

    public static void main(String[] args) {

        List<Double> prices = Arrays.asList(102.0, 103.2, 101.0, 104.0);

        System.out.println("Live stock prices:");

        prices.forEach(price -> {
            System.out.println("Price: " + price);
        });
    }
}