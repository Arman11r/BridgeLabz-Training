import java.util.*;

public class UncheckedExceptions{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("first number: ");
            int a = sc.nextInt();

            System.out.print("second number: ");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("result: " + result);

        } catch (ArithmeticException e) {
            // division by zero
            System.out.println("cannot divide by zero");

        } catch (InputMismatchException e) {
            // wrong input 
            System.out.println("please enter numbers :  ");

        } finally {
            sc.close(); //will run
        }
    }
}