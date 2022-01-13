package In.House.Q747;

public class Solution {

    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int a = 0, b = 1;
        if (nums[a] < nums[b]) { // a >= b
            a = 1;
            b = 0;
        }
        for (int i = 2; i < len; ++i) {
            if (nums[i] > nums[a]) {
                b = a;
                a = i;
            } else if (nums[i] > nums[b]) {
                b = i;
            }
        }
        if (nums[b] == 0) {
            return nums[a] != 0 ? a : -1;
        }
        return nums[a] / nums[b] >= 2 ? a : -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.dominantIndex(new int[] {3, 6, 1, 0})); // 1
        System.out.println(slt.dominantIndex(new int[] {1, 2, 3, 4})); // -1
        System.out.println(slt.dominantIndex(new int[] {1})); // 0
        System.out.println(slt.dominantIndex(new int[] {0, 0, 0, 1})); // 0
    }

}

/**
Link: https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/

给你一个整数数组nums，其中总是存在唯一的一个最大整数。
请你找出数组中的最大元素并检查它是否至少是数组中每个其他数字的两倍。如果是，则返回最大元素的下标，否则返回-1。

示例1：
输入：nums = [3, 6, 1, 0]
输出：1
解释：6是最大的整数，对于数组中的其他整数，6大于数组中其他元素的两倍。6的下标是1，所以返回1。

示例2：
输入：nums = [1, 2, 3, 4]
输出：-1
解释：4没有超过3的两倍大，所以返回-1。

示例3：
输入：nums = [1]
输出：0
解释：因为不存在其他数字，所以认为现有数字1至少是其他数字的两倍。

提示：
1 <= nums.length <= 50
0 <= nums[i] <= 100
nums中的最大元素是唯一的

*/