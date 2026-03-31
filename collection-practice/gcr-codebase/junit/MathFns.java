import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathFns{

    public int divide(int a, int b) {
        if (b==0) {
            throw new ArithmeticException("Divide by 0");
        }
        return a/b;
    }

    // ---------- Test Case ----------
    @Test
    void testException() {
        assertThrows(ArithmeticException.class, ()->divide(5, 0));
    }
}