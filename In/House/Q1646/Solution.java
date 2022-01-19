package In.House.Q1646;

public class Solution {

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        int max = -1, limit = n / 2;
        for (int i = 1; i <= limit; ++i) {
            int idx = i * 2;
            array[idx] = array[i];
            max = max < array[idx] ? array[idx] : max;
            idx += 1;
            if (idx <= n) {
                array[idx] = array[i] + array[i + 1];
                max = max < array[idx] ? array[idx] : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.getMaximumGenerated(7)); // 3
        System.out.println(slt.getMaximumGenerated(2)); // 1
        System.out.println(slt.getMaximumGenerated(3)); // 2
    }

}


/**
Ques: 获取生成数组中的最大值
Link: https://leetcode-cn.com/problems/get-maximum-in-generated-array/

给你一个整数n。按下述规则生成一个长度为n + 1的数组nums：
nums[0] = 0
nums[1] = 1
当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
返回生成数组nums中的最大值。

示例1：
输入：n = 7
输出：3
解释：根据规则：
  nums[0] = 0
  nums[1] = 1
  nums[(1 * 2) = 2] = nums[1] = 1
  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
  nums[(2 * 2) = 4] = nums[2] = 1
  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
  nums[(3 * 2) = 6] = nums[3] = 2
  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
因此，nums = [0, 1, 1, 2, 1, 3, 2, 3]，最大值3

示例2：
输入：n = 2
输出：1
解释：根据规则，nums[0]、nums[1]和nums[2]之中的最大值是1

示例3：
输入：n = 3
输出：2
解释：根据规则，nums[0]、nums[1]、nums[2]和nums[3]之中的最大值是2

提示：
0 <= n <= 100

*/