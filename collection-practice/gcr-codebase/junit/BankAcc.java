import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAcc{


    static class BankAccount {
        

        private double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance = balance +amount;
            }
        }
// Withdraw method to withdraw amount from account
        boolean withdraw(double amount) {
            if (amount > 0 && amount <=balance) {


                balance = balance- amount;

                return true;
            }
            return false;
        }

        double getBalance() {
            return balance;
        }
    }

   
//junit testcases for BankAccount class using marven
    @Test
    void testDeposit() {
        BankAccount acc = new BankAccount(1000);
        acc.deposit(500);
        assertEquals(1500, acc.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount acc = new BankAccount(800);
        boolean result = acc.withdraw(300);
        assertTrue(result);
        assertEquals(500, acc.getBalance());
    }

    @Test
    void testWithdrawFail() {
        BankAccount acc = new BankAccount(200);
        boolean result = acc.withdraw(500);
        assertFalse(result);
        assertEquals(200, acc.getBalance());
    }
}