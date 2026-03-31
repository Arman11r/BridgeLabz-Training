import java.time.LocalDate;

interface Dateinterface {

    static String format(LocalDate date) {
        return date.getDayOfMonth() + " - " + date.getMonthValue() + " - " + date.getYear();
    }
}

public class Date {

    public static void main(String[] args) {

        System.out.println(Dateinterface.format(LocalDate.now()));
    }
}