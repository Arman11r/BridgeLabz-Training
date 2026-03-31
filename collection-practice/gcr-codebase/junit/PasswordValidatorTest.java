import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    static class PasswordValidator {

        static boolean isValid(String password) {

            if (password == null || password.length() < 8) {
                return false;
            }

            boolean hasUpper = false;
            boolean hasDigit = false;



            for (char ch:password.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                }
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                }
            }

            return hasUpper && hasDigit;
        }
    }


    @Test
    void validPassword() {
        assertTrue(PasswordValidator.isValid("Hello123"));
    }

    @Test
    void invalidPasswordTooShort() {
        assertFalse(PasswordValidator.isValid("Hi1"));
    }

    @Test
    void invalidNoUppercase() {
        assertFalse(PasswordValidator.isValid("hello123"));
    }

    @Test
    void invalidNoDigit() {
        assertFalse(PasswordValidator.isValid("HelloWorld"));
    }
}