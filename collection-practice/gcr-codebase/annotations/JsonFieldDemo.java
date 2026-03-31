import java.lang.annotation.*;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}


class UserProfile {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_city")
    private String city;

    public UserProfile(String username, int age, String city) {
        this.username = username;
        this.age = age;
        this.city = city;
    }
}


class JsonSerializer {

    public static String convertToJson(Object obj) throws Exception {

        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                if (!first) {
                    json.append(", ");
                }

                field.setAccessible(true);

                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                Object value = field.get(obj);

                json.append("\"").append(key).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }
}

/*
  test class
*/
public class JsonFieldDemo {

    public static void main(String[] args) throws Exception {

        UserProfile user = new UserProfile(
                "arman ahmed",
                23,
                "Mathura"
        );

        String jsonOutput = JsonSerializer.convertToJson(user);

        System.out.println(jsonOutput);
    }
}