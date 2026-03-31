import java.util.Arrays;
import java.util.Scanner;

class AnagramCheck {

    public static void main(String[] args) {

        // scanner for user input
        Scanner sc = new Scanner(System.in);

        // taking first string
        System.out.print("Enter first string: ");
        String firstText = sc.nextLine();

        // taking second string
        System.out.print("Enter second string: ");
        String secondText = sc.nextLine();

        // removing spaces and converting to lowercase


        firstText = firstText.replaceAll("\\s", "").toLowerCase();


        secondText = secondText.replaceAll("\\s", "").toLowerCase();

        // checking anagram condition
        boolean result = checkAnagram(firstText, secondText);


        // printing final resultss
        if (result) {
            System.out.println("Strings are anagrams");
        } else {
            
            System.out.println("Strings are not anagrams");
        }

        sc.close();
    }

    // method to check whether strings are anagram
    static boolean checkAnagram(String first, String second) {

        // if length not same then not anagram
        if (first.length() != second.length()) {
            return false;
        }

        // converting string to char array
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();

        // sorting both arrays
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        // comparing sorted arrays
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return false;
            }
        }

        return true;
    }
}