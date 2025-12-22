import java.util.Scanner;

class FrequencyUsingUnique {

    static char[] uniqueChars(String text) {

        char[] temp = new char[text.length()];
        int index = 0;


        for (int i = 0; i < text.length(); i++) {
            // flag for uniqueness/
            boolean found = false;
            // comparing with previous characters
            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    found = true;
                    break;      // not unique
                }

            }
                // if unique, store in temp
            if (!found) {
                temp[index++] = text.charAt(i);
            }
        }

        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    static String[][] frequencyWithUnique(String text) {

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        

        char[] unique = uniqueChars(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {


            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        // scanner for input
        Scanner sc = new Scanner(System.in);
        // variable
        String text = sc.nextLine();
            /// getting frequency using unique characters
        String[][] result = frequencyWithUnique(text);
        //  printing result
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " : " + result[i][1]);
        }
    }
}