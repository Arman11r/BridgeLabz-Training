class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Assume the first string is the longest possible common prefix initially
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {

            // Reduce the prefix until the current string starts with it
            while (!strs[i].startsWith(prefix)) {

                // Remove the last character from the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty())
                    return "";
            }
        }

        // Return the longest common prefix found
        return prefix;
    }
}
