import java.util.Scanner;

class PalindromeCheck {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);
        // taking string input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String reversedText = "";

        // reversing the string using loop
        for (int i = text.length() - 1; i >= 0; i--)
            {


            reversedText = reversedText + text.charAt(i);
        }


        // checking palindrome ignoring case
        if (text.equalsIgnoreCase(reversedText)) {
            System.out.println("Palindrome ");
        } else {
            System.out.println("Not a palindrome ");
        }
        // closing scanner object
        sc.close();
    }
}