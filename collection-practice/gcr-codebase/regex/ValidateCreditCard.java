import java.util.Scanner;

public class ValidateCreditCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking card number
        System.out.println("Enter card number here below:");
        String card = sc.nextLine();

        // visa and mastercard regex
        String visaRegex = "^4[0-9]{15}$";
        String mstrRegex = "^5[0-9]{15}$";

        if (card.matches(visaRegex)) {
            System.out.println("this is a Valid Visa card");
        } 
        else if (card.matches(mstrRegex)) {
            System.out.println("this is a Valid MasterCard");
        } 
        else {
            System.out.println("this is a Invalid card number");
        }

        sc.close();
    }
}