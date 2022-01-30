package In.House.Q884;

import java.util.*;

public class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str: arr1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str: arr2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.uncommonFromSentences("this apple is sweet", "this apple is sour"))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(slt.uncommonFromSentences("apple apple", "banana"))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
Ques: 两句话中的不常见单词

句子是一串由空格分隔的单词。每个单词仅由小写字母组成。
如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
给你两个句子s1和s2，返回所有不常用单词的列表。返回列表中单词可以按任意顺序组织。

示例1：
输入：s1 = "this apple is sweet", s2 = "this apple is sour"
输出：["sweet","sour"]

示例2：
输入：s1 = "apple apple", s2 = "banana"
输出：["banana"]

提示：
1 <= s1.length, s2.length <= 200
s1和s2由小写英文字母和空格组成
s1和s2都不含前导或尾随空格
s1和s2中的所有单词间均由单个空格分隔

*/