class BankAccount {

    // account details
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // constructor
    BankAccount(String name, String number, double balance) {
        this.accountHolder = name;
        this.accountNumber = number;
        this.balance = balance;
    }

    // deposit money
    void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("invalid deposit amount");
        }
    }

    // withdraw money
    void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdraw amount: " + amount);
        } else {
            System.out.println("insufficient balance or wrong amount");
        }
    }

    // showing balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
//  main method
    public static void main(String[] args) {
        // creating bank account object
        BankAccount acc =
                new BankAccount("Lynda", "123456789", 700);
        // displaying initial balance
        acc.displayBalance();
        acc.deposit(200);
        acc.withdraw(100);
        acc.displayBalance();
    }
}