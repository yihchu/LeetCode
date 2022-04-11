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

