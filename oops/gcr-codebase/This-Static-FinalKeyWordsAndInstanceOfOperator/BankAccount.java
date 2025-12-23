

public class BankAccount {

    // bank name same for all accounts
    private static String bankName = "State bank of India";

    // counting total accounts
    private static int totalAccounts = 0;

    // account number should not change
    private final String accountNumber;

    // account holder name
    private String accountHolderName;

    // current balance
    private double balance;

    // constructor to create account
    public BankAccount(String accountHolderName, String accountNumber, double balance) {

        // using this to avoid confusion
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;

        // increasing account count
        totalAccounts++;
    }

    // showing total accounts
    public static void getTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }

    // showing account details
    public void displayAccountDetails() {

        // checking object type before display
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    // adding money
    public void deposit(double amount) {

        // checking positive amount
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // withdrawing money
    public void withdraw(double amount) {

        // checking balance
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.err.println("Insufficient balance or invalid amount");
        }
    }

    public static void main(String[] args) {

        // creating accounts
        BankAccount account1 = new BankAccount("Lynda Princy", "ACC12345", 1000);
        BankAccount account2 = new BankAccount("Prince Danish", "ACC67890", 500);

        // displaying details
        account1.displayAccountDetails();
        account2.displayAccountDetails();

        // showing total accounts
        BankAccount.getTotalAccounts();

        // doing transactions
        account1.deposit(200);
        account1.withdraw(150);

        account2.deposit(100);
        account2.withdraw(800);
    }
}