import java.lang.annotation.*;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class AppUser {

    // username should not cross given length
    @MaxLength(10)
    private String username;

    // constructor checks length using reflection
    public AppUser(String username) {

        try {
            Field f = this.getClass().getDeclaredField("username");
            MaxLength rule = f.getAnnotation(MaxLength.class);

            // checking rule exists or not
            if (rule != null && username.length() > rule.value()) {
                throw new IllegalArgumentException(
                    "username length exceeded max limit: " + rule.value()
                );
            }

            this.username = username;

        } catch (NoSuchFieldException e) {
            // this should not happen normally
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}


public class MaxLengthValidatorDemo {

    public static void main(String[] args) {

        // valid username
        AppUser u1 = new AppUser("arman1234");
        System.out.println("user created: " + u1.getUsername());

        // invalid username (too long)
        AppUser u2 = new AppUser("this is too longggg");
        System.out.println("user created: " + u2.getUsername());
    }
}