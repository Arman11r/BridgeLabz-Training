import java.util.Scanner;

class MostFrequentChar {

    public static void main(String[] args) {

        // scanner for taking input

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string here: ");
        String text = sc.nextLine();


        // converting text to lowercase so case dont matter
        text = text.toLowerCase();

        // array to store frequency of characters
        int[] frequency = new int[256];


        // counting each character frequency
        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);

            frequency[currentChar]++;
        }

        int maxCount = 0;

        char mostFrequent = ' ';

        // finding character with max frequency
        for (int i = 0; i < 256; i++) {

            if (frequency[i] > maxCount) {

                maxCount = frequency[i];
                mostFrequent = (char) i;

            }
        }


        // printing final result
        System.out.println("Most Frequent Character. : '" + mostFrequent + "'");

        sc.close();
    }
}