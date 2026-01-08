import java.util.*;

public class MultipleCatchExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // array initialization
            int[] numbers = {10, 20, 30, 40};

            // taking index input
            System.out.print("Enter idx");
            int index = sc.nextInt();

            // accessing array element
            int value = numbers[index];

            System.out.println("Value at idx" + index + ":" + value);

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not avail.  ");
        }
        finally {
            sc.close();
        }
    }
}