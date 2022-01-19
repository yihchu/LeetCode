package In.House.Q334;

public class Solution {

//    public boolean increasingTriplet(int[] nums) {
//        int len = nums.length;
//        if (len < 3) {
//            return false;
//        }
//        int[] left = new int[len];
//        left[0] = nums[0];
//        for (int i = 1; i < len; ++i) {
//            left[i] = Math.min(left[i - 1], nums[i]);
//        }
//        int[] right = new int[len];
//        right[len - 1] = nums[len - 1];
//        for (int i = len - 2; i >= 0; --i) {
//            right[i] = Math.max(right[i + 1], nums[i]);
//        }
//        for (int i = 1; i < len - 1; ++i) {
//            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int a = nums[0], b = Integer.MAX_VALUE;
        for (int i = 1; i < len; ++i) {
            int c = nums[i];
            if (c > b) {
                return true;
            } else if (c > a) {
                b = c;
            } else {
                a = c;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.increasingTriplet(new int[] {1, 2, 3, 4, 5})); // true
        System.out.println(slt.increasingTriplet(new int[] {5, 4, 3, 2, 1})); // false
        System.out.println(slt.increasingTriplet(new int[] {2, 1, 5, 0, 4, 6})); // true
    }

}

/**
Ques: 递增的三元子序列
Link: https://leetcode-cn.com/problems/increasing-triplet-subsequence/

给你一个整数数组nums，判断这个数组中是否存在长度为3的递增子序列。
如果存在这样的三元组下标(i, j, k)且满足i < j < k，使得nums[i] < nums[j] < nums[k]，返回true；否则，返回false。

示例1：
输入：nums = [1, 2, 3, 4, 5]
输出：true
解释：任何i < j < k的三元组都满足题意

示例2：
输入：nums = [5, 4, 3, 2, 1]
输出：false
解释：不存在满足题意的三元组

示例3：
输入：nums = [2, 1, 5, 0, 4, 6]
输出：true
解释：三元组(3, 4, 5)满足题意，因为nums[3] == 0 < nums[4] == 4 < nums[5] == 6

提示：
1 <= nums.length <= 5 * 10^5
-2^31 <= nums[i] <= 2^31 - 1

进阶：你能实现时间复杂度为O(n)，空间复杂度为O(1)的解决方案吗？

*/