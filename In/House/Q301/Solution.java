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

