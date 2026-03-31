import java.util.Scanner;

public class ValidateIP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking ip input
        System.out.println("Enter IP address here:");
        String ip = sc.nextLine();

        // regex for ipv4
        String regex =
                "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        if (ip.matches(regex)) {
            System.out.println("Valid IP");
        } else {
            System.out.println("Invalid IP a");
        }

        sc.close();
    }
}