package In.House.Q689;


public class Solution {

//    // 考虑的不对，带重叠了
//    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        int len = nums.length;
//        int[] sums = new int[len - k + 1];
//        int[] tres = new int[3];
//        for (int i = 0; i < sums.length; ++i) {
//            int sum = 0;
//            for (int j = i; j < i + k; ++j) {
//                sum += nums[j];
//            }
//            sums[i] = sum;
//            int curIdx = i;
//            for (int j = 0; j < 3; ++j) {
//                if (sum > sums[tres[j]]) {
//                    int tmp = tres[j];
//                    sum = sums[tmp];
//                    tres[j] = curIdx;
//                    curIdx = tmp;
//                }
//            }
//        }
//        Arrays.sort(tres);
//        return tres;
//    }

    // 官方答案，滑动窗口，照抄
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
        int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
        int sum3 = 0, maxTotal = 0;
        int len = nums.length;
        for (int i = k * 2; i < len; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i < k * 3 - 1) {
                continue;
            }
            if (sum1 > maxSum1) {
                maxSum1 = sum1;
                maxSum1Idx = i - k * 3 + 1;
            }
            if (maxSum1 + sum2 > maxSum12) {
                maxSum12 = maxSum1 + sum2;
                maxSum12Idx1 = maxSum1Idx;
                maxSum12Idx2 = i - k * 2 + 1;
            }
            if (maxSum12 + sum3 > maxTotal) {
                maxTotal = maxSum12 + sum3;
                result[0] = maxSum12Idx1;
                result[1] = maxSum12Idx2;
                result[2] = i - k + 1;
            }
            sum1 -= nums[i - k * 3 + 1];
            sum2 -= nums[i - k * 2 + 1];
            sum3 -= nums[i - k + 1];
        }
        return result;
    }

    private static void test(int[] array, int k) {
        Solution slt = new Solution();
        int[] result = slt.maxSumOfThreeSubarrays(array, k);
        for (int r: result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 1, 2, 6, 7, 5, 1}, 2); // [0, 3, 5]
        test(new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1}, 2); // [0, 2, 4]
    }

}

/**
Ques: 三个无重叠子数组的最大和
Link: https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

给你一个整数数组nums和一个整数k，找出三个长度为k、互不重叠、且3 * k项的和最大的子数组，并返回这三个子数组。
以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从0开始）。如果有多个结果，返回字典序最小的一个。

示例1：
输入：nums = [1, 2, 1, 2, 6, 7, 5, 1], k = 2
输出：[0, 3, 5]
解释：子数组[1, 2], [2, 6], [7, 5]对应的起始下标为[0, 3, 5]。
也可以取[2, 1], 但是结果[1, 3, 5]在字典序上更大。

示例2：
输入：nums = [1, 2, 1, 2, 1, 2, 1, 2, 1], k = 2
输出：[0, 2, 4]

提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] < 2^16
1 <= k <= floor(nums.length / 3)

*/