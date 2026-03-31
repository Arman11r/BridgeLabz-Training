import java.util.Scanner;

class VowelConsonantCount {


    static String checkChar(char ch) {

        // converting to lowercase using ascii
        if (ch >= 'A' && ch <= 'Z') {
            
            ch = (char)(ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
                {
                return "vowel";
            } else {
                return "consonant";
            }
        }

        return "notLetter";

    }
        // method to count vowel and consonan
    static int[] countVowelConsonant(String text) {
        // initializing counts

        int vowel = 0;
        // initializing consonant count
        int consonant = 0;

                // iterating through text
        for (int i = 0; i < text.length(); i++) {
            // checking each character
            String result = checkChar(text.charAt(i));
            // counting vowel
            if (result.equals("vowel")) {
                vowel++;
                // counting consonant
            } else if (result.equals("consonant")) {
                consonant++;        // counting consonant
            }
        }

        return new int[]{vowel, consonant};
    }

    public static void main(String[] args) {
        // scanner for input
        Scanner sc = new Scanner(System.in);
        // variable
        String text = sc.nextLine();
        // getting result
        int[] result = countVowelConsonant(text);
            // printing result

        System.out.println("Vowels: " + result[0]);

        System.out.println("Consonants: " + result[1]);
    }
}