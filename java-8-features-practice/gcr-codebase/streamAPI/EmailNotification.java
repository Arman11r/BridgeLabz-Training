import java.util.*;

public class EmailNotification {

    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "arman@gmail.com",
                "bhaskar@gmail.com",
                "rachit@gmail.com"
        );

        emails.forEach(email -> sendEmail(email));
    }
    static void sendEmail(String mail) {
        System.out.println("Notification send " + mail);
    }
}