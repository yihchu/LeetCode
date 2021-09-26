public class LT371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = (a ^ b);
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        LT371 lt371 = new LT371();
        System.out.println(lt371.getSum(1, 2)); // 3
        System.out.println(lt371.getSum(2, 3)); // 5
        System.out.println(lt371.getSum(0, 3)); // 3
        System.out.println(lt371.getSum(2, 0)); // 2
        System.out.println(lt371.getSum(-1, 1)); // 0
    }

}

/**
Link: https://leetcode-cn.com/problems/sum-of-two-integers/

给你两个整数a和b，不使用运算符+和-，计算并返回两整数之和。

示例1：
输入：a = 1, b = 2
输出：3

示例2：
输入：a = 2, b = 3
输出：5

提示：
-1000 <= a, b <= 1000
*/