package In.House.Q17;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    private final List<String> list = new ArrayList<>() {{
        add("");     add("abc"); add("def");
        add("ghi");  add("jkl"); add("mno");
        add("pqrs"); add("tuv"); add("wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) {
            return new ArrayList<>();
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add("");
        for (int i = 0; i < len; ++i) {
            String letters = list.get(digits.charAt(i) - '0' - 1);
            Queue<String> tmp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                String str = queue.poll();
                for (char c: letters.toCharArray()) {
                    tmp.add(str + c);
                }
            }
            queue = tmp;
        }
        return queue.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.letterCombinations("23").stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        slt.letterCombinations("").stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        slt.letterCombinations("2").stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}

