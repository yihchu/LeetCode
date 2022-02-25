package In.House.Q43;

public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2;
        int[] arr = new int[len];
        for (int i = len1 - 1; i > -1; --i) {
            for (int j = len2 - 1; j > -1; --j) {
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = len - 1; i > 0; --i) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int idx = arr[0] == 0 ? 1 : 0;
        StringBuilder builder = new StringBuilder();
        while (idx < len) {
            builder.append(arr[idx ++]);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.multiply("2", "3")); // "6"
        System.out.println(slt.multiply("123", "456")); // "56088"
    }

}


/**
Ques: 字符串相乘
Link: https://leetcode-cn.com/problems/multiply-strings/

给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的BigInteger库或直接将输入转换为整数。

示例1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例2:
输入: num1 = "123", num2 = "456"
输出: "56088"

提示：
1 <= num1.length, num2.length <= 200
num1和num2只能由数字组成。
num1和num2都不包含任何前导零，除了数字0本身。
*/