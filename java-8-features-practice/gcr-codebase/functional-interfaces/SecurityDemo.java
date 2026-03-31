interface SensitiveData { }


class BankDetails implements SensitiveData {

    String accountNumber = "958437569287";
}


public class SecurityDemo {

    public static void main(String[] args) {

        BankDetails details = new BankDetails();

        if (details instanceof SensitiveData) {
            System.out.println("Encrypting ");
        }
    }
}