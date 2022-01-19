package In.House.Q516;

public class Solution {

//    // 超时
//    public int longestPalindromeSubseq(String s) {
//        return lcs(s, 0, s.length() - 1);
//    }
//
//    public int lcs(String s, int l, int r) {
//        if (l == s.length()  || r == -1) {
//            return 0;
//        }
//        if (s.charAt(l) == s.charAt(r)) {
//            return lcs(s, l + 1, r - 1) + 1;
//        } else {
//            return Math.max(lcs(s, l, r - 1), lcs(s, l + 1, r));
//        }
//    }


    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] map = new int[len][len];
        int l = 0, r = len - 1;
        for (int i = 0; i < len; ++i) {
            for (int j = len - 1; j >= 0; --j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - 1 < 0 || j + 1 > len - 1) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 1 + map[i - 1][j + 1];
                    }
                } else {
                    map[i][j] = Math.max(i - 1 < 0 ? 0 : map[i - 1][j], j + 1 > len - 1 ? 0 : map[i][j + 1]);
                }
            }
        }
        return map[len - 1][0];
    }

//    // 官方
//    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            dp[i][i] = 1;
//            char c1 = s.charAt(i);
//            for (int j = i + 1; j < n; j++) {
//                char c2 = s.charAt(j);
//                if (c1 == c2) {
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                } else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[0][n - 1];
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestPalindromeSubseq("bbbab")); // 4
        System.out.println(slt.longestPalindromeSubseq("cbbd")); // 2
        System.out.println(slt.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
    }

}

/**
Ques: 最长回文子序列
Link: https://leetcode-cn.com/problems/longest-palindromic-subsequence

给你一个字符串s，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

示例1：
输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为"bbbb"。

示例2：
输入：s = "cbbd"
输出：2
解释：一个可能的最长回文子序列为"bb"。

提示：
1 <= s.length <= 1000
s仅由小写英文字母组成

*/