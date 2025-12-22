class NullPointer {

    public static void generateException() {

        // string is null
        String text = null;

        // this will cause exception for our demo
        text.length();
    }
    // method to handle exception
    public static void handleException() {

        // string is null
        String text = null;
        //try catch applied
        try {
            text.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        }
    }
    // main method
    public static void main(String[] args) {

        // calling method to generate exception
        generateException();
        // calling method to handle exception
        handleException();
    }
}