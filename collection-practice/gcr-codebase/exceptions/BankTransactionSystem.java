import java.util.Scanner;

// custom checked exception
class InsufficientBalance extends Exception {

    public InsufficientBalance(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {

    // instance variable
    private double balance;

    // constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // withdraw method
    public void withdraw(double amount) throws InsufficientBalance {

        // negative amount check
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // insufficient balance check
        if (amount > balance) {
            throw new InsufficientBalance("Insufficient balance!");
        }

        // withdrawal logic
        balance = balance - amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

// main class
public class BankTransactionSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create account with initial balance
        BankAccount account = new BankAccount(16438);

        try {
            System.out.print("Enter rs to withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

        } catch (InsufficientBalance e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } finally {
            sc.close();
        }
    }
}