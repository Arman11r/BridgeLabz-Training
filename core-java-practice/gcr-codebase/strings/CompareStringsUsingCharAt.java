import java.util.Scanner;

class CompareStringsUsingCompareCharAt {

    public static boolean compareUsingCharAt(String first, String second) {


        // length check first if correct
        if (first.length() != second.length()) {
            return false;
        }

        // checking each character here
        for (int i = 0; i < first.length(); i++) {


            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        //if all chars matched

        return true;
    }

    public static void main(String[] args) {

        // scanner for input
        Scanner sc = new Scanner(System.in);
        //variable
        String firstString;
        String secondString;

        // taking input
        firstString = sc.next();
        secondString = sc.next();
        

        //here in boolean storing results
        boolean charAtResult = compareUsingCharAt(firstString, secondString);
        boolean equalsResult = firstString.equals(secondString);

        // printing result here syso
        System.out.println("charAt compare result : " + charAtResult);

        System.out.println("equals method result:  " + equalsResult);
    }
}