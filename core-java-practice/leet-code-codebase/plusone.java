class Solution {
    public int[] plusOne(int[] digits) {

        // Traverse the array from the last digit to the first
        for (int i = digits.length - 1; i >= 0; i--) {

            // If the current digit is less than 9,
            // simply add 1 and return the result
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, it becomes 0 after adding 1
            // and carry moves to the next digit
            digits[i] = 0;
        }

        /*
         If all digits were 9 (e.g., 999),
         we need an extra digit at the beginning.
         Example: 999 + 1 = 1000
        */
        digits = new int[digits.length + 1];
        digits[0] = 1;

        // Return the new array representing the result
        return digits;
    }
}

