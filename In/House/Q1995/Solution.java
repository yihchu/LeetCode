package In.House.Q1995;

import java.util.Arrays;

public class Solution {

    public int countQuadruplets(int[] nums) {
        int len = nums.length, sum = 0;
        for (int a = 0; a < len - 3; ++a) {
            for (int b = a + 1; b < len - 2; ++b) {
                for (int c = b + 1; c < len - 1; ++c) {
                    for (int d = c + 1; d < len; ++d) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ++ sum;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countQuadruplets(new int[] {1, 2, 3, 6})); // 1
        System.out.println(slt.countQuadruplets(new int[] {3, 3, 6, 4, 5})); // 0
        System.out.println(slt.countQuadruplets(new int[] {1, 1, 1, 3, 5})); // 4
        System.out.println(slt.countQuadruplets(new int[] {28, 8, 49, 85, 37, 90, 20, 8})); // 1
    }

}

/**
Link: https://leetcode-cn.com/problems/count-special-quadruplets/

给你一个下标从0开始的整数数组nums，返回满足下述条件的不同四元组(a, b, c, d)的数目：
nums[a] + nums[b] + nums[c] == nums[d]，且
a < b < c < d

示例1：
输入：nums = [1, 2, 3, 6]
输出：1
解释：满足要求的唯一一个四元组是(0, 1, 2, 3)，因为1 + 2 + 3 == 6。

示例2：
输入：nums = [3, 3, 6, 4, 5]
输出：0
解释：[3, 3, 6, 4, 5]中不存在满足要求的四元组。

示例3：
输入：nums = [1, 1, 1, 3, 5]
输出：4
解释：满足要求的4个四元组如下：
- (0, 1, 2, 3): 1 + 1 + 1 == 3
- (0, 1, 3, 4): 1 + 1 + 3 == 5
- (0, 2, 3, 4): 1 + 1 + 3 == 5
- (1, 2, 3, 4): 1 + 1 + 3 == 5

提示：
4 <= nums.length <= 50
1 <= nums[i] <= 100

*/