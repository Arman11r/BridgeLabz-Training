import java.util.Scanner;

class SplitTextCompare {

    // method to find length
    static int findLength(String text) {

        int count = 0;

        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }

        return count;
    }

    // method to split text manually
    static String[] manualSplit(String text) {

        int length = findLength(text);
        int wordCount = 1;

        // counting words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndex = new int[wordCount - 1];
        int index = 0;

        // storing space indexes
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;

        // extracting words
        for (int i = 0; i < wordCount - 1; i++) {

            String word = "";
            for (int j = start; j < spaceIndex[i]; j++) {
                word = word + text.charAt(j);
            }

            words[i] = word;
            start = spaceIndex[i] + 1;
        }

        // last word
        String lastWord = "";
       
        for (int i = start; i < length; i++) 
            {
                // building last word
            lastWord = lastWord + text.charAt(i);
        }

        words[wordCount - 1] = lastWord;

        return words;
    }

    // method to compare arrays
    static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {

            if (!a[i].equals(b[i])) {
                return false;
            }
        }
            // if all words matched
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text;

        // taking text input
        text = sc.nextLine();
        // manual split

        String[] manual = manualSplit(text);
        // using built-in split
        String[] builtIn = text.split(" ");
        // comparing both arrays
        boolean result = compareArrays(manual, builtIn);
        // printing result
        System.out.println("manual and split are same: " + result);
    }
}