package In.House.Q22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//    private List[] cache = new ArrayList[9];
//    public List<String> generateParenthesis(int n) {
//        return generate(n);
//    }
//    private List<String> generate(int n) {
//        if (cache[n] != null) {
//            return cache[n];
//        }
//        ArrayList<String> result = new ArrayList<>();
//        if (n == 0) {
//            result.add("");
//        } else {
//            for (int c = 0; c < n; ++c) {
//                for (String left: generate(c)) {
//                    for (String right: generate(n - 1 - c)) {
//                        result.add("(" + left + ")" + right);
//                    }
//                }
//            }
//        }
//        cache[n] = result;
//        return result;
//    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        buildBrackets(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void buildBrackets(List<String> result, StringBuilder builder, int opened, int closed, int limit) {
        if (builder.length() == limit * 2) {
            result.add(builder.toString());
            return ;
        }
        if (opened < limit) {
            builder.append('(');
            buildBrackets(result, builder, opened + 1, closed, limit);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (closed < opened) {
            builder.append(')');
            buildBrackets(result, builder, opened, closed + 1, limit);
            builder.deleteCharAt(builder.length() - 1);
        }
        return ;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.generateParenthesis(3).forEach(s -> System.out.print(s + " ")); // ["((()))", "(()())", "(())()", "()(())", "()()()"]
        System.out.println();
        slt.generateParenthesis(1).forEach(s -> System.out.print(s + " ")); // ["()"]
        System.out.println();
    }

}



