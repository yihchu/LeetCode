package In.House.Q318;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxProduct(String[] words) {
        Map<String, Map<Character, Boolean>> map = new HashMap<>();
        for (String word: words) {
            Map<Character, Boolean> tmp = new HashMap<>();
            for (int i = 0; i < word.length(); ++i) {
                tmp.put(word.charAt(i), true);
            }
            map.put(word, tmp);
        }
        int result = 0, len = words.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                boolean flag = true;
                for (char c = 'a'; c <= 'z'; ++c) {
                    Map<Character, Boolean> m1 = map.get(words[i]);
                    Map<Character, Boolean> m2 = map.get(words[j]);
                    if (m1.containsKey(c) && m2.containsKey(c)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int tmp = words[i].length() * words[j].length();
                    result = result < tmp ? tmp : result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})); // 16
        System.out.println(slt.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})); // 4
        System.out.println(slt.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})); // 0
    }

}


/**
Ques: 最大单词长度乘积
Link: https://leetcode-cn.com/problems/maximum-product-of-word-lengths/

给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回0。

示例1:
输入: ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
输出: 16
解释: 这两个单词为"abcw", "xtfn"。

示例2:
输入: ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
输出: 4
解释: 这两个单词为"ab", "cd"。

示例3:
输入: ["a", "aa", "aaa", "aaaa"]
输出: 0
解释: 不存在这样的两个单词。

提示：
2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i]仅包含小写字母

*/