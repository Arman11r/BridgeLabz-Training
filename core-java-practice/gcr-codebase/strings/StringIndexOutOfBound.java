import java.util.Scanner;

class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {

        // accessing invalid index
        text.charAt(text.length());
    }
    // method to handle exception created here for the question
    public static void handleException(String text) {
        // try catch block here
        try {
            text.charAt(text.length());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }

    public static void main(String[] args) {
        // creating scanner object
        Scanner sc = new Scanner(System.in);
        //variable
        String text;

        // taking input
        text = sc.next();

        // this will crash if applied here
        // generateException(text);

        // handling exception
        handleException(text);
    }
}