package In.House.Q219;

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

/**
给你一个整数数组nums和一个整数k，判断数组中是否存在两个不同的索引i和j，满足nums[i] == nums[j]且abs(i - j) <= k。如果存在，返回true；否则，返回false。

示例1：
输入：nums = [1, 2, 3, 1], k = 3
输出：true

示例2：
输入：nums = [1, 0, 1, 1], k = 1
输出：true

示例3：
输入：nums = [1, 2, 3, 1, 2, 3], k = 2
输出：false

提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5

*/