package In.House.Q446;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int count = 0;
        Map<Long, Integer>[] map = new Map[len];
        for (int i = 0; i < len; ++i) {
            map[i] = new HashMap<>();
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = nums[i] - nums[j];
                int tmp = map[j].getOrDefault(d, 0);
                count += tmp;
                map[i].put(d, map[i].getOrDefault(d, 0) + tmp + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(slt.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }

}


/**
Ques: 等差数列划分II-子序列
Link: https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/

给你一个整数数组nums，返回nums中所有等差子序列的数目。
如果一个序列中至少有三个元素，并且任意两个相邻元素之差相同，则称该序列为等差序列。
例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7]和[3, -1, -5, -9]都是等差序列。
再例如，[1, 1, 2, 5, 7]不是等差序列。
数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
例如，[2, 5, 10]是[1, 2, 1, 2, 4, 1, 5, 10]的一个子序列。
题目数据保证答案是一个32-bit整数。

示例1：
输入：nums = [2, 4, 6, 8, 10]
输出：7
解释：所有的等差子序列为：
[2, 4, 6]
[4, 6, 8]
[6, 8, 10]
[2, 4, 6, 8]
[4, 6, 8, 10]
[2, 4, 6, 8, 10]
[2, 6, 10]

示例2：
输入：nums = [7, 7, 7, 7, 7]
输出：16
解释：数组中的任意子序列都是等差子序列。

提示：
1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1

*/