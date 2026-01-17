import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/*
  this annotation is used to mark pending work
*/
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {

    // task description
    String task();

    // who is responsible
    String assignedTo();

    // priority with default value
    String priority() default "MEDIUM";
}


class FeatureTracker {

    @Todo(
        task = "add login validation",
        assignedTo = "arman",
        priority = "HIGH"
    )
    public void loginFeature() {
    }

    @Todo(
        task = "optimize search logic",
        assignedTo = "rohan"
    )
    public void searchFeature() {
    }

    @Todo(
        task = "add payment gateway",
        assignedTo = "danish",
        priority = "LOW"
    )
    public void paymentFeature() {
    }
}

/*
  main class to read annotation data
*/
public class TodoAnnotationReader {

    public static void main(String[] args) {

        Class<FeatureTracker> cls = FeatureTracker.class;

        System.out.println("pending tasks list:\n");

        // loop through all methods
        for (Method m : cls.getDeclaredMethods()) {

            // check if method has Todo annotation
            if (m.isAnnotationPresent(Todo.class)) {

                Todo t = m.getAnnotation(Todo.class);

                System.out.println("method name : " + m.getName());
                System.out.println("task        : " + t.task());
                System.out.println("assigned to : " + t.assignedTo());
                System.out.println("priority    : " + t.priority());
                System.out.println("--------------------------------");
            }
        }
    }
}