// base bank account
class BankAccount {

    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {

        System.out.println("general bank account.  ");
    }
}

// savings account
class SavingsAccount extends BankAccount {

    double interestRate;

    SavingsAccount(String accNo, double balance, double interestRate) {

        super(accNo, balance);
        this.interestRate = interestRate;

    }

    void displayAccountType() {

        System.out.println("savings account");
    }
}

// checking account
class CheckingAccount extends BankAccount {

    int withdrawalLimit;

    CheckingAccount(String accNo, double balance, int withdrawalLimit) {
        super(accNo, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("checking account");
    }
}

// fixed deposit
class FixedDepositAccount extends BankAccount {

    int lockPeriod;

    FixedDepositAccount(String accNo, double balance, int lockPeriod) {
        super(accNo, balance);
        this.lockPeriod = lockPeriod;
    }

    void displayAccountType() {
        System.out.println("fixed deposit account");
    }
}

public class BankD {
    public static void main(String[] args) {

        BankAccount b1 = new SavingsAccount("SBI101", 50000, 4.5);
        BankAccount b2 = new CheckingAccount("PNB102", 30000, 5);
        BankAccount b3 = new FixedDepositAccount("HDFC103", 100000, 12);

        b1.displayAccountType();
        b2.displayAccountType();
        b3.displayAccountType();
    }
}