import java.util.function.Predicate;

public class TemperatureAlert {

    public static void main(String[] args) {

        Predicate<Double> highTemp = t -> t > 40;

        double temp = 45;

        if (highTemp.test(temp)) {
            System.out.println("Temperature too high");
        }
    }
}