import java.util.Scanner;

public class FlipKey {

    public static String CleanseAndInvert(String input) {

        if (input == null || input.length() < 6) {
            return "";
        }

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (!Character.isLetter(c)) {
                return "";
            }
        }

        input = input.toLowerCase();

        
        String filtered = "";

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            int code = (int) c;

            if (code % 2 != 0) {
                filtered = filtered + c;
            }
        }

       
       
        String reversed = "";

        for (int i = filtered.length() - 1; i >= 0; i--) {
            reversed = reversed + filtered.charAt(i);
        }

        String finalKey = "";

        for (int i = 0; i < reversed.length(); i++) {

            char c = reversed.charAt(i);

            if (i % 2 == 0) {
                finalKey = finalKey + Character.toUpperCase(c);
            } else {
                finalKey = finalKey + c;
            }
        }

        return finalKey;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word for FlipKey: ");

        String userInput = sc.nextLine();

        String answer = CleanseAndInvert(userInput);

        if (answer.length() == 0) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Generated Key: " + answer);
        }

        sc.close();
    }
}