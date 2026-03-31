import java.util.ArrayList;
import java.util.List;

// loan interface
interface Loanable {
    void applyForLoan();
    boolean calculateLoanEligibility();
}

// abstract bank account
abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    protected double balance;

    BankAccount(String accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.holderName = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    abstract double calculateInterest();
}

// savings account
class SavingsAccount extends BankAccount implements Loanable {

    SavingsAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    double calculateInterest() {
        return balance * 0.04;
    }

    public void applyForLoan() {
        System.out.println("loan applied savings");
    }

    public boolean calculateLoanEligibility() {
        return balance > 50000;
    }
}

// current account
class CurrentAccount extends BankAccount implements Loanable {

    CurrentAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    double calculateInterest() {
        return 0;
    }

    public void applyForLoan() {

        System.out.println("loan applied current account");
    }

    public boolean calculateLoanEligibility() {
        return balance > 100000;
    }
}

public class BankM {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SB01", "ram", 80000));
        accounts.add(new CurrentAccount("CA01", "arman", 120000));

        for(BankAccount acc : accounts) {
            System.out.println("interest: " + acc.calculateInterest());
        }
    }
}