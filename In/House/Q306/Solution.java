package In.House.Q306;


// 心情烦躁，抄作业
public class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++ secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++ secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isAdditiveNumber("112358")); // true
        System.out.println(slt.isAdditiveNumber("199100199")); // true
    }

}

/**
Link: https://leetcode-cn.com/problems/additive-number/

累加数是一个字符串，组成它的数字可以形成累加序列。
一个有效的累加序列必须至少包含3个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
给你一个只包含数字'0'-'9'的字符串，编写一个算法来判断给定输入是否是累加数。如果是，返回true；否则，返回false。
说明：累加序列里的数不会以0开头，所以不会出现1, 2, 03或者1, 02, 3的情况。

示例1：
输入："112358"
输出：true
解释：累加序列为: 1, 1, 2, 3, 5, 8。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

示例2：
输入："199100199"
输出：true
解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199

提示：
1 <= num.length <= 35
num仅由数字（0 - 9）组成

进阶：你计划如何处理由过大的整数输入导致的溢出?

*/