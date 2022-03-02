package In.House.Q564;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n), result = -1;
        List<Long> candidates = getCandidates(n);
        for (long candidate: candidates) {
            if (candidate != num) {
                if (result == -1 ||
                        Math.abs(candidate - num) < Math.abs(result - num) ||
                        Math.abs(candidate - num) == Math.abs(result - num) && candidate < result) {
                    result = candidate;
                }
            }
        }
        return Long.toString(result);
    }

    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<>() {{
            add((long) Math.pow(10, len - 1) - 1);
            add((long) Math.pow(10, len) + 1);
        }};
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; ++i) {
            StringBuilder builder = new StringBuilder();
            String prefix = String.valueOf(i);
            builder.append(prefix);
            StringBuilder suffix = new StringBuilder(prefix).reverse();
            builder.append(suffix.substring(len & 1));
            candidates.add(Long.parseLong(builder.toString()));
        }
        return candidates;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.nearestPalindromic("123")); // "121"
        System.out.println(slt.nearestPalindromic("1")); // "0"
    }

}

/**
Ques：寻找最近的回文数
Link：https://leetcode-cn.com/problems/find-the-closest-palindrome/

给定一个表示整数的字符串n，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
“最近的”定义为两个整数差的绝对值最小。

示例1:
输入: n = "123"
输出: "121"

示例2:
输入: n = "1"
输出: "0"
解释: 0和2是最近的回文，但我们返回最小的，也就是0。

提示:
1 <= n.length <= 18
n只由数字组成
n不含前导0
n代表在[1, 10^18 - 1]范围内的整数

*/