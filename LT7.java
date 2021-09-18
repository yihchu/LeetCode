public class LT7 {

    public int reverse(int x) {
        boolean flag = x < 0;
        x = x < 0 ? -x : x;
        String str = "" + x;
        if (x < 0) return 0;
        str = new StringBuffer(str).reverse().toString();
        long result = Long.parseLong(str);
        if (flag) result = -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) result = 0;
        return (int)result;
    }

    public static void main(String[] args) {
        LT7 lt7 = new LT7();
        System.out.println(lt7.reverse(1245));
    }

}


/**
Link: https://leetcode-cn.com/problems/reverse-integer/

给你一个32位的有符号整数x，返回将x中的数字部分反转后的结果。
如果反转后整数超过32位的有符号整数的范围[−2^31, 2^31− 1]，就返回0。
假设环境不允许存储64位整数（有符号或无符号）。

示例1：
输入：x = 123
输出：321

示例2：
输入：x = -123
输出：-321

示例3：
输入：x = 120
输出：21

示例4：
输入：x = 0
输出：0

提示：
-2^31 <= x <= 2^31 - 1

*/