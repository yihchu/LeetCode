package In.House.Q8;

public class Solution {

    public int myAtoi(String s) {
        long result = 0;
        boolean nFlag = false;
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char firstChar = s.charAt(0);
        if (firstChar == '-' || firstChar == '+') {
            s = s.substring(1);
            nFlag = firstChar == '-' ? true : false;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            builder.append(currentChar);
        }
        if (builder.length() == 0) {
            return 0;
        }
        try {
            result = Long.parseLong(builder.toString());
            result = nFlag ? -result : result;
            result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
            result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result;
        } catch (Exception e) {
            return nFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int)result;
    }

    public static void main(String[] args) {

        Solution slt = new Solution();

        String str1 = "-91283472332";
        String str2 = "words and 987";
        String str3 = "4193 with words";
        String str4 = "   -42";
        String str5 = "42";
        String str6 = "20000000000000000000";
        System.out.println(">>>>> " + str1 + " -> " + slt.myAtoi(str1));
        System.out.println(">>>>> " + str2 + " -> " + slt.myAtoi(str2));
        System.out.println(">>>>> " + str3 + " -> " + slt.myAtoi(str3));
        System.out.println(">>>>> " + str4 + " -> " + slt.myAtoi(str4));
        System.out.println(">>>>> " + str5 + " -> " + slt.myAtoi(str5));
        System.out.println(">>>>> " + str6 + " -> " + slt.myAtoi(str6));
    }
}


/**
QUes: 字符串转换整数(atoi)
Link: https://leetcode-cn.com/problems/string-to-integer-atoi/submissions/

请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个32位有符号整数（类似C/C++中的atoi函数）。
函数myAtoi(string s)的算法如下：
读入字符串并丢弃无用的前导空格
检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。确定最终结果是负数还是正数。如果两者都不存在，则假定结果为正。
读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为0。必要时更改符号（从步骤2开始）。
如果整数数超过32位有符号整数范围[−2^31, 2^31 − 1]，需要截断这个整数，使其保持在这个范围内。具体来说，小于−2^31的整数应该被固定为−2^31，大于2^31 − 1的整数应该被固定为2^31 − 1。
返回整数作为最终结果。
注意：
本题中的空白字符只包括空格字符' '。
除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。

示例1：
输入：s = "42"
输出：42
解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
第1步："42"（当前没有读入字符，因为没有前导空格）
       ^
第2步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
       ^
第3步："42"（读入 "42"）
         ^
解析得到整数 42 。
由于"42"在范围[-2^31, 2^31 - 1]内，最终结果为42。

示例2：
输入：s = "   -42"
输出：-42
解释：
第1步："   -42"（读入前导空格，但忽视掉）
          ^
第2步："   -42"（读入 '-' 字符，所以结果应该是负数）
           ^
第3步："   -42"（读入 "42"）
             ^
解析得到整数-42。
由于"-42"在范围[-2^31, 2^31 - 1]内，最终结果为-42。

示例3：
输入：s = "4193 with words"
输出：4193
解释：
第1步："4193 with words"（当前没有读入字符，因为没有前导空格）
       ^
第2步："4193 with words"（当前没有读入字符，因为这里不存在'-'或者'+'）
       ^
第3步："4193 with words"（读入"4193"；由于下一个字符不是一个数字，所以读入停止）
           ^
解析得到整数4193。
由于"4193"在范围[-2^31, 2^31 - 1]内，最终结果为4193。

示例4：
输入：s = "words and 987"
输出：0
解释：
第1步："words and 987"（当前没有读入字符，因为没有前导空格）
       ^
第2步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
       ^
第3步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
       ^
解析得到整数0，因为没有读入任何数字。
由于0在范围[-2^31, 2^31 - 1]内，最终结果为0。

示例5：
输入：s = "-91283472332"
输出：-2147483648
解释：
第1步："-91283472332"（当前没有读入字符，因为没有前导空格）
       ^
第2步："-91283472332"（读入'-'字符，所以结果应该是负数）
        ^
第3步："-91283472332"（读入"91283472332"）
                   ^
解析得到整数-91283472332。
由于-91283472332小于范围[-2^31, 2^31 - 1]的下界，最终结果被截断为-2^31 = -2147483648。

提示：
0 <= s.length <= 200
s由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-'和'.'组成

*/