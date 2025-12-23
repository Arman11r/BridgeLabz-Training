class BankAccount {

    // public account number
    public String accountNumber;

    // protected holder name
    protected String accountHolder;

    // private balance
    private double balance;

    // setting balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // getting balance
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    // accessing allowed members
    void display() {
        System.out.println(accountNumber + " " + accountHolder);
    }
}