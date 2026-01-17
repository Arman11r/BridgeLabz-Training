import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface 
writer {
    String value();
}

@writer("Arman Ahmed OG")
class BookInfo {
}

public class AnnotationReader {

    public static void main(String[] args) {

        Class<BookInfo> claas = BookInfo.class;


        if (claas.isAnnotationPresent(writer.class)) 
        {
            writer w = claas.getAnnotation(writer.class);
            
            System.out.println("author:" + w.value());
        }
    }
}