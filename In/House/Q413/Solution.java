package In.House.Q413;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; ++i) {
            int gap = nums[i + 1] - nums[i];
            if (gap != nums[i + 2] - nums[i + 1]) {
                continue;
            }
            ++count;
            for (int j = i + 3; j < len; ++j) {
                if (nums[j] - nums[j - 1] != gap) {
                    break;
                }
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(slt.numberOfArithmeticSlices(new int[]{1})); // 1
    }

}

/**
Ques: 等差数列划分
Link: https://leetcode-cn.com/problems/arithmetic-slices/

如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7]和[3, -1, -5, -9]都是等差数列。
给你一个整数数组nums，返回数组nums中所有为等差数组的子数组个数。
子数组是数组中的一个连续序列。

示例1：
输入：nums = [1, 2, 3, 4]
输出：3
解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4]和[1, 2, 3, 4]自身。

示例2：
输入：nums = [1]
输出：0

提示：
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

*/
