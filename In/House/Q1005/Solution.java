package In.House.Q1005;

import java.util.Arrays;

public class Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int idx = 0, len = nums.length;
        while (idx < len) {
            if (nums[idx] < 0 && k > 0) {
                nums[idx] = -nums[idx];
                --k;
                ++idx;
                continue;
            }
            break;
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.largestSumAfterKNegations(new int[] {4, 2, 3}, 1)); // 5
        System.out.println(slt.largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3)); // 6
        System.out.println(slt.largestSumAfterKNegations(new int[] {2, -3, -1, 5, -4}, 2)); // 13
        System.out.println(slt.largestSumAfterKNegations(new int[] {-2, 5, 0, 2, -2}, 3)); // 11
    }

}

/**
Link: https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/

给你一个整数数组nums和一个整数k，按以下方法修改该数组：
选择某个下标i并将nums[i]替换为-nums[i]。
重复这个过程恰好k次。可以多次选择同一个下标i。
以这种方式修改数组后，返回数组可能的最大和。

示例1：
输入：nums = [4, 2, 3], k = 1
输出：5
解释：选择下标1，nums变为[4, -2, 3]。

示例2：
输入：nums = [3, -1, 0, 2], k = 3
输出：6
解释：选择下标(1, 2, 2)，nums变为[3, 1, 0, 2]。

示例3：
输入：nums = [2, -3, -1, 5, -4], k = 2
输出：13
解释：选择下标(1, 4)，nums变为[2, 3, -1, 5, 4]。

提示：
1 <= nums.length <= 10^4
-100 <= nums[i] <= 100
1 <= k <= 10^4

*/