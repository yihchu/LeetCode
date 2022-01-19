package In.House.Q1576;

public class Solution {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        char[] alters = new char[] {'a', 'b', 'c'};
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (chars[i] != '?') {
                continue;
            }
            for (int j = 0; j < 3; ++j) {
                if (i != 0 && chars[i - 1] == alters[j]) {
                    continue;
                }
                if (i != len - 1 && chars[i + 1] == alters[j]) {
                    continue;
                }
                chars[i] = alters[j];
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.modifyString("?zs")); // azs
        System.out.println(slt.modifyString("ubv?w")); // "ubvaw"
        System.out.println(slt.modifyString("j?qg??b")); // "jaqgacb"
        System.out.println(slt.modifyString("??yw?ipkj?")); // "acywaipkja"
    }

}

/**
Ques: 替换所有的问号
Link: https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

给你一个仅包含小写英文字母和'?'字符的字符串s，请你将所有的'?'转换为若干小写字母，使最终的字符串不包含任何连续重复的字符。
注意：你不能修改非'?'字符。
题目测试用例保证除'?'字符之外，不存在连续重复的字符。
在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。

示例1：
输入：s = "?zs"
输出："azs"
解释：该示例共有25种解决方案，从"azs" 到"yzs"都是符合题目要求的。只有"z"是无效的修改，因为字符串"zzs"中有连续重复的两个'z'。

示例2：
输入：s = "ubv?w"
输出："ubvaw"
解释：该示例共有24种解决方案，只有替换成"v"和"w"不符合题目要求。因为"ubvvw"和"ubvww"都包含连续重复的字符。

示例3：
输入：s = "j?qg??b"
输出："jaqgacb"

示例4：
输入：s = "??yw?ipkj?"
输出："acywaipkja"

提示：
1 <= s.length <= 100
s仅包含小写英文字母和'?'字符

*/