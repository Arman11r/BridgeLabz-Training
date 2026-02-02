import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    // 1️⃣ Deposit valid amount
    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(100);

        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    // 2️⃣ Deposit negative amount
    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(100);

        assertThrows(RuntimeException.class,
                () -> account.deposit(-10));
    }

    // 3️⃣ Withdraw valid amount
    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(200);

        account.withdraw(50);

        assertEquals(150, account.getBalance());
    }

    // 4️⃣ Withdraw insufficient funds
    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(100);

        assertThrows(RuntimeException.class,
                () -> account.withdraw(200));
    }
}