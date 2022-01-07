package In.House.Q1614;

public class Solution {

    public int maxDepth(String s) {
        int count = 0, max = Integer.MIN_VALUE, len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                ++count;
            } else if (s.charAt(i) == ')') {
                --count;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxDepth("(1+(2*3)+((8)/4))+1")); // 3
        System.out.println(slt.maxDepth("(1)+((2))+(((3)))")); // 3
        System.out.println(slt.maxDepth("1+(2*3)/(2-1)")); // 1
        System.out.println(slt.maxDepth("1")); // 0
    }

}

/**
Link: https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/

如果字符串满足以下条件之一，则可以称之为有效括号字符串（valid parentheses string，可以简写为VPS）：
字符串是一个空字符串""，或者是一个不为"("或")"的单字符。
字符串可以写为AB（A与B字符串连接），其中A和B都是有效括号字符串。
字符串可以写为(A)，其中A是一个有效括号字符串。
类似地，可以定义任何有效括号字符串S的嵌套深度depth(S)：

depth("") = 0
depth(C) = 0，其中C是单个字符的字符串，且该字符不是"("或者")"
depth(A + B) = max(depth(A), depth(B))，其中A和B都是有效括号字符串
depth("(" + A + ")") = 1 + depth(A)，其中A是一个有效括号字符串
例如：""、"()()"、"()(()())"都是有效括号字符串（嵌套深度分别为0、1、2），而")("、"(()"都不是有效括号字符串。
给你一个有效括号字符串s，返回该字符串的s嵌套深度 。

示例1：
输入：s = "(1+(2*3)+((8)/4))+1"
输出：3
解释：数字8在嵌套的3层括号中。

示例2：
输入：s = "(1)+((2))+(((3)))"
输出：3

示例3：
输入：s = "1+(2*3)/(2-1)"
输出：1

示例4：
输入：s = "1"
输出：0

提示：
1 <= s.length <= 100
s由数字0-9和字符'+'、'-'、'*'、'/'、'('、')'组成
题目数据保证括号表达式s是有效的括号表达式

*/