import java.util.Scanner;

class RemoveDuplicate {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string : ");
        String text = sc.nextLine();

        String result = "";

        // looping through each character

        for (int i = 0; i < text.length(); i++)
             {

            char currentChar = text.charAt(i);

            // check if char already present in result
            if (result.indexOf(currentChar) == -1) {

                // adding only unique character
                result = result + currentChar;

            }
        }

        // printing final string
        System.out.println("String without duplicates : " + result);

        sc.close();
    }
}