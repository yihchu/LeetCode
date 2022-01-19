package In.House.Q301;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // 勉强可以提交
    public List<String> removeInvalidParentheses(String s) {
        int len = s.length();
        int count = invalidNum(s, len);
        Set<String> result = new HashSet<>();
        List<Set<Integer>> indexes = new LinkedList<>();
        traverse(0, 0, count, len, new Stack<>(), indexes, s);
        for (Set<Integer> idxes: indexes) {
            Stack<Character> stack = new Stack<>();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                char c = s.charAt(i);
                if (idxes.contains(i)) {
                    continue;
                }
                builder.append(c);
                if (c == '(') {
                    stack.add('(');
                }
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.add(')');
                    }
                }
            }
            if (stack.isEmpty() && builder.length() == (len - count)) {
                result.add(builder.toString());
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    private void traverse(int count, int start, int target, int size,
                          Stack<Integer> stack, List<Set<Integer>> result, String s){
        if(count == target) {
            result.add(stack.stream().collect(Collectors.toSet()));
            return;
        }
        for(int i = start + 1; i <= size; i++){
            char c = s.charAt(i - 1);
            if (c != '(' && c != ')') {
                continue;
            }
            stack.add(i - 1);
            traverse(count + 1, i, target, size, stack, result, s);
            stack.pop();
        }
    }

    private int invalidNum(String s, int len) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add('(');
                continue;
            }
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(')');
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution slt = new Solution(); // ["(())()","()()()"]
        System.out.print("()())() -> ");
        slt.removeInvalidParentheses("()())()").forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print("(a)())() -> "); // ["(a())()", "(a)()()"]
        slt.removeInvalidParentheses("(a)())()").forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print(")( -> "); // [""]
        slt.removeInvalidParentheses(")(").forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print("x( -> "); // ["x"]
        slt.removeInvalidParentheses("x(").forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.print(")))())((p((())a(())( -> "); // [()((p(())a))", "()p((())a())", "()((p))a(())", "()p(())a(())", "()(p())a(())", "()(p(())a())", "()(p((())a))", "()((p())a())"]
        slt.removeInvalidParentheses(")))())((p((())a(())(").forEach(s -> System.out.print(s + " "));
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(">>>>> cost = " + (end - start));
    }

}

/**
Ques: 删除无效的括号
Link: https://leetcode-cn.com/problems/remove-invalid-parentheses/

给你一个由若干括号和字母组成的字符串s，删除最小数量的无效括号，使得输入的字符串有效。
返回所有可能的结果。答案可以按任意顺序返回。

示例1：
输入：s = "()())()"
输出：["(())()","()()()"]

示例2：
输入：s = "(a)())()"
输出：["(a())()", "(a)()()"]

示例3：
输入：s = ")("
输出：[""]

提示：
1 <= s.length <= 25
s由小写英文字母以及括号'('和')'组成
s中至多含20个括号
*/