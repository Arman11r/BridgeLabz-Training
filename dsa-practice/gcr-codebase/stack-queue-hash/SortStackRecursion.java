import java.util.Stack;

class SortStackRecursion {

    // method to sort stack
    public static void sortStack(Stack<Integer> stack) {

        // base case
        if (stack.isEmpty()) {
            return;
        }

        // remove top element
        int top = stack.pop();

        // sort remaining stack
        sortStack(stack);

        // insert element at right place
        insertSorted(stack, top);
    }

    // insert element in sorted order
    private static void insertSorted(Stack<Integer> stack, int value ) {

        // if stack empty or correct place
        if (stack.isEmpty() || stack.peek() <= value) 
            {
            stack.push(value);
            return;
        }

        // remove top
        int temp = stack.pop();

        // recursive call
        insertSorted(stack, value);

        // push back removed element
        stack.push(temp);
    }

    // main method
    public static void main(String[] args) 
    {

        Stack<Integer> stack = new Stack<>();
// pushing elements onto stack
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
//sortings using sort stack mathods
        sortStack(stack);

        // printing sorted stack
        System.out.println(stack);
    }
}