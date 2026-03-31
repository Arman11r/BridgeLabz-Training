import java.util.Scanner;

class ShortestLongWord {

    static int findLength(String text) {
        // counting characters
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
    // method to split text manually

    static String[] manualSplit(String text) {

        int length = findLength(text);

        int words = 1;

        for (int i = 0; i < length; i++) {

            if (text.charAt(i) == ' ') {
                words++;
            }
        }
            // creating result array
        String[] result = new String[words];


        int index = 0;
        String temp = " ";

        for (int i = 0; i < length; i++) {

            if (text.charAt(i) != ' ') {
                temp = temp + text.charAt(i);
            } else {
                result[index++] = temp;

                temp = "";
            }
        }
        // last word
        result[index] = temp;
        return result;
    }
    // method to find shortest and longest word lengths
    static int[] findShortLong(String[][] table) {

        int min = Integer.parseInt(table[0][1]);
        int max = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {

            int len = Integer.parseInt(table[i][1]);


            if (len < min) min = len;
            if (len > max) max = len;
        }
        // returning result
        return new int[]{min, max};
    }
    // method to create word length table
    static String[][] wordLengthTable(String[] words) 
    {

        String[][] table = new String[words.length][2];


        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }

        return table;
    }// main method

    public static void main(String[] args) {
        /// scanner for input
        /// 
        Scanner sc = new Scanner(System.in);
        // variable

        String text = sc.nextLine();
        // splitting words
        String[] words = manualSplit(text);
        String[][] table = wordLengthTable(words);

        int[] result = findShortLong(table);
            // printing result
        System.out.println("shortest length: " + result[0]);
        System.out.println("longest length: " + result[1]);
    }
}