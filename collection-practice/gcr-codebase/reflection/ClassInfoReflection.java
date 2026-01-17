import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfoReflection {

    public static void main (String[] args) {

        Scanner sc = new   Scanner(System.in);

        try {

            System.out.print("enter class name :   ");

            String className = sc.nextLine();

            Class<?> cls = Class.forName(className) ;

            // show fields
            System.out.println("\nfields:");
            for (Field f : cls.getDeclaredFields()) {
                System.out.println(f);
            }

            // show constructors
            System.out.println("\nconstructors:");

            for (Constructor<?> c : cls.getDeclaredConstructors ()) {
                System.out.println(c);
            }

            // show methods
            System.out.println("\nmethods:");
            for (Method m : cls.getDeclaredMethods()) {
                System.out.println(m);
            }

        } catch (Exception e) {


            System.out.println("error no class");
        }

        sc.close();
    }
}