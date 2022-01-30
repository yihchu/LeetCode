package In.House.Q20;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
                continue;
            }
            if (c == ')' ) {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (c == ']' ) {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (c == '}' ) {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isValid("()")); // true
        System.out.println(slt.isValid("()[]{}")); // true
        System.out.println(slt.isValid("(]")); // false
        System.out.println(slt.isValid("([)]")); // false
        System.out.println(slt.isValid("{[]}")); // true
    }

}

/**
Link: https://leetcode-cn.com/problems/valid-parentheses/
Ques: 有效的括号

给定一个只包括'('，')'，'{'，'}'，'['，']'的字符串s，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

示例1：
输入：s = "()"
输出：true

示例2：
输入：s = "()[]{}"
输出：true

示例3：
输入：s = "(]"
输出：false

示例4：
输入：s = "([)]"
输出：false

示例5：
输入：s = "{[]}"
输出：true

提示：
1 <= s.length <= 10^4
s仅由括号'()[]{}'组成

*/