package In.House.Q524;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String str: dictionary) {
            if (!isSubString(s, str)) {
                continue;
            }
            result = result.length() < str.length() || (result.length() == str.length() && str.compareTo(result) < 0) ? str : result;
        }
        return result;
    }

    private boolean isSubString(String str, String s) {
        int l = 0, r = 0;
        while (l < str.length() && r < s.length()) {
            if (str.charAt(l) == s.charAt(r)) {
                ++l;
                ++r;
            } else {
                ++l;
            }
        }
        return r == s.length();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"))); // apple
        System.out.println(slt.findLongestWord("abpcplea", Arrays.asList("a", "b", "c"))); // a
    }

}

/**
Link: https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/

给你一个字符串s和一个字符串数组dictionary作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除s中的某些字符得到。
如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。

示例1：
输入：s = "abpcplea", dictionary = ["ale", "apple", "monkey", "plea"]
输出："apple"

示例2：
输入：s = "abpcplea", dictionary = ["a", "b", "c"]
输出："a"

提示：
1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s和dictionary[i]仅由小写英文字母组成

*/
