package In.House.Q686;


public class Solution {

    // 还是简单粗暴的管用
    public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int len = 2 * a.length() + b.length();
        int l = 0;
        while (l < len) {
            l += a.length();
            builder.append(a);
            if (l >= b.length() && builder.toString().contains(b)) {
                return l / a.length();
            }
        }
        return -1;
    }

//    // 超时
//    public int repeatedStringMatch(String a, String b) {
//        if (a.contains(b)) {
//            return 1;
//        }
//        int len = a.length(), llen = b.length();
//        List<Integer> ks = new ArrayList<>();
//        for (int k = 0; k < len; ++k) {
//            int i = k, j = 0;
//            boolean flag = false;
//            while (i < len && j < len) {
//                if (a.charAt(i ++) == b.charAt(j ++)) {
//                    flag = true;
//                    continue;
//                }
//                flag = false;
//                break;
//            }
//            if (i == len && flag) {
//                ks.add(k);
//            }
//        }
//        if (ks.size() == 0) {
//            return -1;
//        }
//        for (int k: ks) {
//            int result = 1;
//            String str = a.substring(k);
//            while (str.length() < llen) {
//                str += a;
//                ++result;
//            }
//            if (str.contains(b)) {
//                return result;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println(slt.repeatedStringMatch("a", "aa")); // 2
        System.out.println(slt.repeatedStringMatch("a", "a")); // 1
        System.out.println(slt.repeatedStringMatch("abc", "wxyz")); // -1
        System.out.println(slt.repeatedStringMatch("aa", "a")); // 1
        System.out.println(slt.repeatedStringMatch("abc", "cabcabca")); // 4
        System.out.println(slt.repeatedStringMatch("abaabaa", "abaababaab")); // -1
    }

}

/**
Link: https://leetcode-cn.com/problems/repeated-string-match/

给定两个字符串a和b，寻找重复叠加字符串a的最小次数，使得字符串b成为叠加后的字符串a的子串，如果不存在则返回-1。
注意：字符串"abc"重复叠加0次是""，重复叠加1次是"abc"，重复叠加2次是"abcabc"。

示例1：
输入：a = "abcd", b = "cdabcdab"
输出：3
解释：a重复叠加三遍后为"abcdabcdabcd", 此时b是其子串。

示例2：
输入：a = "a", b = "aa"
输出：2

示例3：
输入：a = "a", b = "a"
输出：1

示例4：
输入：a = "abc", b = "wxyz"
输出：-1

提示：
1 <= a.length <= 10^4
1 <= b.length <= 10^4
a和b由小写英文字母组成

*/