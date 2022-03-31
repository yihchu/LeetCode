package In.House.Q523;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        m.putIfAbsent(nums[0] % k, 0);
        for (int i = 1; i < len; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 1; i < len; ++i) {
            int mod = nums[i] % k;
            if (m.containsKey(mod)) {
                if (i - m.get(mod) > 1) {
                    return true;
                }
            }
            m.putIfAbsent(mod, i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(slt.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
        System.out.println(slt.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)); // false
        System.out.println(slt.checkSubarraySum(new int[]{1, 0}, 2)); // false
        System.out.println(slt.checkSubarraySum(new int[]{5, 0, 0, 0, 0}, 3)); // true
        System.out.println(slt.checkSubarraySum(new int[]{1, 2, 3}, 5)); // true
        System.out.println(slt.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7)); // true
        System.out.println(slt.checkSubarraySum(new int[]{0, 0}, 1)); // true
    }
}
