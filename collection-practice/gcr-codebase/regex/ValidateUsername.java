import java.util.*;

public class ValidateUsername {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking username input heree
        System.out.print("Enter username:");
        String username = sc.nextLine();

        // regex for username rules
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";

        // checking username
        if (username.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid ");
        }

        sc.close();
    }
}