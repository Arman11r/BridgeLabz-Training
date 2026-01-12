import org.junit.jupiter.api.Test;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a,int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

//test case for marven junit
    @Test
    void testAdd() {
        assertEquals(10, add(6, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(2, subtract(6, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(24, multiply(6, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2, divide(8, 4));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () ->divide(10, 0));
    }
}