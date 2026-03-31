import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String t, String m) {
        type = t;
        message = m;
    }
}

public class AlertFilter {

    public static void main(String[] args) {

        List<Alert> alerts = new ArrayList<>();

        alerts.add(new Alert("CRITICAL", "Heart rate abnormal"));
        alerts.add(new Alert("INFO", "Medicine reminder"));
        alerts.add(new Alert("CRITICAL", "Blood pressure high"));
        alerts.add(new Alert("INFO", "Daily checkup done"));

        // show only critical alerts
        Predicate<Alert> onlyCritical =
                a -> a.type.equals("CRITICAL");

        System.out.println("Important Alerts:");

        for (Alert a : alerts) {
            if (onlyCritical.test(a)) {
                System.out.println(a.message);
            }
        }
    }
}