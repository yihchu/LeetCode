package In.House.Q16;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int nearest = 100000;
        for (int i = 0; i < len - 2; ++i) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp < target) {
                    ++l;
                } else {
                    --r;
                }
                nearest = Math.abs(target - nearest) > Math.abs(target - tmp) ? tmp : nearest;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.threeSumClosest(new int[] {-1, 2, 1, -4}, 1)); // 2
        System.out.println(slt.threeSumClosest(new int[] {0, 0, 0}, 1)); // 0
    }

}

/**
Ques: 最接近的三数之和
Link: https://leetcode-cn.com/problems/3sum-closest/

给你一个长度为n的整数数组nums和一个目标值target。请你从nums中选出三个整数，使它们的和与target最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。

示例1：
输入：nums = [-1, 2, 1, -4], target = 1
输出：2
解释：与target最接近的和是2(-1 + 2 + 1 = 2)。

示例2：
输入：nums = [0, 0, 0], target = 1
输出：0

提示：
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4

*/