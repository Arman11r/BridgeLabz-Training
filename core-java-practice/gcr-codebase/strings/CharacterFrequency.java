import java.util.Scanner;

class CharacterFrequency {

    static String[][] findFrequency(String text) {

        int[] freq = new int[256];

        // counting frequency
        for (int i = 0; i < text.length(); i++) {


            freq[text.charAt(i)]++; // counting frequency
        }

        int count = 0;
        for (int i = 0; i < 256; i++) {

            if (freq[i] > 0) {
                count++;
            }
        }

        
        String[][] result = new String[count][2];
        int index = 0;
        // storing characters and their frequencies
        for (int i = 0; i < 256; i++) {

            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char)i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // scanner for input
        Scanner sc = new Scanner(System.in);
        // variable
        String text = sc.nextLine();
        // getting frequency
        String[][] result = findFrequency(text);
            // printing result
        for (int i = 0; i < result.length; i++) {

            // printing character and its frequency'
            System.out.println(result[i][0] + " : " + result[i][1]);
        }
    }
}