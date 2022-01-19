package In.House.Q3;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        Set<Character> set = new HashSet<>();
        int max = 0, start = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                continue;
            }
            max = max < set.size() ? set.size(): max;
            while (true) {
                char cc = s.charAt(start ++);
                if (cc != c) {
                    set.remove(cc);
                    continue;
                }
                break;
            }
        }
        max = max < set.size() ? set.size(): max;
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(slt.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(slt.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(slt.lengthOfLongestSubstring("")); // 0
    }

}


/**
Ques: 无重复字符的最长子串
Link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。

示例1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是"abc"，所以其长度为3。

示例2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是"b"，所以其长度为1。

示例3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为3。
请注意，你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。

示例4:
输入: s = ""
输出: 0

提示：
0 <= s.length <= 5 * 10^4
s由英文字母、数字、符号和空格组成

*/