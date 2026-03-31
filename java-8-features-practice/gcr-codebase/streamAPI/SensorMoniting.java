import java.util.*;

public class SensorMoniting{

    public static void main(String[] args) {

        List<Double> readings = Arrays.asList(22.5, 35.1, 18.4, 40.3, 29.0);

        double threshold = 30;

        readings.stream()
                .filter(value -> value > threshold)
                .forEach(value -> System.out.println("Alert: " + value));
    }
}