class Solution {
    public int romanToInt(String s) {

        // This will store the final integer value
        int ans = 0;

        // This will store the numeric value of the current Roman character
        int num = 0;

        // Traverse the Roman string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {

            // Convert each Roman character to its corresponding integer value
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }

            /*
             Roman numeral rule:
             - If a smaller value comes before a larger value, we subtract it
             - Otherwise, we add it

             Since we are moving from right to left:
             - If 4 * current value is less than the accumulated answer,
               it means this value should be subtracted (like I in IV or IX)
             */
            if (4 * num < ans)
                ans -= num;   // Subtract the value
            else
                ans += num;   // Add the value
        }

        // Return the final converted integer
        return ans;
    }
}

