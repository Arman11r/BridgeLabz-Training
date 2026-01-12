import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringFns {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

//testcase for junit
    @Test
    void testReverse() {
        assertEquals("olleh", reverse("hello"));
    }

    @Test
    void testPalindromeTrue() {
        assertTrue(isPalindrome("madam"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(isPalindrome("java"));
    }

    @Test
    void testUpperCase() {
        assertEquals("ARMAN", toUpperCase("arman"));
    }
}