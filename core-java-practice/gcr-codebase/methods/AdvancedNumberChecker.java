class AdvancedNumberChecker {
    // Method to extract digits from a number
    static int[] reverseArray(int[] digits) {

        int[] rev = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {

            // reversing digits
            rev[i] = digits[digits.length - 1 - i];
        }

        return rev;
    }

    // Method to check if two arrays are palindromes
    static boolean isPalindrome(int[] a, int[] b) {


        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
    // Method to check if a number is prime
    static boolean isPrime(int number) {


        if (number <= 1) return false;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }


        return true;
    }
    // Method to check if a number is a Buzz number
    static boolean isBuzz(int number) {



        return number % 7 == 0 || number % 10 == 7;
    }
    
}
