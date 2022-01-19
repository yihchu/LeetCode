package In.House.Q453;

import java.util.Arrays;

public class Solution {

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int result = 0, len = nums.length;
        for (int i = 0; i < len; ++i) {
            result += (nums[i] - min);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minMoves(new int[] {1, 2, 3})); // 3
        System.out.println(slt.minMoves(new int[] {1, 1, 1})); // 0
        System.out.println(slt.minMoves(new int[] {5, 6, 8, 8, 5})); // 7
    }

}


/**
Ques: 最小操作次数使数组元素相等
Link: https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/

给你一个长度为n的整数数组，每次操作将会使n - 1个元素增加1。返回让数组所有元素相等的最小操作次数。

示例1：
输入：nums = [1, 2, 3]
输出：3
解释：
只需要3次操作（注意每次操作会增加两个元素的值）：
[1, 2, 3] => [2, 3, 3] => [3, 4, 3] => [4, 4, 4]

示例2：
输入：nums = [1, 1, 1]
输出：0

提示：
n == nums.length
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
答案保证符合32-bit整数
*/