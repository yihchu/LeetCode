package In.House.Q5;

public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int max = 1, idx = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int l = 2; l <= len; ++l) {
            for (int i = 0; i < len; ++i) {
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                dp[i][j] = chars[i] != chars[j] ? false : (j - i < 3 ? true : dp[i + 1][j - 1]);
                if (!dp[i][j] || j - i + 1 <= max) {
                    continue;
                }
                max = j - i + 1;
                idx = i;
            }
        }
        return s.substring(idx, idx + max);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestPalindrome("babad")); // bab
        System.out.println(slt.longestPalindrome("cbbd")); // bb
        System.out.println(slt.longestPalindrome("a")); // a
        System.out.println(slt.longestPalindrome("ac")); // a
        System.out.println(slt.longestPalindrome("abb")); // bb
    }

}

/**
Link: https://leetcode-cn.com/problems/longest-palindromic-substring/

给你一个字符串s，找到s中最长的回文子串。

示例1：
输入：s = "babad"
输出："bab"
解释："aba"同样是符合题意的答案。

示例2：
输入：s = "cbbd"
输出："bb"

示例3：
输入：s = "a"
输出："a"

示例4：
输入：s = "ac"
输出："a"

提示：
1 <= s.length <= 1000
s仅由数字和英文字母（大写和/或小写）组成

*/