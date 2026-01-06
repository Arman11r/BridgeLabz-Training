import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    // method to reverse queue using recursion
    public static void reverseQueue (Queue<Integer> queue ){

        // base case: if queue is empty, stop

        if (queue.isEmpty()) {
            return;
        }

        // remove front element
        int front = queue.remove();

        // reverse remaining queue
        reverseQueue(queue);

        // add removed element at the end
        queue.add(front);
    }

    public static void main(String[] args){

        Queue<Integer> queue = new LinkedList<>();

        // adding elements



        queue.add(10) ;
        queue.add(20);
        queue.add(30) ;

        System.out.println("Original Queue. : " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue. : " + queue);
    }
}