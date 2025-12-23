import java.util.Scanner;

class PalindromeChecker {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // checking palindrome
        if (isPalindrome(text)) {
            System.out.println("Palindrome ");
        } else {
            System.out.println("Not a  Palindrome");
        }

        sc.close();
    }

    // method to check palindrome
    static boolean isPalindrome(String text) {

        String reversedText = "";

        // reversing string using loop
        for (int i = text.length() - 1; i >= 0; i--) 
            {
            reversedText = reversedText + text.charAt(i);
        }

        // comparing original and reversed string
        if (text.equalsIgnoreCase(reversedText)) 
            
            {
            return true;
        } else {
            return false;
        }
    }
}