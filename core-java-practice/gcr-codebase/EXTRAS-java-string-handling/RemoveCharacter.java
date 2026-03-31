import java.util.Scanner;

class RemoveCharacter {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");

        
        String text = sc.nextLine();

        System.out.print("Enter character to remove: ");
        char removeChar = sc.next().charAt(0);

        String result = "";

        // checking each character of string
        for (int i = 0; i < text.length(); i++) {


            char currentChar = text.charAt(i);


            // if char is not same then add
            if (currentChar != removeChar) {
                result = result + currentChar;
            }

        }



        // printing modified string
        System.out.println("Modified String: " + result);

        sc.close();
    }
}