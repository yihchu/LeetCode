package In.House.Q1486;

public class Solution {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result ^= (start + (i << 1));
        }
        return result;
//        return IntStream.range(0, n).map(i -> start + (i << 1)).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.xorOperation(5, 0)); // [0, 2, 4, 6, 8]
        System.out.println(slt.xorOperation(4, 3)); // [3, 5, 7, 9]
        System.out.println(slt.xorOperation(1, 7)); // [7]
        System.out.println(slt.xorOperation(10, 5));// [0, 2, 4, 6, 8, 10, 20, 40, 80, 160]
    }

}


/**
Ques: 数组异或操作
Link: https://leetcode-cn.com/problems/xor-operation-in-an-array/

给你两个整数，n和start。
数组nums定义为：nums[i] = start + 2 * i（下标从0开始）且n == nums.length。
请返回nums中所有元素按位异或（XOR）后得到的结果。

示例1：
输入：n = 5, start = 0
输出：8
解释：数组nums为[0, 2, 4, 6, 8]，其中(0 ^ 2 ^ 4 ^ 6 ^ 8) = 8。"^"为按位异或XOR运算符。

示例2：
输入：n = 4, start = 3
输出：8
解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.

示例3：
输入：n = 1, start = 7
输出：7

示例4：
输入：n = 10, start = 5
输出：2

提示：
1 <= n <= 1000
0 <= start <= 1000
n == nums.length

*/