package In.House.Q525;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLengthV1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int counter = 0;
        int max = 0;
        for (int i = 0; i < len; ++i) {
            counter += nums[i];
            if (m.containsKey(counter)) {
                int l = i - m.get(counter);
                max = max < l ? l : max;
            } else {
                m.put(counter, i);
            }
        }
        return max;
    }

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; ++i) {
            nums[i] = nums[i] > 0 ? 1 : -1;
        }
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        m.put(nums[0], 0);
        for (int i = 1; i < len; ++i) {
            nums[i] += nums[i - 1];
            if (m.containsKey(nums[i])) {
                int dis = i - m.get(nums[i]);
                max = max < dis ? dis : max;
            }
            m.putIfAbsent(nums[i], i);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findMaxLength(new int[]{0, 1})); // 2
        System.out.println(slt.findMaxLength(new int[]{0, 1, 0})); // 2
        System.out.println(slt.findMaxLength(new int[]{0, 0, 0, 1, 1, 1, 0})); // 6
        System.out.println(slt.findMaxLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // 0
    }

}


/**
Ques: 连续数组
Link: https://leetcode-cn.com/problems/contiguous-array/

给定一个二进制数组nums, 找到含有相同数量的0和1的最长连续子数组，并返回该子数组的长度。

示例1:
输入: nums = [0, 1]
输出: 2
说明: [0, 1]是具有相同数量0和1的最长连续子数组。

示例2:
输入: nums = [0, 1, 0]
输出: 2
说明: [0, 1](或[1, 0])是具有相同数量0和1的最长连续子数组。

提示：
1 <= nums.length <= 10^5
nums[i] 不是0就是1

*/