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

