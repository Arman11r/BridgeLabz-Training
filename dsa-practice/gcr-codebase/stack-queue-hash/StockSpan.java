import java.util.Stack;

class StockSpan {

    // method to calculate span
    public static int[] calculateSpan(int[] prices) {

        int[] span = new int[prices.length];

        Stack<Integer> stack = new Stack<>() ;

        // first day span always 1
        span[0] = 1;
        stack.push(0);

        // loop from second day
        for (int i = 1; i < prices.length; i++) {

            // pop smaller prices
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // calculate span
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            // push index
            stack.push(i);
        }
// return span array
        return span;
    }

    // main method
    public static void main(String[] args) {
// sample stock prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
// calculating span
        int[] result = calculateSpan(prices);

        // printing result
        for (int value : result) {

            System.out.print(value + " ");

        }
    }
}