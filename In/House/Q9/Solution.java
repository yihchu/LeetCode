package In.House.Q9;

public class Solution {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l ++) != str.charAt(r --)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isPalindrome(121)); // true
        System.out.println(slt.isPalindrome(-121)); // false
        System.out.println(slt.isPalindrome(10)); // false
        System.out.println(slt.isPalindrome(-101)); // false
    }

}

/**
Link: https://leetcode-cn.com/problems/palindrome-number/

给你一个整数x，如果x是一个回文整数，返回true；否则，返回false。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121是回文，而123不是。

示例1：
输入：x = 121
输出：true

示例2：
输入：x = -121
输出：false
解释：从左向右读, 为-121。 从右向左读, 为121-。因此它不是一个回文数。

示例3：
输入：x = 10
输出：false
解释：从右向左读, 为01。因此它不是一个回文数。

示例4：
输入：x = -101
输出：false

提示：
-2^31 <= x <= 2^31 - 1
*/