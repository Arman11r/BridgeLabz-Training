import java.lang.reflect.Method;
import java.util.Scanner;

class CalC{

    public int sum(int fir, int sec) {
        return fir+sec ;
    }

    public int diff(int fir, int sec) {
        return fir-sec;
    }

    public int mul(int fir, int sec) {
        return fir*sec;
    }
}

public class DynamicInvoker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        CalC engine = new CalC();


        System.out.print("entermethod: ");
        String methodName = sc.nextLine();

        try {
            Method m = CalC.class.getMethod(methodName,int.class,int.class);
            Object result = m.invoke(engine, 10,5);
            System.out.println("result  : " +result);

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}