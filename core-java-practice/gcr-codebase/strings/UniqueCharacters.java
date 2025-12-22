import java.util.Scanner;

class UniqueCharacters {

    // finding length without length()
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


    // finding unique chars
    static char[] uniqueChars(String text) {

            // finding length
        int len = findLength(text);

        char[] temp = new char[len];
        int index = 0;
        // checking each character


        for (int i = 0; i < len; i++) {
            // flag for uniqueness
            boolean isUnique = true;
            //  comparing with previous characters
            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            // if unique, store in temp
            if (isUnique) {
                temp[index++] = text.charAt(i);
            }

        }

        // creating result array of exact size
        char[] result = new char[index];


        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        // returning result
        return result;
    }
    // main method


    public static void main(String[] args) {
        // scanner for input
        Scanner sc = new Scanner(System.in);

        // variable
        String text = sc.nextLine();
        // getting unique characters
        char[] unique = uniqueChars(text);


        // printing unique characters
        for (int i = 0; i < unique.length; i++) {
            System.out.print(unique[i] + "  ");
        }


    }

}