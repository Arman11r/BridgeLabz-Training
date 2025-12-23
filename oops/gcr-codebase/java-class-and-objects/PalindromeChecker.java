
class PalindromeChecker {

    // storing text
    private String text;

    // constructor
    PalindromeChecker(String text) {
        this.text = text;
    }

    // checking palindrome
    boolean isPalindrome() {

        String cleanText =
                text.replaceAll("\\s", "").toLowerCase();

        String reverse = "";

        for (int i = cleanText.length() - 1; i >= 0; i--) {
            reverse = reverse + cleanText.charAt(i);
        }

        return cleanText.equals(reverse);
    }

    // displaying result
    void displayResult() {
//  displaying result
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not palindrome");
        }
    }

    //  main method
    public static void main(String[] args) {
// creating palindrome checker objects
        PalindromeChecker p1 =
                new PalindromeChecker("A man a plan a canal Panama");

        PalindromeChecker p2 =
                new PalindromeChecker("Hello");
// displaying results
        p1.displayResult();
        p2.displayResult();
    }
}