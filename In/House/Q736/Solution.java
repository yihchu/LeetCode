package In.House.Q736;

import java.util.*;

// CV大法
public class Solution {

    private Map<String, Deque<Integer>> scope = new HashMap<>();
    private int start = 0;

    public int evaluate(String expression) {
        return innerEvaluate(expression);
    }

    private int innerEvaluate(String expression) {
        if (expression.charAt(this.start) != '(') {
            if (Character.isLowerCase(expression.charAt(this.start))) {
                String var = parseVar(expression);
                return this.scope.get(var).peek();
            } else {
                return parseInt(expression);
            }
        }
        int result = 0;
         ++ this.start;
        if (expression.charAt(this.start) == 'l') {
            this.start += 4;
            List<String> vars = new ArrayList<>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(this.start))) {
                    result = innerEvaluate(expression);
                    break;
                }
                String var = parseVar(expression);
                if (expression.charAt(this.start) == ')') {
                    result = this.scope.get(var).peek();
                    break;
                }
                vars.add(var);
                ++ this.start;
                int e = innerEvaluate(expression);
                this.scope.putIfAbsent(var, new ArrayDeque<>());
                this.scope.get(var).push(e);;
                ++ this.start;
            }
            for (String var: vars) {
                this.scope.get(var).pop();
            }
        } else if (expression.charAt(this.start) == 'a') {
            this.start += 4;
            int e1 = innerEvaluate(expression);
            ++ this.start;
            int e2 = innerEvaluate(expression);
            result = e1 + e2;
        } else if (expression.charAt(this.start) == 'm') {
            this.start += 5;
             int e1 = innerEvaluate(expression);
            ++ this.start;
            int e2 = innerEvaluate(expression);
            result = e1 * e2;
        }
        ++ this.start;
        return result;
    }

    private String parseVar(String expression) {
        int len = expression.length();
        StringBuilder builder = new StringBuilder();
        while (this.start < len && expression.charAt(this.start) != ' ' && expression.charAt(this.start) != ')') {
            builder.append(expression.charAt(this.start ++));
        }
        return builder.toString();
    }

    private int parseInt(String expression) {
        int len = expression.length();
        int result = 0;
        boolean isNeg = false;
        if (expression.charAt(this.start) == '-') {
            isNeg = true;
            ++ this.start;
        }
        while (this.start < len && Character.isDigit(expression.charAt(this.start))) {
            result = result * 10 + (expression.charAt(this.start) - '0');
            ++ this.start;
        }
        return isNeg ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))")); // 14
        System.out.println(new Solution().evaluate("(let x 3 x 2 x)")); // 2
        System.out.println(new Solution().evaluate("(let x 1 y 2 x (add x y) (add x y))")); // 5
    }

}
