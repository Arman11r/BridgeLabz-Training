import java.util.*;

class StringToCharArray {

    public static char[] getCharacters(String text) {

        // creating char array of string length
        char[] chars = new char[text.length()];

        // storing chars one by one
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        // returning char array
        return chars;
    }
    // method to compare two char arrays

    public static boolean compareCharArrays(char[] a, char[] b) {
        // length check first.
        if (a.length != b.length) { 
            return false;
        }
        // comparing each char
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        //  if all chars matched
        return true;
    }

    public static void main(String[] args) {
        //scanner

        Scanner sc = new Scanner(System.in);
        // variable
        String text;

        // taking string input
        text = sc.next();
        // getting char array by both methods
        char[] manualArray = getCharacters(text);


        char[] builtInArray = text.toCharArray();
        // comparing both arrays
        boolean result = compareCharArrays(manualArray, builtInArray);

        // printing result

        System.out.println("arrays are same: " + result);
    }
}