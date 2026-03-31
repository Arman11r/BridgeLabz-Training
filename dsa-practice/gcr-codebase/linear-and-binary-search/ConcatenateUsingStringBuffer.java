public class ConcatenateUsingStringBuffer {

    public static void main(String[] args) {

        String[] words = {"Java", " ", "is", " ", "powerful"};

        // Create StringBuffer object to help witht the questins
        StringBuffer buffer = new StringBuffer();

        // Append each string using the for loop on the buffer
        for (String word : words) {
            buffer.append(word);
        }

        // Final concatenated strings here done
        String result = buffer.toString();

        System.out.println("Concatenated String: " + result);
    }
}