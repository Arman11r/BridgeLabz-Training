interface SecurityUtils {

    static boolean isStrong(String password) {

        if (password.length() < 8) return false;

        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasDigit;
    }
}

public class PasswordTest {

    public static void main(String[] args) {

        boolean result = SecurityUtils.isStrong("arman213123");

        System.out.println(result);
    }
}