import java.util.Scanner;

class StringLengthWithoutLength {

    // method for finding length without length()
    static int findLength(String text) {
        // counter variable
        int count = 0;

        // infinite loop till exception
        while (true) {
            
            try {
                text.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        // returning count

        return count;
    }

    public static void main(String[] args) {



        // scanner for input
        Scanner sc = new Scanner(System.in);
        // variable
        String text;
        int manualLength;

        int builtInLength;

        // taking input
        text = sc.next();

        manualLength = findLength(text);
        builtInLength = text.length();

        // printing both result
        System.out.println("manual length: " + manualLength);

        System.out.println("built in length: " + builtInLength);

    }
}