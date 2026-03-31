import java.util.Scanner;

class VowelsAndConsonents {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // converting to lowercase so easy to compare
        text = text.toLowerCase();

        int vowelCount = 0;
        int consonantCount = 0;

        // checking each character one by one
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // checking if character is alphabet
            if (ch >= 'a' && ch <= 'z') {

                // checking vowel
                if (ch == 'a' || ch == 'e'  || ch ==  'i'  || ch == 'o' || ch == 'u') {
                    vowelCount++;

                } else {
                    consonantCount++;
                }
            }
        }

        // printing final counts
        System.out.println("Vowels: " + vowelCount);
        
        System.out.println("Consonants: " + consonantCount);

        sc.close();
    }
}