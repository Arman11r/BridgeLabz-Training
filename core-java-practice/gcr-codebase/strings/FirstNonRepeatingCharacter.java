import java.util.Scanner;

class FirstNonRepeatingChar {
    // method to find first non repeating character
    static char findFirstNonRepeat(String text) {

        int[] freq = new int[256];

        // counting frequency
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // finding first non repeat
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        // if no non repeating char
        return '\0';
    }

    public static void main(String[] args) {
        // scanner for input
        Scanner sc = new Scanner(System.in);
        // variable
        String text = sc.nextLine();
        // finding first non repeating character
        char result = findFirstNonRepeat(text);
        // printing result
        if (result != '\0') {
            System.out.println("First non repeating char: " + result);
        } else {    // if no non repeating char
            System.out.println("No non repeating character");
        }
    }
}