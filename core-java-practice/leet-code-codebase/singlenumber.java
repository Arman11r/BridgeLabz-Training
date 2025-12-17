class Solution {
    public int singleNumber(int[] nums) {

        // This variable will store the XOR result
        int result = 0;

        // Traverse through all numbers in the array
        for (int i = 0; i < nums.length; i++) {

            /*
             XOR properties used here:
             1) a ^ a = 0   → same numbers cancel each other
             2) a ^ 0 = a   → number remains unchanged
             3) XOR is commutative and associative
             
             Since every number appears twice except one,
             all duplicates cancel out, leaving the single number
            */
            result = result ^ nums[i];
        }

        // The remaining value is the number that appears only once
        return result;
    }
}
