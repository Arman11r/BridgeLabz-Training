import java.lang.reflect.Field;
import java.util.*;

class Profile {
    String username;
    int score;
}

public class objmap {

    public static <X> X buildObject(Class<X> type, Map<String, Object> values) {

        try {
            X obj = type.getDeclaredConstructor().newInstance();

            for (String key  : values.keySet())
             {

                Field f = type.getDeclaredField( key);

                f.setAccessible(true);

                f.set(obj,  values.get(key));
            }

            return obj;

        } 
        catch (Exception e)
         {

            System.out.println("faild");
            return null;
        }
    }

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("username", "arman");
        data.put("score", 99);

        Profile p = buildObject(Profile.class, data);

        System.out.println(p.username);

        
        System.out.println(p.score);
    }
}