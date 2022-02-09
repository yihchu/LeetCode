package In.House.Q2006;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int key: map.keySet()) {
            if (!map.containsKey(key + k)) {
                continue;
            }
            sum += map.get(key) * map.get(key + k);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countKDifference(new int[] {1, 2, 2, 1}, 1)); // 4
        System.out.println(slt.countKDifference(new int[] {1, 3}, 3)); // 0
        System.out.println(slt.countKDifference(new int[] {3, 2, 1, 5, 4}, 2)); // 3
        System.out.println(slt.countKDifference(new int[] {10, 2, 10, 9, 1, 6, 8, 9, 2, 8}, 5)); // 1
    }
}

/**
Ques: 差的绝对值为 K 的数对数目
Link: https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/

给你一个整数数组nums和一个整数k，请你返回数对(i, j)的数目，满足i < j且|nums[i] - nums[j]| == k。
|x|的值定义为：
如果x >= 0，那么值为x。
如果x < 0，那么值为-x。

示例1：
输入：nums = [1, 2, 2, 1], k = 1
输出：4
解释：差的绝对值为1的数对为：
- [[1], [2], 2, 1]
- [[1], 2, [2], 1]
- [1, [2], 2, [1]]
- [1, 2, [2], [1]]

示例2：
输入：nums = [1, 3], k = 3
输出：0
解释：没有任何数对差的绝对值为3。

示例3：
输入：nums = [3, 2, 1, 5, 4], k = 2
输出：3
解释：差的绝对值为2的数对为：
- [[3], 2, [1], 5, 4]
- [[3], 2, 1, [5], 4]
- [3, [2], 1, 5, [4]]

提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
*/
