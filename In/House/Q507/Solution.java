package In.House.Q507;

public class Solution {

    public boolean checkPerfectNumber(int num) {
        if (num <= 2) {
            return num == 1 ? true : false;
        }
        int k = num / 2, sum = 1;
        for (int i = 2; i <= k; ++i) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.checkPerfectNumber(28)); // true
        System.out.println(slt.checkPerfectNumber(6)); // true
        System.out.println(slt.checkPerfectNumber(496)); // true
        System.out.println(slt.checkPerfectNumber(8128)); // true
        System.out.println(slt.checkPerfectNumber(2)); // false
    }

}

/**
Ques: 完美数
Link: https://leetcode-cn.com/problems/perfect-number/

对于一个正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为「完美数」。
给定一个整数n，如果是完美数，返回true，否则返回false

示例1：
输入：num = 28
输出：true
解释：28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, 和14是28的所有正因子。

示例2：
输入：num = 6
输出：true

示例3：
输入：num = 496
输出：true

示例4：
输入：num = 8128
输出：true

示例5：
输入：num = 2
输出：false

提示：
1 <= num <= 10^8

*/