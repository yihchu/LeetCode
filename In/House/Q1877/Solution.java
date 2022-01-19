package In.House.Q1877;

import java.util.Arrays;

public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = -1, len = nums.length;
        for (int i = 0; i < len / 2; i ++) {
            int sum = nums[i] + nums[len - 1 - i];
            max = sum > max ? sum : max;
            System.out.println("(" + nums[i] + "， " + nums[len - 1 - i] + ")");
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minPairSum(new int[]{3, 5, 2, 3})); // 7
        System.out.println(slt.minPairSum(new int[]{3, 5, 4, 2, 4, 6})); // 8
    }

}

/**
Ques: 数组中最大数对和的最小值
Link: https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/

一个数对(a, b)的数对和等于a + b。最大数对和是一个数对数组中最大的数对和。

比方说，如果我们有数对(1, 5)，(2, 3)和(4, 4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。
给你一个长度为偶数n的数组nums，请你将nums中的元素分成n/2个数对，使得：

nums中每个元素恰好在一个数对中，且最大数对和的值最小。
请你在最优数对划分的方案下，返回最小的最大数对和。

示例1：
输入：nums = [3, 5, 2, 3]
输出：7
解释：数组中的元素可以分为数对(3, 3)和(5, 2)。
最大数对和为max(3 + 3, 5 + 2) = max(6, 7) = 7 。

示例2：
输入：nums = [3, 5, 4, 2, 4, 6]
输出：8
解释：数组中的元素可以分为数对(3, 5)，(4, 4)和(6, 2) 。
最大数对和为max(3 + 5, 4 + 4, 6 + 2) = max(8, 8, 8) = 8 。

提示：
n == nums.length
2 <= n <= 10^5 n是偶数。
1 <= nums[i] <= 10^5

*/