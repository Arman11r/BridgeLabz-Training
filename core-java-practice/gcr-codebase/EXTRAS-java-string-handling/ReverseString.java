import java.util.Scanner;

class ReverseString {
    // main method  .
    public static void main(String[] args) {

        // scanner for taking input

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string to reverse : ");
        String text = sc.nextLine();

        String reversedText = "";

        // looping from last character to first
        for (int i = text.length() - 1; i >= 0; i--) {

            // adding character one by one
            reversedText = reversedText + text.charAt(i);
        }


        // printing reversed string
        System.out.println("Reversed String : " + reversedText);

        sc.close();
    }
}