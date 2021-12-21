package In.House.Q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
                continue;
            }
            List l = new ArrayList();
            l.add(i);
            map.put(nums[i], l);
        }
        for (int i = 0; i < len; ++i) {
            int tmp = target - nums[i];
            if (!map.containsKey(tmp)) {
                continue;
            }
            List<Integer> l = map.get(tmp);
            for (int j: l) {
                if (i != j) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private static void print(int[] arr) {
        System.out.println(">>>>> result = [" + arr[0] + ", " + arr[1] + "].");
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.twoSum(new int[] {2, 7, 11, 15}, 9)); // [0, 1]
        print(slt.twoSum(new int[] {3, 2, 4}, 6)); // [1, 2]
        print(slt.twoSum(new int[] {3, 3}, 6)); // [0, 1]
    }

}

/**
Link: https://leetcode-cn.com/problems/two-sum/

给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例1：
输入：nums = [2, 7, 11, 15], target = 9
输出：[0, 1]
解释：因为nums[0] + nums[1] == 9，返回[0, 1]。

示例2：
输入：nums = [3, 2, 4], target = 6
输出：[1, 2]

示例3：
输入：nums = [3, 3], target = 6
输出：[0, 1]

提示：
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
只会存在一个有效答案
进阶：你可以想出一个时间复杂度小于O(n^2)的算法吗？

*/