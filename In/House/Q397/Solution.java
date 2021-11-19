package In.House.Q397;

public class Solution {

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return integerReplacement(n - 1);
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        for (int i = 1; i < 20; ++i) {
            System.out.println(">>>>> i = " + i + " => " + slt.integerReplacement(i));
        }
        System.out.println(">>>>> 2147483647 = 2147483647 => " + slt.integerReplacement(2147483647));
    }

}

/**
Link: https://leetcode-cn.com/problems/integer-replacement/

给定一个正整数n ，你可以做如下操作：
如果n是偶数，则用n / 2替换n。
如果n是奇数，则可以用n + 1或n - 1替换n。
n变为1所需的最小替换次数是多少？

示例1：
输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1

示例2：
输入：n = 7
输出：4
解释：7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1

示例3：
输入：n = 4
输出：2

提示：
1 <= n <= 2^31 - 1
*/