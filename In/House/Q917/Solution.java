package In.House.Q917;

import java.util.Stack;

public class Solution {

//    // 遍历两遍
//    public String reverseOnlyLetters(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//        int len = chars.length;
//        for (int i = 0; i < len; ++i) {
//            char c = chars[i];
//            if (c >= 'a' && c <= 'z' || c >= 'A' && c <='Z') {
//                stack.add(c);
//                chars[i] = 1;
//            }
//        }
//        for (int i = 0; i < len; ++i) {
//            if (chars[i] == 1) {
//                chars[i] = stack.pop();
//            }
//        }
//        return new String(chars);
//    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (true) {
            while (l < r && !(chars[l] >= 'a' && chars[l] <= 'z' || chars[l] >= 'A' && chars[l] <= 'Z')) {
                ++l;
            }
            while (l < r && !(chars[r] >= 'a' && chars[r] <= 'z' || chars[r] >= 'A' && chars[r] <= 'Z')) {
                --r;
            }
            if (l >= r) {
                break;
            }
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            ++l;
            --r;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.reverseOnlyLetters("ab-cd")); // "dc-ba"
        System.out.println(slt.reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"
        System.out.println(slt.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // "Qedo1ct-eeLg=ntse-T!"
        System.out.println(slt.reverseOnlyLetters("-")); // "-"
    }

}

/**
Ques: 仅仅反转字母
Link: https://leetcode-cn.com/problems/reverse-only-letters/

给你一个字符串s，根据下述规则反转字符串：
所有非英文字母保留在原有位置。
所有英文字母（小写或大写）位置反转。
返回反转后的s。

示例1：
输入：s = "ab-cd"
输出："dc-ba"

示例2：
输入：s = "a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"

示例3：
输入：s = "Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"

提示
1 <= s.length <= 100
s仅由ASCII值在范围[33, 122]的字符组成
s不含'\"'或'\\'

*/
