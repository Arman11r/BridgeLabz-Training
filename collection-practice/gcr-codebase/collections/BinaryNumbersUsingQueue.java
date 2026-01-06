import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersUsingQueue {

    public static void generateBinaryNumbers(int n){

        Queue<String> queue = new LinkedList<> ();

        // start with "1"
        queue.add("1");

        for (int i = 1; i <= n; i++) {

            // remove front element
            String current = queue.remove();

            // print it
            System.out.print(current + " ");

            // add next two binary numbers
            queue.add(current + "0 ");
            queue.add(current + "1 " );
        }
    }

    public static void main(String[] args) {

        int n = 5 ;
        System.out.print(" First " + n + "Binary Numbers: ");
        generateBinaryNumbers(n);
    }
}