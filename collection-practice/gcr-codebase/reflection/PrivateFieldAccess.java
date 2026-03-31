import java.lang.reflect.Field;

class code {
    private int years;
}

public class PrivateFieldAccess {

    public static void main(String[] args) {

        try {
            code h = new code();

            Field field = code.class.getDeclaredField("year");
            field.setAccessible(true);  

            field.set(h, 25);

            int value = (int) field.get(h);
            System.out.println("age is: " + value);

        } catch (Exception e) {
            System.out.println("error ");
        }
    }
}