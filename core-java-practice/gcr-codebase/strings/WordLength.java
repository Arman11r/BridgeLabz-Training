import java.util.Scanner;

class WordLength {
    // method to find length

    static int findLength(String text) {



        int count = 0;
        // counting characters
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

    static String[] manualSplit(String text) {
        // finding length
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
        String temp = "";


        for (int i = 0; i < length; i++) {
            // building word
            if (text.charAt(i) != ' ') {
                temp = temp + text.charAt(i);
            } else {

                result[index++] = temp;
                temp = "";
            }
        }// last word

        result[index] = temp;
        return result;
    }
    // method to create word length table
    static String[][] wordLengthTable(String[] words) {

        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            // filling table
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }

        return table;
    }

    public static void main(String[] args) {
        // scanner for input

        Scanner sc = new Scanner(System.in);

        // variable
        String text = sc.nextLine();
        
        String[] words = manualSplit(text);
        String[][] table = wordLengthTable(words);


        // printing table
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t  " + Integer.parseInt(table[i][1])); //ouptut
        }
    }
}