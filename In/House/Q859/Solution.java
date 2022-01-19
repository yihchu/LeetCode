package In.House.Q859;

import java.util.*;

public class Solution {

    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        boolean repeated = false;
        Character c1 = null, c2 = null;
        int count = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (!repeated) {
                if (set.contains(c)) {
                    repeated = true;
                } else {
                    set.add(c);
                }
            }
            if(c == goal.charAt(i)) {
                continue;
            }
            ++count;
            if (Objects.isNull(c1)) {
                c1 = c;
                c2 = goal.charAt(i);
            } else if (c2 != c || c1 != goal.charAt(i)) {
                return false;
            }
        }
        return count == 2 || (count == 0 && repeated);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.buddyStrings("ab", "ba")); // true
        System.out.println(slt.buddyStrings("ab", "ab")); // false
        System.out.println(slt.buddyStrings("aa", "aa")); // true
        System.out.println(slt.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(slt.buddyStrings("abac", "abad")); // false
    }

}

/**
Ques: 亲密字符串
Link: https://leetcode-cn.com/problems/buddy-strings/

给你两个字符串s和goal，只要我们可以通过交换s中的两个字母得到与goal相等的结果，就返回true；否则返回false。
交换字母的定义是：取两个下标i和j（下标从 0 开始）且满足i != j，接着交换s[i]和s[j]处的字符。
例如，在"abcd"中交换下标0和下标2的元素可以生成"cbad"。

示例1：
输入：s = "ab", goal = "ba"
输出：true
解释：你可以交换s[0] = 'a'和s[1] = 'b'生成"ba"，此时s和goal相等。

示例2：
输入：s = "ab", goal = "ab"
输出：false
解释：你只能交换s[0] = 'a'和s[1] = 'b'生成"ba"，此时s和goal不相等。

示例3：
输入：s = "aa", goal = "aa"
输出：true
解释：你可以交换s[0] = 'a'和s[1] = 'a'生成"aa"，此时s和goal相等。

示例4：
输入：s = "aaaaaaabc", goal = "aaaaaaacb"
输出：true

提示：
1 <= s.length, goal.length <= 2 * 10^4
s和goal由小写英文字母组成

*/
