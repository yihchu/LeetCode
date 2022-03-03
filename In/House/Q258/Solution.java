package In.House.Q258;

public class Solution {

    public int addDigits(int num) {
        while (true) {
            int result = 0;
            while (num > 0) {
                result += num % 10;
                num /= 10;
            }
            if (result < 10) {
                return result;
            }
            num = result;
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.addDigits(38)); // 2
        System.out.println(slt.addDigits(0)); // 0
    }

}

/**
Ques: 各位相加
Link: https://leetcode-cn.com/problems/add-digits/

给定一个非负整数num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。

示例1:
输入: num = 38
输出: 2
解释: 各位相加的过程为：
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
由于2是一位数，所以返回2。

示例2:
输入: num = 0
输出: 0

提示：
0 <= num <= 2^31 - 1

进阶：你可以不使用循环或者递归，在O(1)时间复杂度内解决这个问题吗？

*/