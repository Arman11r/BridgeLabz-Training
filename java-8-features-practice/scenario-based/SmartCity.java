import java.util.*;
import java.util.stream.*;

public class SmartCity {


    interface TransportService {
        String getType();
        double getFare();
        String getRoute();
        String getDepartureTime();

        default void printServiceDetails() {
            System.out.println(getType() + " | " + getRoute() +
                    " | Fare: " + getFare() +
                    " | Time: " + getDepartureTime());
        }
    }

   
    interface GeoUtils {
        static double calculateDistance(String from, String to) {
            return Math.random() * 50;
        }
    }


    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(double baseFare, double distance);
    }


    interface EmergencyService { }


    static class BusService implements TransportService {
        String type, route, time;
        double fare;

        BusService(String t, double f, String r, String time) {
            type = t; fare = f; route = r; this.time = time;
        }

        public String getType() { return type; }
        public double getFare() { return fare; }
        public String getRoute() { return route; }
        public String getDepartureTime() { return time; }
    }

    static class MetroService extends BusService {
        MetroService(String t, double f, String r, String time) {
            super(t,f,r,time);
        }
    }

    static class TaxiService extends BusService {
        TaxiService(String t, double f, String r, String time) {
            super(t,f,r,time);
        }
    }

   
    static class Passenger {
        String name, route;
        double fare;

        Passenger(String n, String r, double f) {
            name=n; route=r; fare=f;
        }

        public String toString() {
            return name + " -> " + route + " : " + fare;
        }
    }

   
    public static void main(String[] args) {


        FareCalculator calc = (base, dist) -> base + dist * 0.5;

        double distance = GeoUtils.calculateDistance("A","B");
        double newFare = calc.calculateFare(2.5, distance);


        List<TransportService> services = Arrays.asList(
                new BusService("Bus", newFare, "A-B", "10:30"),
                new MetroService("Metro", 3.0, "B-C", "11:00"),
                new TaxiService("Taxi", 5.0, "C-A", "11:30")
        );


        services.sort((a,b) -> Double.compare(a.getFare(), b.getFare()));

    
        services.forEach(TransportService::printServiceDetails);


        List<Passenger> passengers = Arrays.asList(
                new Passenger("Arman","A-B",2.5),
                new Passenger("Alice","A-B",2.5),
                new Passenger("Bob","B-C",3.0)
        );

      

  
        System.out.println("\nGrouped by route:");
        Map<String, List<Passenger>> grouped =
                passengers.stream().collect(Collectors.groupingBy(p -> p.route));
        grouped.forEach((r,p) -> System.out.println(r + " -> " + p));


        DoubleSummaryStatistics stats =
                passengers.stream().collect(Collectors.summarizingDouble(p -> p.fare));

        System.out.println("\nTotal Revenue: " + stats.getSum());
        System.out.println("Average Fare: " + stats.getAverage());
    }
}