package In.House.Q1984;

import java.util.Arrays;

public class Solution {

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        int len = nums.length, result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < len - k + 1; ++i) {
            result = Math.min(result, nums[i + k - 1] - nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minimumDifference(new int[] {90}, 1)); // 0
        System.out.println(slt.minimumDifference(new int[] {9, 4, 1, 7}, 2)); // 2
    }

}

/**
Ques: 学生分数的最小差值
Link: https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

给你一个下标从0开始的整数数组nums，其中nums[i]表示第i名学生的分数。另给你一个整数k。
从数组中选出任意k名学生的分数，使这k个分数间最高分和最低分的差值达到最小化。
返回可能的最小差值。

示例1：
输入：nums = [90], k = 1
输出：0
解释：选出1名学生的分数，仅有1种方法：
- [90]最高分和最低分之间的差值是90 - 90 = 0
可能的最小差值是0

示例2：
输入：nums = [9, 4, 1, 7], k = 2
输出：2
解释：选出2名学生的分数，有6种方法：
- [9, 4, 1, 7]最高分和最低分之间的差值是9 - 4 = 5
- [9, 4, 1, 7]最高分和最低分之间的差值是9 - 1 = 8
- [9, 4, 1, 7]最高分和最低分之间的差值是9 - 7 = 2
- [9, 4, 1, 7]最高分和最低分之间的差值是4 - 1 = 3
- [9, 4, 1, 7]最高分和最低分之间的差值是7 - 4 = 3
- [9, 4, 1, 7]最高分和最低分之间的差值是7 - 1 = 6
可能的最小差值是2

提示：
1 <= k <= nums.length <= 1000
0 <= nums[i] <= 10^5

*/