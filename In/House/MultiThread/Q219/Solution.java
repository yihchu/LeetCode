package In.House.MultiThread.Q219;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3)); // true
        System.out.println(slt.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1)); // true
        System.out.println(slt.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2)); // false
    }

}