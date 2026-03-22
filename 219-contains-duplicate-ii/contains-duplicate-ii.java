import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store the value and its last seen index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (map.containsKey(currentNum)) {
                // Check if the current index minus the previous index is at most k
                if (i - map.get(currentNum) <= k) {
                    return true; // Found a duplicate within the distance k
                }
            }
            // Update the map with the current number and its index
            map.put(currentNum, i);
        }

        return false; // No duplicate found within the distance k
    }
}
