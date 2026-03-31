import java.time.LocalTime;

class BankAccount {

    private int balance = 10000;

    public synchronized boolean withdraw(String customer, int amount) {

        System.out.println( customer + "=> Trying to withdraw " + amount);

        if (balance >= amount) {
            balance -= amount;

            System.out.println("SUCCESS -> " + customer +
                    " withdrew " + amount +
                    " | Balance left: " + balance +
                    " | Time: " + LocalTime.now());

            return true;
        } else {
            System.out.println("FAILED -> " + customer +
                    " insufficient balance | Time: " + LocalTime.now());
            return false;
        }
    }
}

class Transaction implements Runnable {

    private BankAccount account;
    private String customerName;
    private int amount;

    public Transaction(BankAccount acc, String name, int amt) {
        account = acc;
        customerName = name;
        amount = amt;
    }

    public void run() {
        account.withdraw(customerName, amount);
    }
}

public class BankingSystem {

    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000));
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000));
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000));


        System.out.println("Thread states before start:");
        System.out.println(t1.getState());

        t1.start();
        t2.start();
        t3.start();
  

        t1.join(); t2.join(); t3.join();

        System.out.println("All transactions completed.");
    }
}