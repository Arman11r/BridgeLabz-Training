import java.util.Stack;

class QueueUsingStacks {

    // stack used for enqueue
    Stack<Integer> stack1 = new Stack<>();

    // stack used for dequeue
    Stack<Integer> stack2 = new Stack<>();

    // add element in queue
    public void enqueue(int value) {

        // simply push into stack1
        stack1.push(value);
    }

    // remove element from queue
    public int dequeue() {

        // if both stacks empty
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        // move elements only if stack2 empty
        if (stack2.isEmpty()) {

            // transfering elements
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()) ;
            }
        }

        // pop from stack2
        return stack2.pop();
    }

    // main method
    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();
//enteroig in queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
// dequeue elements from the queue at the end 
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}