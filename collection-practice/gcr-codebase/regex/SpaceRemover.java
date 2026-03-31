import java.util.Scanner;

public class SpaceRemover {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input sentence
        System.out.println("Enter text here ahead:");
        String text = sc.nextLine();

        // replacing multiple spaces with single space
        String result = text.replaceAll("\\s+", " "); // \\s+ means one or more whitespace characters

        // printing result
        System.out.println(result);

        sc.close();
    }
}