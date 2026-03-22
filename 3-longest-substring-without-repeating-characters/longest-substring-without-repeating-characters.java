import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Map to store the last index of each character
        Map<Character, Integer> charMap = new HashMap<>();
        // Left pointer of the sliding window
        int left = 0;

        // Iterate through the string with the right pointer
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and its last index is within the current window (>= left)
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                // Move the left pointer to the position after the last occurrence of the repeating character
                left = charMap.get(currentChar) + 1;
            }

            // Update the character's last seen position in the map
            charMap.put(currentChar, right);

            // Update the maximum length of the substring found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
