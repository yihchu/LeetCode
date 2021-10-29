package In.House.Q930;

import java.util.Arrays;

public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            int len = nums.length;
            int s = 0, sum = 0;
            boolean allZero = true;
            for (int i = 0; i < len; ++i) {
                if (nums[i] == 1) {
                    allZero = false;
                    sum += find(Arrays.copyOfRange(nums, s, i), goal);
                    s = i + 1;
                }
            }
            if (!allZero) {
                sum += find(Arrays.copyOfRange(nums, s, len), goal);
                return sum;
            }
        }
        return find(nums, goal);
    }

    public int find(int[] nums, int goal) {
        int len = nums.length, result = 0;
        if (len < 1) {
            return result;
        }
        int l = 0, r = 0, sum = 0;
        for (; r < len; ++r) {
            sum += nums[r];
            if (sum == goal) {
                result = 1;
                break;
            }
        }
        if (result < 1) {
            return result;
        }
        if (l == r && goal == 0) result = 0;
        int t = 0;
        while (r < len) {
            if (t == 0) {
                while (l + t <= r && nums[l + t] == 0) {
                    ++t;
                }
                result += t;
            }

            if (r + 1 < len) {
                ++r;
                t += (l == r - t ? 1 : 0);
                if (nums[r] == 0) {
                    result += (t +  (l == r - t + 1? 0 : 1) );
                } else {
                    l += (t + 1);
                    t = 0;
                    ++result;
                }
            } else {
                r = len;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)); // 4
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 1, 0, 0, 0}, 1)); // 8
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0)); // 15
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 0, 1, 0}, 0)); // 4
        System.out.println(slt.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0)); // 27
        System.out.println(slt.numSubarraysWithSum(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 1)); // 27

    }

}
/**
Link: https://leetcode-cn.com/problems/binary-subarrays-with-sum/

给你一个二元数组nums，和一个整数goal，请你统计并返回有多少个和为goal的非空子数组。
子数组是数组的一段连续部分。

示例1：
输入：nums = [1, 0, 1, 0, 1], goal = 2
输出：4
解释：
如下面黑体所示，有4个满足题目要求的子数组：
[1, 0, 1, 0, 1]
[1, 0, 1, 0, 1]
[1, 0, 1, 0, 1]
[1, 0, 1, 0, 1]

示例2：
输入：nums = [0, 0, 0, 0, 0], goal = 0
输出：15

提示：
1 <= nums.length <= 3 * 10^4
nums[i]不是0就是1
0 <= goal <= nums.length

*/