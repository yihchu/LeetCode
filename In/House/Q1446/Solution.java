package In.House.Q1446;

public class Solution {

    public int maxPower(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int count = 1, max = 0;
        char c = s.charAt(0);
        for (int i = 1; i < len; ++i) {
            char tmp = s.charAt(i);
            if (c == tmp) {
                ++count;
                continue;
            }
            max = max < count ? count : max;
            c = tmp;
            count = 1;
        }
        max = max < count ? count : max;
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxPower("leetcode")); // 2
        System.out.println(slt.maxPower("abbcccddddeeeeedcba")); // 5
        System.out.println(slt.maxPower("triplepillooooow")); // 5
        System.out.println(slt.maxPower("hooraaaaaaaaaaay")); // 11
        System.out.println(slt.maxPower("tourist")); // 1
        System.out.println(slt.maxPower("cc")); // 2
    }

}

/**
Link: https://leetcode-cn.com/problems/consecutive-characters/

给你一个字符串s，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

请你返回字符串的能量。

示例 1：
输入：s = "leetcode"
输出：2
解释：子字符串"ee"长度为2，只包含字符'e'。

示例2：
输入：s = "abbcccddddeeeeedcba"
输出：5
解释：子字符串"eeeee"长度为5，只包含字符'e'。

示例3：
输入：s = "triplepillooooow"
输出：5

示例4：
输入：s = "hooraaaaaaaaaaay"
输出：11

示例5：
输入：s = "tourist"
输出：1

提示：
1 <= s.length <= 500
s只包含小写英文字母。
*/