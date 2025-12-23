import java.time.LocalDate; //importing LocalDate class
import java.time.format.DateTimeFormatter; //for these type of questions

class DateFormatterExample {

    public static void main(String[] args) {

        // getting today date
        LocalDate todayDate = LocalDate.now();

        // creating different date formats
        DateTimeFormatter formatOne =
        
                DateTimeFormatter.ofPattern("dd/MM/yyyy");


        DateTimeFormatter formatTwo =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");


        DateTimeFormatter formatThree =
                DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // printing date in different formats
        System.out.println("Format 1: " + todayDate.format(formatOne));
        System.out.println("Format 2: " + todayDate.format(formatTwo));
        
        System.out.println("Format 3: " + todayDate.format(formatThree));
    }
}