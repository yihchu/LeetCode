package In.House.Q2104;

public class Solution {

    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long result = 0;
        for (int i = 0; i < len; ++i) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < len; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += (max - min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.subArrayRanges(new int[] {1, 2, 3})); // 4
        System.out.println(slt.subArrayRanges(new int[] {1, 3, 3})); // 4
        System.out.println(slt.subArrayRanges(new int[] {4, -2, -3, 4, 1})); // 59
    }

}

/**
Ques: 子数组范围和
Link: https://leetcode-cn.com/problems/sum-of-subarray-ranges/

给你一个整数数组nums。nums中，子数组的范围是子数组中最大元素和最小元素的差值。
返回nums中所有子数组范围的和。
子数组是数组中一个连续非空的元素序列。

示例1：
输入：nums = [1, 2, 3]
输出：4
解释：nums的6个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[2]，范围 = 2 - 2 = 0
[3]，范围 = 3 - 3 = 0
[1, 2]，范围 = 2 - 1 = 1
[2, 3]，范围 = 3 - 2 = 1
[1, 2, 3]，范围 = 3 - 1 = 2
所有范围的和是0 + 0 + 0 + 1 + 1 + 2 = 4

示例2：
输入：nums = [1, 3, 3]
输出：4
解释：nums的6个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[3]，范围 = 3 - 3 = 0
[3]，范围 = 3 - 3 = 0
[1, 3]，范围 = 3 - 1 = 2
[3, 3]，范围 = 3 - 3 = 0
[1, 3, 3]，范围 = 3 - 1 = 2
所有范围的和是0 + 0 + 0 + 2 + 0 + 2 = 4

示例3：
输入：nums = [4, -2, -3, 4, 1]
输出：59
解释：nums中所有子数组范围的和是59

提示：
1 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9

进阶：你可以设计一种时间复杂度为O(n)的解决方案吗？

*/