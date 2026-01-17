import java.lang.reflect.Field;

class employinfo {
    String name = "Arman Ahmed";
    int salary = 48000;
}

public class JsonStylePrinter {

    public static String convertToJson(Object obj) {

        StringBuilder sb = new StringBuilder("{ ");

        try {
            Field[] fields = obj.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length;  i++ ) 
            {
                fields[i].setAccessible(true);

                sb.append("\"")

                  .append(fields[i].getName())
                  .append("\":\"")

                  .append(fields[i].get(obj))

                  .append("\"");

                if (i < fields.length - 1) {
                    sb.append(", ");
                }
            }

        } catch (Exception e) {
            System.out.println("json error");
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {

       employinfo e = new employinfo();
        System.out.println(convertToJson(e));
    }
}