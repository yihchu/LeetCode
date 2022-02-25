package In.House.Q537;

public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split("\\+");
        String[] arr2 = num2.split("\\+");
        int a = Integer.valueOf(arr1[0]) * Integer.valueOf(arr2[0]) - Integer.valueOf(rmvI(arr1[1])) * Integer.valueOf(rmvI(arr2[1]));
        int b = Integer.valueOf(arr1[0]) * Integer.valueOf(rmvI(arr2[1])) + Integer.valueOf(rmvI(arr1[1])) * Integer.valueOf(arr2[0]);
        return a + "+" + b + "i";
    }

    private String rmvI(String str) {
        return str.substring(0, str.length() - 1);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.complexNumberMultiply("1+1i", "1+1i")); // "0+2i"
        System.out.println(slt.complexNumberMultiply("1+-1i", "1+-1i")); // "0+-2i"
    }

}

/**
Ques: 复数乘法
Link: https://leetcode-cn.com/problems/complex-number-multiplication/

复数可以用字符串表示，遵循"实部+虚部i"的形式，并满足下述条件：
实部是一个整数，取值范围是[-100, 100]
虚部也是一个整数，取值范围是[-100, 100]
i^2 == -1
给你两个字符串表示的复数num1和num2，请你遵循复数表示形式，返回表示它们乘积的字符串。

示例1：
输入：num1 = "1+1i", num2 = "1+1i"
输出："0+2i"
解释：(1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i，你需要将它转换为0+2i的形式。

示例2：
输入：num1 = "1+-1i", num2 = "1+-1i"
输出："0+-2i"
解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i，你需要将它转换为0+-2i的形式。

提示：
num1和num2都是有效的复数表示。
*/
