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

/**
Ques: 电话号码的字母组合
Link: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。

示例1：
输入：digits = "23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

示例2：
输入：digits = ""
输出：[]

示例3：
输入：digits = "2"
输出：["a", "b", "c"]

提示：
0 <= digits.length <= 4
digits[i]是范围['2', '9']的一个数字。

*/