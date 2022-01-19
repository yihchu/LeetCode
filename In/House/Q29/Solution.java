package In.House.Q29;

public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        long a = dividend;
        long b = divisor;
        boolean flag = (a > 0 && b > 0) || (a < 0 && b < 0) ? true : false;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        if (a < b) {
            return 0;
        }
        int result = divide(a, b, 1);
        return flag ? result : -result;
    }

    public int divide(long dividend, long divisor, int result) {
        long tmp = divisor;
        while (dividend >= (tmp + tmp) ) {
            result = result + result;
            tmp = tmp + tmp;
        }
        if (dividend - tmp >= divisor) {
            return result + divide(dividend - tmp, divisor, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.divide(10, 3)); // 3
        System.out.println(slt.divide(7, -3)); // -2
        System.out.println(slt.divide(-7, 3)); // -2
        System.out.println(slt.divide(-7, -3));// 2
        System.out.println(slt.divide(1, 1));  // 1
        System.out.println(slt.divide(-2147483648, 1)); // -2147483648
        System.out.println(slt.divide(-2147483648, -1));// 2147483647
        System.out.println(slt.divide(1, -2147483648)); // 0
        System.out.println(slt.divide(-1, -2147483648));// 0
    }

}

/**
Ques: 两数相除
Link: https://leetcode-cn.com/problems/divide-two-integers

给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。
返回被除数dividend除以除数divisor得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2

示例1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
被除数和除数均为32位有符号整数。
除数不为0。
假设我们的环境只能存储32位有符号整数，其数值范围是[−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回2^31 − 1。
*/