package In.House.Q720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String longestWord(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() != s2.length() ? s1.length() - s2.length() : s2.compareTo(s1));
        Set<String> set = new HashSet<>() {{ add(""); }};
        String result = "";
        for (String word: words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestWord(new String[] {"w", "wo", "wor", "worl", "world"}));
        System.out.println(slt.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

}

/**
Ques: 词典中最长的单词
Link: https://leetcode-cn.com/problems/longest-word-in-dictionary/

给出一个字符串数组words组成的一本英语词典。返回words中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。

示例1：
输入：words = ["w", "wo", "wor", "worl", "world"]
输出："world"
解释：单词"world"可由"w", "wo", "wor", 和"worl"逐步添加一个字母组成。

示例2：
输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释："apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"

提示：
1 <= words.length <= 1000
1 <= words[i].length <= 30
所有输入的字符串words[i]都只包含小写字母。

*/
