public class ReverseStringUsingStringBuilder {

    public static void main(String[] args) {



        // Create StringBuilder object
        StringBuilder sb = new StringBuilder("hello arman");

        // Reverse the string
        sb.reverse();

        // Convert back to String
        String result = sb.toString();

        System.out.println("Reversed String: " + result);
    }
}